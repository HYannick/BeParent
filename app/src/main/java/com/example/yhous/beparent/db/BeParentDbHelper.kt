package com.example.yhous.beparent.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.sql.SQLException

/**
 * Created by yannickhoussin on 24/11/2017.
 */

class BeParentDbHelper(val context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
  private val SQL_CREATE_ENTRIES =
          "CREATE TABLE ${ProfilEntry.TABLE_NAME} (" +
                  "${ProfilEntry._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                  "${ProfilEntry.NAME_COL} TEXT, " +
                  "${ProfilEntry.EMAIL_COL} TEXT, " +
                  "${ProfilEntry.PASSWORD_COL} TEXT, " +
                  "${ProfilEntry.LABOR_DATE_COL} TEXT" +
                  ")"

  private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${ProfilEntry.TABLE_NAME}"
  override fun onCreate(db: SQLiteDatabase) {
    try {
      db.execSQL(SQL_CREATE_ENTRIES)
      Message.print(context, "DB Created")
    } catch (e: SQLException) {
      e.printStackTrace()
      Message.print(context, "$e")
    }
  }

  override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    try {
      Message.print(context, "DB Upgraded")
      db.execSQL(SQL_DELETE_ENTRIES)
      onCreate(db)
    } catch (e: SQLException) {
      e.printStackTrace()
      Message.print(context, "$e")
    }
  }
}