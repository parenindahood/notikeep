package by.iapsit.notikeep.domain.usecases

import by.iapsit.notikeep.domain.entities.NotificationData
import by.iapsit.notikeep.domain.repositories.NotiKeepRepository
import kotlinx.coroutines.flow.Flow

interface GetNotificationsUseCase {
    suspend operator fun invoke(packageName: String): Flow<List<NotificationData>>
}

class GetNotificationsUseCaseImpl(
    private val repository: NotiKeepRepository
) : GetNotificationsUseCase {

    override suspend operator fun invoke(packageName: String) =
        repository.getNotifications(packageName)
}