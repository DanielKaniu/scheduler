package com.example.smsmutall

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    var workManager: WorkManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        //
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        // Created a Work Request
        //val uploadWorkRequest: WorkRequest = OneTimeWorkRequestBuilder<WorkerClass>().build()
        //
        val periodicWorkRequest =
            PeriodicWorkRequestBuilder<WorkerClass>(15, TimeUnit.MINUTES).build()
        //
        // Submit the WorkRequest to the system
        WorkManager.getInstance(this).enqueue(periodicWorkRequest)
    }

    //
    fun showToast() {
        //
        val textView: TextView = findViewById(R.id.tv)
        //
        //Change the content of the text view.
        textView.text = "Periodic workRequest"
        //
        Toast.makeText(applicationContext, "OneTime", Toast.LENGTH_SHORT).show()
    }
}