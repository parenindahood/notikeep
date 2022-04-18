package by.iapsit.notikeep.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import by.iapsit.notikeep.data.db.dao.NotificationsDao
import by.iapsit.notikeep.data.db.dao.PackagesDao
import by.iapsit.notikeep.data.db.entities.NotificationEntity
import by.iapsit.notikeep.data.db.entities.PackageEntity

@Database(entities = [NotificationEntity::class, PackageEntity::class], version = 1)
abstract class NotificationsDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "notifications"
    }

    abstract fun getNotificationsDao(): NotificationsDao

    abstract fun getPackagesDao(): PackagesDao
}