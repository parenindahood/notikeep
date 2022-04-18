package by.iapsit.notikeep.domain.repositories

import by.iapsit.notikeep.domain.entities.NotificationData
import by.iapsit.notikeep.domain.entities.PackageData
import kotlinx.coroutines.flow.Flow

interface NotiKeepRepository {

    suspend fun saveNotification(notification: NotificationData)

    suspend fun getNotifications(packageName: String): Flow<List<NotificationData>>

    suspend fun savePackage(packageData: PackageData)

    suspend fun getPackages(): Flow<List<PackageData>>
}