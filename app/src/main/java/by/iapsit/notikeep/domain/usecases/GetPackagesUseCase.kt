package by.iapsit.notikeep.domain.usecases

import by.iapsit.notikeep.domain.entities.PackageData
import by.iapsit.notikeep.domain.repositories.NotiKeepRepository
import kotlinx.coroutines.flow.Flow

interface GetPackagesUseCase {
    suspend operator fun invoke(): Flow<List<PackageData>>
}

class GetPackagesUseCaseImpl(
    private val repository: NotiKeepRepository
) : GetPackagesUseCase {

    override suspend operator fun invoke() = repository.getPackages()
}