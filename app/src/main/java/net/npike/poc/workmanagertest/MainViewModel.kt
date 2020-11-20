package net.npike.poc.workmanagertest

import androidx.lifecycle.ViewModel
import androidx.work.*
import net.npike.poc.workmanagertest.workmanager.DownloadApkWorker
import timber.log.Timber

class MainViewModel(workManager: WorkManager) : ViewModel() {

    val workInfoByTag = workManager.getWorkInfosByTagLiveData("test")

    val workInfoByState = workManager.getWorkInfosLiveData(
        WorkQuery.Builder.fromStates(
            listOf(
                WorkInfo.State.ENQUEUED,
                WorkInfo.State.RUNNING,
                WorkInfo.State.FAILED,
                WorkInfo.State.CANCELLED,
            )
        ).build()
    )

    init {
        val downloadWorkRequest = OneTimeWorkRequestBuilder<DownloadApkWorker>()
            .addTag("test")
            .setConstraints(
                Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
            ).build()

        Timber.d("Enqueue download_1")
        workManager.enqueueUniqueWork("download_1", ExistingWorkPolicy.REPLACE, downloadWorkRequest)
    }
}