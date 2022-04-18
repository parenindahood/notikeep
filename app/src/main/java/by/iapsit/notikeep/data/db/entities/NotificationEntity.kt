package by.iapsit.notikeep.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import by.iapsit.notikeep.domain.entities.NotificationData

private const val TABLE_NAME = "notifications"
private const val PACKAGE_NAME_COLUMN_NAME = "package_name"
private const val POST_TIME_COLUMN_NAME = "post_time"

@Entity(tableName = TABLE_NAME)
data class NotificationEntity(
    @ColumnInfo(name = PACKAGE_NAME_COLUMN_NAME) val packageName: String,
    val text: String,
    val title: String,
    @ColumnInfo(name = POST_TIME_COLUMN_NAME) val postTime: Long,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)

fun NotificationData.toEntity() = NotificationEntity(packageName, text, title, postTime)

fun NotificationEntity.toModel() = NotificationData(packageName, text, title, postTime)

fun List<NotificationEntity>.toModel() = map { it.toModel() }