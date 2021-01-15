package com.example.myapplication_sync

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
/**
 * A bound Service that instantiates the authenticator
 * when started.
 */
class AuthenticatorService : Service() {

    // Instance field that stores the authenticator object
    private lateinit var mAuthenticator: Authenticator

    override fun onCreate() {
        printme("AuthenticatorService", "onCreate")
        // Create a new authenticator object
        mAuthenticator = Authenticator(this)
    }

    /*
     * When the system binds to this Service to make the RPC call
     * return the authenticator's IBinder.
     */
    override fun onBind(intent: Intent?): IBinder {
        printme("AuthenticatorService", "onBind")
        return mAuthenticator.iBinder
    }
}

