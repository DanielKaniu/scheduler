package com.example.smsmutall

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.smsmutall.MainActivity as MainActivity1


class WorkerClass(context: Context?, workerParams: WorkerParameters?) :
    Worker(context!!, workerParams!!) {

    override fun doWork(): Result {
        return try {
            //
            // Enter work details to perform on background
            // Log.d is used to for debugging purposes
            Log.d("WorkerClass","It's Working")
            //
            val main: MainActivity1 = com.example.smsmutall.MainActivity()
            main.showToast()
            //
            // Task result
            return Result.success()
        } catch (throwable: Throwable) {
            //
            Log.d("failed", "Error Sending Notification" + throwable.message)
            Result.failure()
        }
    }
}
