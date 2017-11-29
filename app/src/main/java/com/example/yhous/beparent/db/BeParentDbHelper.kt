package com.example.yhous.beparent.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.yhous.beparent.auth.Profile

/**
 * Created by yannickhoussin on 25/11/2017.
 */
class BeParentDbHelper(context: Context) {
  private val dbHelper = BeParentDbAdapter(context)

  fun storeProfile(profile: Profile): Long {
    val db = dbHelper.writableDatabase
    val values = ContentValues()
    with(values) {
      put(ProfilEntry.NAME_COL, profile.username)
      put(ProfilEntry.EMAIL_COL, profile.email)
      put(ProfilEntry.PASSWORD_COL, profile.password)
    }
    val id = db.insert(ProfilEntry.TABLE_NAME, null, values)
    Log.d("dbHelper", "stored to the database $profile")
    return id
  }

//  fun getProfile(): String {
//    val db = dbHelper.writableDatabase
//    val columns = arrayOf(ProfilEntry._ID, ProfilEntry.NAME_COL, ProfilEntry.PASSWORD_COL, ProfilEntry.EMAIL_COL, ProfilEntry.LABOR_DATE_COL)
//    val cursor: Cursor = db.doQuery(ProfilEntry.TABLE_NAME, columns)
//
//    val buffer = StringBuffer()
//    while (cursor.moveToNext()) {
//      val id = cursor.getInt(ProfilEntry._ID)
//      val name = cursor.getString(ProfilEntry.NAME_COL)
//      val email = cursor.getString(ProfilEntry.EMAIL_COL)
//      val password = cursor.getString(ProfilEntry.PASSWORD_COL)
//      val labour = cursor.getString(ProfilEntry.LABOR_DATE_COL)
//
//      buffer.append("$id --> name: $name, email: $email, password: $password, labour: $labour \n")
//    }
//    cursor.close()
//    return buffer.toString()
//  }
//
//  fun getOneUser(name: String) : String {
//    val db = dbHelper.writableDatabase
//    val columns = arrayOf(ProfilEntry._ID)
//    val selectionArgs = arrayOf(name)
//    val cursor: Cursor = db.doQuery(ProfilEntry.TABLE_NAME, columns, "${ProfilEntry.NAME_COL} =?", selectionArgs)
//    val buffer = StringBuffer()
//    while (cursor.moveToNext()) {
//      val id = cursor.getInt(ProfilEntry._ID)
//
//      buffer.append("$id")
//    }
//    cursor.close()
//    return buffer.toString()
//  }
//
//  fun removeUser(toDelete: String) : Int{
//    val db = dbHelper.writableDatabase
//    val whereArgs = arrayOf(toDelete)
//    val count = db.delete(ProfilEntry.TABLE_NAME, "${ProfilEntry.NAME_COL} =? ", whereArgs)
//    return count
//  }
//
//  fun updateName(oldName: String, newName: String): Int {
//    val db = dbHelper.writableDatabase
//    val contentValues = ContentValues()
//    contentValues.put(ProfilEntry.NAME_COL, newName)
//    val whereArgs = arrayOf(oldName)
//    val count = db.update(ProfilEntry.TABLE_NAME, contentValues, "${ProfilEntry.NAME_COL} =? ", whereArgs)
//    return count
//  }
}


private fun Cursor.getInt(columnName: String) = getInt(getColumnIndex(columnName))
private fun Cursor.getString(columnName: String) = getString(getColumnIndex(columnName))
private fun SQLiteDatabase.doQuery(table: String, columns: Array<String>, selection: String? = null, selecionArgs: Array<String>? = null, groupBy: String? = null, having: String? = null, orderBy: String? = null): Cursor {
  return query(table, columns, selection, selecionArgs, groupBy, having, orderBy)
}



//private inline fun <T> SQLiteDatabase.transaction(function: SQLiteDatabase.() -> T): T {
//  beginTransaction()
//  val result = try {
//    val returnValue = function()
//    setTransactionSuccessful()
//    returnValue
//  } finally {
//    endTransaction()
//  }
//  close()
//  return result
//}