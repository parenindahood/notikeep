package by.iapsit.notikeep.domain.entities

data class NotificationData(
    val packageName: String,
    val text: String,
    val title: String,
    val postTime: Long
)