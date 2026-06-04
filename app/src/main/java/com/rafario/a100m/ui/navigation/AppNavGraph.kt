package com.rafario.a100m.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rafario.a100m.ui.screens.CreateOrderScreen
import com.rafario.a100m.ui.screens.HomeScreen
import com.rafario.a100m.ui.screens.SplashScreen

private object AppRoute {
    const val SPLASH = "splash"
    const val HOME = "home"
    const val CREATE_ORDER = "create_order"
}

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

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
                onCreateOrderClick = {
                    navController.navigate(AppRoute.CREATE_ORDER)
                }
            )
        }

        composable(AppRoute.CREATE_ORDER) {
            CreateOrderScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
