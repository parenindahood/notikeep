package by.iapsit.notikeep.data.repositories

import by.iapsit.notikeep.data.db.dao.NotificationsDao
import by.iapsit.notikeep.data.db.dao.PackagesDao
import by.iapsit.notikeep.data.db.entities.toEntity
import by.iapsit.notikeep.data.db.entities.toModel
import by.iapsit.notikeep.domain.entities.NotificationData
import by.iapsit.notikeep.domain.entities.PackageData
import by.iapsit.notikeep.domain.repositories.NotiKeepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class NotiKeepRepositoryImpl(
    private val notificationsDao: NotificationsDao,
    private val packagesDao: PackagesDao
) : NotiKeepRepository {

    override suspend fun saveNotification(notification: NotificationData) =
        notificationsDao.insertNotification(notification.toEntity())

    override suspend fun getNotifications(packageName: String) =
        notificationsDao.getNotifications(packageName).map {
            it.toModel()
        }

    override suspend fun savePackage(packageData: PackageData) =
        packagesDao.insertPackage(packageData.toEntity())

    override suspend fun getPackages(): Flow<List<PackageData>> =
        packagesDao.getPackages().map {
            it.toModel()
        }
}