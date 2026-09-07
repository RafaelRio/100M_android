package com.rafario.a100m.ui.navigation

import androidx.compose.ui.res.stringResource
import com.rafario.a100m.R
import androidx.compose.runtime.Composable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.rafario.a100m.data.models.Pedido
import kotlinx.coroutines.CancellationException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rafario.a100m.data.repository.PedidoRepository
import com.rafario.a100m.ui.screens.CreateOrderScreen
import com.rafario.a100m.ui.screens.HomeScreen
import com.rafario.a100m.ui.screens.SplashScreen
import kotlinx.coroutines.launch

private object AppRoute {
    const val SPLASH = "splash"
    const val HOME = "home"
    const val CREATE_ORDER = "create_order"
    const val EDIT_ORDER = "edit_order"

    fun editOrder(pedidoId: Int): String = "$EDIT_ORDER/$pedidoId"
}

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()
    val context = LocalContext.current
    val pedidoRepository = remember(context) {
        PedidoRepository(context.applicationContext)
    }
    var pedidos by remember { mutableStateOf<List<Pedido>?>(null) }
    var errorMessage by remember { mutableStateOf<Int?>(null) }
    var readAttempt by remember { mutableStateOf(0) }
    var isSaving by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(pedidoRepository, readAttempt) {
        try {
            pedidoRepository.pedidos.collect { pedidos = it }
        } catch (error: CancellationException) {
            throw error
        } catch (_: Exception) {
            errorMessage = R.string.storage_read_error
        }
    }


    fun saveOrder(action: suspend () -> Unit) {
        if (isSaving) return
        isSaving = true
        coroutineScope.launch {
            try {
                action()
            } catch (error: CancellationException) {
                throw error
            } catch (_: Exception) {
                errorMessage = R.string.storage_write_error
            } finally {
                isSaving = false
            }
        }
    }

    errorMessage?.let { message ->
        AlertDialog(
            onDismissRequest = { errorMessage = null },
            title = { Text(stringResource(R.string.storage_error)) },
            text = { Text(stringResource(message)) },
            confirmButton = {
                TextButton(onClick = {
                    errorMessage = null
                    readAttempt++
                }) { Text(stringResource(R.string.accept)) }
            }
        )
    }

    NavHost(
        navController = navController,
        startDestination = AppRoute.SPLASH
    ) {
        composable(AppRoute.SPLASH) {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate(AppRoute.HOME) {
                        popUpTo(AppRoute.SPLASH) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(AppRoute.HOME) {
            HomeScreen(
                pedidos = pedidos.orEmpty(),
                onDeleteOrderClick = { pedidoId ->
                    saveOrder {
                        pedidoRepository.deletePedido(pedidoId)
                    }
                },
                onEditOrderClick = { pedidoId ->
                    navController.navigate(AppRoute.editOrder(pedidoId))
                },
                onCreateOrderClick = {
                    navController.navigate(AppRoute.CREATE_ORDER)
                }
            )
        }

        composable(AppRoute.CREATE_ORDER) { backStackEntry ->
            CreateOrderScreen(
                isSaving = isSaving,
                onBackClick = {
                    navController.popBackStack()
                },
                onOrderSaved = { nombre, lineas ->
                    saveOrder {
                        pedidoRepository.addPedido(nombre, lineas)
                        if (navController.currentBackStackEntry == backStackEntry) {
                            navController.popBackStack()
                        }
                    }
                }
            )
        }

        composable("${AppRoute.EDIT_ORDER}/{pedidoId}") { backStackEntry ->
            val pedidoId = backStackEntry.arguments?.getString("pedidoId")?.toIntOrNull()
            val loadedPedidos = pedidos
            if (loadedPedidos == null) {
                Text(stringResource(R.string.loading_order))
                return@composable
            }
            val pedido = loadedPedidos.firstOrNull { it.id == pedidoId }
            if (pedido == null) {
                TextButton(onClick = { navController.popBackStack() }) {
                    Text(stringResource(R.string.order_missing))
                }
                return@composable
            }

            CreateOrderScreen(
                isSaving = isSaving,
                pedidoToEdit = pedido,
                onBackClick = {
                    navController.popBackStack()
                },
                onOrderSaved = { nombre, lineas ->
                    if (pedidoId == null) {
                        navController.popBackStack()
                        return@CreateOrderScreen
                    }

                    saveOrder {
                        pedidoRepository.updatePedido(pedidoId, nombre, lineas)
                        if (navController.currentBackStackEntry == backStackEntry) {
                            navController.popBackStack()
                        }
                    }
                }
            )
        }
    }
}
