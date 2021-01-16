package com.example.myapplication_sync

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

/*
 * Define an implementation of ContentProvider that stubs out
 * all methods
 */
class StubProvider : ContentProvider() {
    /*
     * Always return true, indicating that the
     * provider loaded correctly.
     */
    override fun onCreate(): Boolean {
        printMe("StubProvider", "onCreate")
        return true
    }

    /*
     * Return no type for MIME type
     */
    override fun getType(uri: Uri): String?  = null

    /*
     * query() always returns no results
     *
     */
    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor?  = null

    /*
     * insert() always returns null (no URI)
     */
    override fun insert(uri: Uri, values: ContentValues?): Uri? = null

    /*
     * delete() always returns "no rows affected" (0)
     */
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int = 0

    /*
     * update() always returns "no rows affected" (0)
     */
    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int = 0
}
