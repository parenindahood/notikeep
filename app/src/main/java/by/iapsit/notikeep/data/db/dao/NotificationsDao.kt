package by.iapsit.notikeep.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.iapsit.notikeep.data.db.entities.NotificationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NotificationsDao {

    @Insert
    suspend fun insertNotification(notificationEntity: NotificationEntity)

    @Query("SELECT * FROM notifications WHERE package_name LIKE :packageName")
    fun getNotifications(packageName: String): Flow<List<NotificationEntity>>
}