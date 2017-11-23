package com.example.yhous.beparent.onboarding

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.util.Log
import com.example.yhous.beparent.utils.SmartFragmentStatePagerAdapter

/**
 * Created by yhous on 22/11/2017.
 */
class BoardPagerAdapter(fragmentManager: FragmentManager, private val boards: ArrayList<Board>): SmartFragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return if(position == count - 1) {
            ConnectFragment.newInstance(boards[position])
        } else {
            OnboardingFragment.newInstance(boards[position], position)
        }

    }

    override fun getCount(): Int {
        return boards.size
    }
}