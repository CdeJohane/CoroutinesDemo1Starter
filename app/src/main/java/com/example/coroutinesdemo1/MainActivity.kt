package com.example.coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    //Initialisations
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Design Declarations and initializations
        val textView = findViewById<TextView>(R.id.tvCount)
        val countButton = findViewById<Button>(R.id.btnCount)
        val downloadButton = findViewById<Button>(R.id.btnDownload)

        //setting click listener for the count button
        countButton.setOnClickListener {
            textView.text = count++.toString()
        }

        //Setting click listener for the download button
        downloadButton.setOnClickListener {
            //Create Coroutine
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }
    }
    //Code to download User Data
    //Suspend Used for delays
    //Func created out of class, to be shifted to main activity class
    private suspend fun downloadUserData() {
        for (i in 1..200000) {
            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
            //To delay the output shown in Logcat, use suspend keyword in function, as well as code below
            delay(100)
        }
    }

}

