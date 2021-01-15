package com.example.myapplication_sync

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 * Define a Service that returns an [android.os.IBinder] for the
 * sync adapter class, allowing the sync adapter framework to call
 * onPerformSync().
 */
class SyncService : Service() {
    /*
     * Instantiate the sync adapter object.
     */
    override fun onCreate() {
        /*
         * Create the sync adapter as a singleton.
         * Set the sync adapter as syncable
         * Disallow parallel syncs
         */
        synchronized(sSyncAdapterLock) {
            printme("SyncService", "onCreate")
            sSyncAdaptor = sSyncAdaptor ?: SyncAdaptor(applicationContext, true)
        }
    }

    /**
     * Return an object that allows the system to invoke
     * the sync adapter.
     *
     */
    override fun onBind(intent: Intent): IBinder {
        /*
         * Get the object that allows external processes
         * to call onPerformSync(). The object is created
         * in the base class code when the SyncAdapter
         * constructors call super()
         *
         * We should never be in a position where this is called before
         * onCreate() so the exception should never be thrown
         */
        printme("SyncService", "onBind")
        return sSyncAdaptor?.syncAdapterBinder ?: throw IllegalStateException()
    }


    override fun onDestroy() {
        super.onDestroy()
        printme("SyncService", "onDestroy")
    }

    companion object {
        // Storage for an instance of the sync adapter
        private var sSyncAdaptor: SyncAdaptor? = null
        // Object to use as a thread-safe lock
        private val sSyncAdapterLock = Any()
    }
}
