package com.example.yhous.beparent.auth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.yhous.beparent.MainActivity
import com.example.yhous.beparent.R
import com.example.yhous.beparent.db.BeParentDbAdapter
import com.example.yhous.beparent.db.BeParentDbHelper
import com.example.yhous.beparent.db.Message
import com.example.yhous.beparent.utils.AnimBehaviours
import com.example.yhous.beparent.utils.Helpers
import kotlinx.android.synthetic.main.activity_connect.*

class ConnectActivity : AppCompatActivity() {
  private lateinit var pseudo: String
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    pseudo = intent.getStringExtra("pseudo")
    setContentView(R.layout.activity_connect)
    tv_register.text = Helpers.setTextColor(getString(R.string.registerText, pseudo), "#95D4FC", pseudo)
    btn_login.setOnClickListener {
      AnimBehaviours.animateBtn(btn_login, this, 90L)
      addUser()
    }
  }

  fun addUser() {
    val email = email_input.text.toString()
    val password = password_input.text.toString()
    val user = Profile(pseudo,email, password)

    val id = BeParentDbHelper(this).storeProfile(user)
    if(id == -1L) {
      Message.print(this,"User couldn't be stored")
    } else {
      Message.print(this,"User successfully stored")
      val intent = Intent(this, MainActivity::class.java)
      startActivity(intent)
    }
  }

//  fun viewUser() {
//    val data = BeParentDbHelper(this).getProfile()
//    Message.print(this,data)
//  }
//
//  fun viewProfile() {
//    val user = id_search.text.toString()
//    val data = BeParentDbHelper(this).getOneUser(user)
//    Message.print(this,data)
//  }
//
//  fun deleteUser() {
//    BeParentDbHelper(this).removeUser("Katrina")
//  }
//
//  fun updateUser() {
//      BeParentDbHelper(this).updateName("Moana", "Arianna")
//  }
}
