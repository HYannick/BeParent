package com.example.yhous.beparent

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.yhous.beparent.onboarding.OnBoardingActivity

/**
 * Created by yannickhoussin on 16/11/2017.
 */
class SplashActivity: AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val intent = Intent(this, OnBoardingActivity::class.java)
    startActivity(intent)
    finish()
  }
}