package by.iapsit.notikeep.domain.usecases

import by.iapsit.notikeep.domain.entities.NotificationData
import by.iapsit.notikeep.domain.repositories.NotiKeepRepository

interface SaveNotificationUseCase {
    suspend operator fun invoke(notification: NotificationData)
}

class SaveNotificationUseCaseImpl(
    private val repository: NotiKeepRepository
) : SaveNotificationUseCase {

    override suspend operator fun invoke(notification: NotificationData) =
        repository.saveNotification(notification)
}