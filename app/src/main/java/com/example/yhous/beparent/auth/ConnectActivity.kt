package com.example.yhous.beparent.auth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.yhous.beparent.R
import kotlinx.android.synthetic.main.activity_connect.*

class ConnectActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val pseudo = intent.getStringExtra("pseudo")
    setContentView(R.layout.activity_connect)
    tv_register.text = getString(R.string.registerText, pseudo)
  }
}
