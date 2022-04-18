package by.iapsit.notikeep.presentation.mvi.navigations

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import by.iapsit.notikeep.R

private const val APPLICATIONS_ROUTE = "application"
private const val FAVOURITES_ROUTE = "favourites"
private const val SETTINGS_ROUTE = "settings"
private const val DETAIL_ROUTE = "detail"

sealed class NavRoutes(val route: String, @StringRes val title: Int?, val icon: ImageVector?) {

    object Applications : NavRoutes(
        APPLICATIONS_ROUTE,
        R.string.bottom_nav_notifications_item_title,
        Icons.Filled.Notifications
    )

    object Favourites : NavRoutes(
        FAVOURITES_ROUTE,
        R.string.bottom_nav_favourites_item_title,
        Icons.Filled.Favorite
    )

    object Settings : NavRoutes(
        SETTINGS_ROUTE,
        R.string.bottom_nav_settings_item_title,
        Icons.Filled.Settings
    )

    object Detail : NavRoutes(
        DETAIL_ROUTE,
        null,
        null
    )
}

val bottomNavigationItems = listOf(
    NavRoutes.Applications,
    NavRoutes.Favourites,
    NavRoutes.Settings
)