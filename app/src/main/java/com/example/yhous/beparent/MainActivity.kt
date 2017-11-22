package com.example.yhous.beparent


import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.fragment_blank.*

class MainActivity : AppCompatActivity(), Communicator {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
              .add(R.id.rela, OnboardingFragment.newInstance(), "ClickFrag")
              .add(R.id.rela2, BlankFragment.newInstance(), "RecieverFrag")
              .commit()
    }
  }

  override fun respond(data: String) {
    val bFrag: BlankFragment = supportFragmentManager.findFragmentByTag("RecieverFrag") as BlankFragment
    bFrag.changeText(data)
  }
}
