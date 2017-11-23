package com.example.yhous.beparent.onboarding

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.example.yhous.beparent.R
import android.support.design.widget.TabLayout

class OnBoardingActivity : AppCompatActivity() {
  private lateinit var viewPager: ViewPager
  private lateinit var pagerAdapter: BoardPagerAdapter
  private lateinit var tabLayout: TabLayout
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_on_boarding)

    val boards = BoardHelper.getBoards()
    viewPager = findViewById(R.id.vp_board)

    tabLayout = findViewById(R.id.tab_layout)
    tabLayout.setupWithViewPager(viewPager, true)

    pagerAdapter = BoardPagerAdapter(supportFragmentManager, boards)
    viewPager.adapter = pagerAdapter
  }
}
