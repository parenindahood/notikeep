package by.iapsit.notikeep.data.di

import androidx.room.Room
import by.iapsit.notikeep.data.db.NotificationsDatabase
import by.iapsit.notikeep.data.db.dao.PackagesDao
import by.iapsit.notikeep.data.repositories.NotiKeepRepositoryImpl
import by.iapsit.notikeep.domain.repositories.NotiKeepRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<NotiKeepRepository> { NotiKeepRepositoryImpl(get(), get()) }
    single {
        Room.databaseBuilder(
            androidContext(),
            NotificationsDatabase::class.java,
            NotificationsDatabase.DATABASE_NAME
        ).build()
    }
    single { get<NotificationsDatabase>().getNotificationsDao() }
    single { get<NotificationsDatabase>().getPackagesDao() }
}