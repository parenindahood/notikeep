package by.iapsit.notikeep.presentation.services

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import by.iapsit.notikeep.R
import by.iapsit.notikeep.domain.entities.NotificationData
import by.iapsit.notikeep.domain.entities.PackageData
import by.iapsit.notikeep.domain.usecases.SaveNotificationUseCase
import by.iapsit.notikeep.domain.usecases.SavePackageUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class NotificationService : NotificationListenerService() {

    private val serviceJob = Job()
    private val serviceScope = CoroutineScope(Dispatchers.IO + serviceJob)

    private val saveNotification by inject<SaveNotificationUseCase>()
    private val savePackage by inject<SavePackageUseCase>()

    override fun onNotificationPosted(notification: StatusBarNotification?) {
        super.onNotificationPosted(notification)
        serviceScope.launch {
            notification?.toModel()?.let {
                saveNotification(it)
                savePackage(PackageData(it.packageName))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceJob.cancel()
    }

    private fun StatusBarNotification.toModel(): NotificationData = with(notification.extras) {
        val text = getString(Notification.EXTRA_TEXT)
            ?: getString(R.string.notification_no_text_default_value)
        val title = getString(Notification.EXTRA_TITLE)
            ?: getString(R.string.notification_no_title_default_value)
        return NotificationData(packageName, text, title, postTime)
    }
}