package by.iapsit.notikeep.presentation.mvi.ui

import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import by.iapsit.notikeep.R
import by.iapsit.notikeep.presentation.mvi.navigations.NavRoutes
import by.iapsit.notikeep.presentation.mvi.navigations.bottomNavigationItems
import by.iapsit.notikeep.presentation.mvi.ui.common.BottomNavigationBar
import by.iapsit.notikeep.presentation.mvi.ui.common.ComposableReceiver
import by.iapsit.notikeep.presentation.services.NotificationAccessService
import by.iapsit.notikeep.presentation.ui.theme.NotiKeepTheme
import by.iapsit.notikeep.presentation.utils.showSnackBarWithAction
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@Composable
fun NotiKeepApp() {
    NotiKeepTheme {
        val navController = rememberNavController()
        with(rememberSystemUiController()) {
            setStatusBarColor(MaterialTheme.colors.primary)
            setSystemBarsColor(MaterialTheme.colors.primary)
        }
        val scaffoldState = rememberScaffoldState()
        val coroutineScope = rememberCoroutineScope()
        ComposableReceiver(action = NotificationAccessService.NO_NOTIFICATION_ACCESS_ACTION) { _, context ->
            context?.let {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackBarWithAction(
                        message = it.getString(R.string.error_no_notification_access_desc),
                        actionLabel = it.getString(R.string.snackbar_no_notification_access_action_label),
                    ) {
                        it.startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
                    }
                }
            }
        }
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = stringResource(R.string.app_name),
                            style = LocalTextStyle.current.copy(color = Color.White)
                        )
                    },
                    backgroundColor = MaterialTheme.colors.primary
                )
            },
            bottomBar = {
                BottomNavigationBar(
                    navController = navController,
                    bottomNavigationItems
                )
            }
        ) {
            Box(modifier = Modifier.padding(it)) {
                NotiKeepNavGraph(
                    navController = navController,
                    startDestination = NavRoutes.Applications
                )
            }
        }
    }
}
