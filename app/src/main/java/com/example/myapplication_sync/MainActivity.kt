package com.example.myapplication_sync

import android.app.Application
import android.content.ContentResolver
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication_sync.MainApplication.Companion.AUTHORITY

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        printme("MainActivity", "onCreate")
    }

    fun onRefreshButtonClick(v: View) {
        printme("MainActivity", "onRefreshButtonClick")
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
}