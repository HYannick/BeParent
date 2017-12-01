package com.example.yhous.beparent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.yhous.beparent.board.BoardFragment
import com.example.yhous.beparent.navigation.NavigationFragment
import com.example.yhous.beparent.navigation.SwitchFragments


class MainActivity : AppCompatActivity(), SwitchFragments {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    if (savedInstanceState == null) {
      val ft = supportFragmentManager.beginTransaction()
      ft.setCustomAnimations(R.anim.translate_fade_in, R.anim.translate_fade_out)
      ft
              .add(R.id.menu_fragment, NavigationFragment.newInstance(), "menuFragment")
              .replace(R.id.main_container, BoardFragment.newInstance(), "mainWrapper")
              .addToBackStack(null)
              .commit()
    }
  }

  override fun onFragmentSwitch(newFragment: Fragment) {
    val ft = supportFragmentManager.beginTransaction()
    ft.setCustomAnimations(R.anim.translate_fade_in, R.anim.translate_fade_out);
    ft
            .replace(R.id.main_container, newFragment, "mainWrapper")
            .addToBackStack(null)
            .commit()
  }


  override fun onBackPressed() {
    super.onBackPressed()
    Log.d("???", "${supportFragmentManager.getBackStackEntryCount()}")
    if(supportFragmentManager.getBackStackEntryCount() == 0) {
      this.finish()
    }
  }
}
