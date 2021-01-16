package com.example.myapplication_sync

import android.accounts.Account
import android.accounts.AccountManager
import android.app.Application
import android.content.Context

class MainApplication: Application() {
    companion object {
        const val AUTHORITY = "com.example.myapplication_sync.provider"
        const val ACCOUNT_TYPE = "com.example.myapplication_sync.account"
        const val ACCOUNT = "placeholderaccount"
    }

    val account: Account by lazy {
        createSyncAccount()
    }

    override fun onCreate() {
        super.onCreate()
        printMe("MainApplication", "onCreate")
    }

    /**
     * Create a new placeholder account for the sync adapter
     */
    private fun createSyncAccount(): Account {
        val accountManager = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager

        val accounts = accountManager.getAccountsByType(ACCOUNT_TYPE)
        if (accounts.isNotEmpty()) return accounts[0]

        return Account(ACCOUNT, ACCOUNT_TYPE).also { newAccount ->
            /*
             * Add the account and account type, no password or user data
             * If successful, return the Account object, otherwise report an error.
             */
            if (accountManager.addAccountExplicitly(newAccount, null, null)) {
                /*
                 * If you don't set android:syncable="true" in
                 * in your <provider> element in the manifest,
                 * then call context.setIsSyncable(account, AUTHORITY, 1)
                 * here.
                 */
                printMe("newAccount", "addAccountExplicitly")
            } else {
                /*
                 * The account exists or some other error occurred. Log this, report it,
                 * or handle it internally.
                 */
                printMe("newAccount", "addAccountExplicitly")
            }
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        printMe("MainApplication", "onTerminate")
    }
}