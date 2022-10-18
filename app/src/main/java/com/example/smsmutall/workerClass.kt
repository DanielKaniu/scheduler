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
            // Use the Log class to display some information about the current state of the
            // application.
            Log.i("WorkerClass","It's Working")
            //
            //Call the main activity so that I can use some of its methods.
            val main: MainActivity1 = com.example.smsmutall.MainActivity()
            main.showToast()
            //
            // Return a positive result.
            return Result.success()
        } catch (throwable: Throwable) {
            //
            Log.i("failed", "Error Sending Notification" + throwable.message)
            //
            //Return a negative result.
            Result.failure()
        }
    }
}
