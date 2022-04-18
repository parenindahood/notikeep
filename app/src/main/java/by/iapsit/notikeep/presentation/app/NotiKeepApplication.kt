package by.iapsit.notikeep.presentation.app

import android.app.Application
import by.iapsit.notikeep.data.di.dataModule
import by.iapsit.notikeep.domain.di.domainModule
import by.iapsit.notikeep.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NotiKeepApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NotiKeepApplication)
            modules(dataModule, domainModule, presentationModule)
        }
    }
}