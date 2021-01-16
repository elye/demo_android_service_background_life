package com.example.myapplication_sync

import android.app.Service
import android.content.Intent
import android.os.IBinder

class OtherService: Service() {
    override fun onCreate() {
        super.onCreate()
        printMe("OtherService", "onCreate")

        repeat(100) {
            printMe("OtherService", "running $it")
            Thread.sleep(1000)
        }
        stopSelf()
    }

    override fun onBind(intent: Intent?): IBinder? {
        printMe("OtherService", "onBind")
        return null
    }

    override fun onDestroy() {
        printMe("OtherService", "onDestroy")
        super.onDestroy()
    }
}
