package by.iapsit.notikeep.presentation.mvi.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import by.iapsit.notikeep.presentation.services.NotificationAccessService

class FlowActivity : ComponentActivity() {

    private val notificationAccessServiceIntent by lazy {
        Intent(this, NotificationAccessService::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotiKeepApp()
        }
    }

    override fun onStart() {
        super.onStart()
        startService(notificationAccessServiceIntent)
    }

    override fun onStop() {
        super.onStop()
        stopService(notificationAccessServiceIntent)
    }
}