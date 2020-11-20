package net.npike.poc.workmanagertest.di

import androidx.work.WorkManager
import androidx.work.WorkerParameters
import net.npike.poc.workmanagertest.workmanager.DownloadApkWorker
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.dsl.worker
import org.koin.dsl.module

val workManagerModule = module {
    single {
        WorkManager.getInstance(androidContext())
    }

    worker { (workParams: WorkerParameters) ->
        DownloadApkWorker(
            context = androidApplication(),
            params = workParams
        )
    }
}