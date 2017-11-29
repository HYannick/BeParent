package com.example.yhous.beparent.auth

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.yhous.beparent.MainActivity
import com.example.yhous.beparent.R
import com.example.yhous.beparent.db.BeParentDbHelper
import com.example.yhous.beparent.db.Message
import com.example.yhous.beparent.utils.AnimBehaviours
import com.example.yhous.beparent.utils.Helpers
import kotlinx.android.synthetic.main.activity_connect.*

class ConnectActivity : AppCompatActivity() {
  private lateinit var pseudo: String
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val sharedPref = getSharedPreferences("beParentData", Context.MODE_PRIVATE)
    val firstCon = sharedPref.getBoolean("firstCon", true)

    setContentView(R.layout.activity_connect)

    if(firstCon && intent.hasExtra("pseudo")) {
      pseudo = intent.getStringExtra("pseudo")
      tv_register.text = Helpers.setTextColor(getString(R.string.registerText, pseudo), "#95D4FC", pseudo)
    } else {
      tv_register.text = getString(R.string.connexionText)
    }

    btn_login.setOnClickListener {
      AnimBehaviours.animateBtn(btn_login, this, 90L)
      addUser()
    }
  }

  fun login() {

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

    // Store in sharedPreference
    val sharedPreferences = getSharedPreferences("beParentData", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean("firstCon", false)
    editor.putString("username", pseudo)
    editor.putString("email", email)
    editor.putString("password", password)
    editor.apply()
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
