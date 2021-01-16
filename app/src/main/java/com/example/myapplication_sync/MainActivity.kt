package com.example.myapplication_sync

import android.content.ContentResolver
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication_sync.MainApplication.Companion.AUTHORITY

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        printMe("MainActivity", "onCreate")
    }

    fun onSyncButtonClick(v: View) {
        printMe("MainActivity", "onSyncButtonClick")
        // Pass the settings flags by inserting them in a bundle
        val settingsBundle = Bundle().apply {
            putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true)
            putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true)
        }
        /*
         * Request the sync for the default account, authority, and
         * manual sync settings
         */
        ContentResolver.requestSync((application as MainApplication).account, AUTHORITY, settingsBundle)
    }

    fun onMainButtonClick(view: View) {
        printMe("MainActivity", "onMainButtonClick")
        startService(Intent(this, MainService::class.java))
    }

    fun onOtherButtonClick(view: View) {
        printMe("MainActivity", "onOtherButtonClick")
        startService(Intent(this, OtherService::class.java))
    }

    override fun onDestroy() {
        printMe("MainActivity", "onDestroy")
        super.onDestroy()
    }
}