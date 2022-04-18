package by.iapsit.notikeep.presentation.mvi.ui.common

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import by.iapsit.notikeep.presentation.mvi.navigations.NavRoutes

@Composable
fun BottomNavigationBar(
    navController: NavController,
    items: List<NavRoutes>,
    backgroundColor: Color = MaterialTheme.colors.primary,
    contentColor: Color = Color.White
) {
    BottomNavigation(
        backgroundColor = backgroundColor,
        contentColor = contentColor
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon
                            ?: throw IllegalArgumentException("${screen.route} has no image"),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = stringResource(
                            id = screen.title
                                ?: throw IllegalArgumentException("${screen.route} has no title")
                        )
                    )
                },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
