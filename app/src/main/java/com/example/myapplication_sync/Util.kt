package com.example.myapplication_sync

import android.app.Application
import android.util.Log

fun printme(className: String, functionName: String) {
    Log.d("TrackingMe", "$className $functionName ${Application.getProcessName()}")
}
