package by.iapsit.notikeep.domain.usecases

import by.iapsit.notikeep.domain.entities.PackageData
import by.iapsit.notikeep.domain.repositories.NotiKeepRepository

interface SavePackageUseCase {
    suspend operator fun invoke(packageData: PackageData)
}

class SavePackageUseCaseImpl(
    private val repository: NotiKeepRepository
) : SavePackageUseCase {

    override suspend operator fun invoke(packageData: PackageData) =
        repository.savePackage(packageData)
}