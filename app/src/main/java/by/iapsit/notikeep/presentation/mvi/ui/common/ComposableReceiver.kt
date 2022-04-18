package by.iapsit.notikeep.presentation.mvi.ui.common

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext

@Composable
fun ComposableReceiver(
    action: String,
    onEvent: (intent: Intent?, context: Context?) -> Unit
) {
    val context = LocalContext.current
    val currentOnEvent by rememberUpdatedState(onEvent)
    DisposableEffect(context, action) {
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                currentOnEvent(intent, context)
            }
        }
        context.registerReceiver(receiver, IntentFilter(action))
        onDispose {
            context.unregisterReceiver(receiver)
        }
    }
}
