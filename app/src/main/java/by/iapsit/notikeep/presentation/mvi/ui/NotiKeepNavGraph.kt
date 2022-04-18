package by.iapsit.notikeep.presentation.mvi.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import by.iapsit.notikeep.presentation.mvi.navigations.NavRoutes
import by.iapsit.notikeep.presentation.mvi.ui.applications.ApplicationsScreen
import by.iapsit.notikeep.presentation.mvi.ui.detail.DetailScreen
import by.iapsit.notikeep.presentation.mvi.ui.favourites.FavouritesScreen
import by.iapsit.notikeep.presentation.mvi.ui.settings.SettingsScreen

@Composable
fun NotiKeepNavGraph(navController: NavHostController, startDestination: NavRoutes) {
    NavHost(navController = navController, startDestination = startDestination.route) {
        composable(NavRoutes.Applications.route) {
            ApplicationsScreen()
        }
        composable(NavRoutes.Detail.route) {
            DetailScreen()
        }
        composable(NavRoutes.Favourites.route) {
            FavouritesScreen()
        }
        composable(NavRoutes.Settings.route) {
            SettingsScreen()
        }
    }
}