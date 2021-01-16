package com.example.myapplication_sync

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MainService: Service() {
    override fun onCreate() {
        super.onCreate()
        printMe("MainService", "onCreate")

        repeat(100) {
            printMe("MainService", "running $it")
            Thread.sleep(1000)
        }
        stopSelf()
    }

    override fun onBind(intent: Intent?): IBinder? {
        printMe("MainService", "onBind")
        return null
    }

    override fun onDestroy() {
        printMe("MainService", "onDestroy")
        super.onDestroy()
    }
}
