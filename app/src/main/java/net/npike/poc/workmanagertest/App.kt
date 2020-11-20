package net.npike.poc.workmanagertest

import android.app.Application
import net.npike.poc.workmanagertest.di.viewModelsModule
import net.npike.poc.workmanagertest.di.workManagerModule
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {

            androidContext(this@App)
            workManagerFactory()

            modules(
                viewModelsModule + workManagerModule
            )
        }
    }
}