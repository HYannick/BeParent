package com.example.yhous.beparent.db

import android.provider.BaseColumns


const val DATABASE_NAME = "beparent.db"
const val DATABASE_VERSION = 23


object ProfilEntry : BaseColumns {
  const val TABLE_NAME = "profile"
  const val _ID = "_id"
  const val NAME_COL = "name"
  const val EMAIL_COL = "email"
  const val PASSWORD_COL = "password"
  const val LABOR_DATE_COL = "labour_date"
}
