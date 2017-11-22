package com.example.yhous.beparent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.example.yhous.beparent.onboarding.BoardHelper
import com.example.yhous.beparent.onboarding.BoardPagerAdapter

class OnBoardingActivity : AppCompatActivity() {
  private lateinit var viewPager: ViewPager
  private lateinit var pagerAdapter: BoardPagerAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_on_boarding)

    val boards = BoardHelper.getBoards()
    viewPager = findViewById(R.id.vp_board)
    pagerAdapter = BoardPagerAdapter(supportFragmentManager, boards)
    viewPager.adapter = pagerAdapter
  }
}
