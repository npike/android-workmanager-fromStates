package net.npike.poc.workmanagertest.workmanager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.delay
import timber.log.Timber

const val Progress = "Progress"

class DownloadApkWorker(
    context: Context,
    params: WorkerParameters
) :
    CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        Timber.d("Starting work")

        for (i in 1..100) {
            setProgress(
                workDataOf(Progress to i)
            )
            delay(1000)
        }

        return Result.success()
    }
}