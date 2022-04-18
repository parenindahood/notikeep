package by.iapsit.notikeep.domain.di

import by.iapsit.notikeep.domain.usecases.*
import org.koin.dsl.module

val domainModule = module {
    single<GetNotificationsUseCase> { GetNotificationsUseCaseImpl(get()) }
    single<SaveNotificationUseCase> { SaveNotificationUseCaseImpl(get()) }
    single<GetPackagesUseCase> { GetPackagesUseCaseImpl(get()) }
    single<SavePackageUseCase> { SavePackageUseCaseImpl(get()) }
}