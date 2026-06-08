package com.rafario.a100m.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
    val pedidos by pedidoRepository.pedidos.collectAsState(initial = emptyList())
    val coroutineScope = rememberCoroutineScope()

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
                pedidos = pedidos,
                onDeleteOrderClick = { pedidoId ->
                    coroutineScope.launch {
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

        composable(AppRoute.CREATE_ORDER) {
            CreateOrderScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onOrderSaved = { nombre, lineas ->
                    coroutineScope.launch {
                        pedidoRepository.addPedido(nombre, lineas)
                        navController.popBackStack()
                    }
                }
            )
        }

        composable("${AppRoute.EDIT_ORDER}/{pedidoId}") { backStackEntry ->
            val pedidoId = backStackEntry.arguments?.getString("pedidoId")?.toIntOrNull()
            val pedido = pedidos.firstOrNull { it.id == pedidoId }

            CreateOrderScreen(
                pedidoToEdit = pedido,
                onBackClick = {
                    navController.popBackStack()
                },
                onOrderSaved = { nombre, lineas ->
                    if (pedidoId == null) {
                        navController.popBackStack()
                        return@CreateOrderScreen
                    }

                    coroutineScope.launch {
                        pedidoRepository.updatePedido(pedidoId, nombre, lineas)
                        navController.popBackStack()
                    }
                }
            )
        }
    }
}
