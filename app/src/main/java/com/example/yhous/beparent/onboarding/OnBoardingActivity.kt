package com.example.yhous.beparent.onboarding

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.example.yhous.beparent.R
import android.support.design.widget.TabLayout
import com.example.yhous.beparent.MainActivity
import com.example.yhous.beparent.auth.ConnectActivity
import com.example.yhous.beparent.db.Message

class OnBoardingActivity : AppCompatActivity() {
  private lateinit var viewPager: ViewPager
  private lateinit var pagerAdapter: BoardPagerAdapter
  private lateinit var tabLayout: TabLayout
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_on_boarding)

    val sharedPrefs = getSharedPreferences("beParentData", Context.MODE_PRIVATE)
    val enableBoards = sharedPrefs.getBoolean("firstCon", true)
    if(enableBoards) {
      val boards = BoardHelper.getBoards()
      viewPager = findViewById(R.id.vp_board)

      tabLayout = findViewById(R.id.tab_layout)
      tabLayout.setupWithViewPager(viewPager, true)

      pagerAdapter = BoardPagerAdapter(supportFragmentManager, boards)
      viewPager.adapter = pagerAdapter
    } else {
      val intent = Intent(this, MainActivity::class.java)
      startActivity(intent)

    }


  }
}
