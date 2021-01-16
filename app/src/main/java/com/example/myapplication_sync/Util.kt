package com.example.myapplication_sync

import android.app.Application
import android.util.Log

fun printMe(className: String, functionName: String) {
    Log.d("TrackingMe", "$className $functionName ${Thread.currentThread()} ${Application.getProcessName()}")
}
