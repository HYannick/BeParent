package com.example.yhous.beparent.auth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.yhous.beparent.R
import com.example.yhous.beparent.db.BeParentDbHelper
import com.example.yhous.beparent.utils.Helpers
import kotlinx.android.synthetic.main.activity_connect.*

class ConnectActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val pseudo = intent.getStringExtra("pseudo")
    setContentView(R.layout.activity_connect)
    tv_register.text = Helpers.setTextColor(getString(R.string.registerText, pseudo), "#95D4FC", pseudo)
    val beParentHelper = BeParentDbHelper(this)

    val sqliteDb = beParentHelper.writableDatabase
  }
}
