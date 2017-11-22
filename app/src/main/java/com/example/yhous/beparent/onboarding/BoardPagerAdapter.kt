package com.example.yhous.beparent.onboarding

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.yhous.beparent.ConnectFragment
import com.example.yhous.beparent.OnboardingFragment

/**
 * Created by yhous on 22/11/2017.
 */
class BoardPagerAdapter(fragmentManager: FragmentManager, private val boards: ArrayList<Board>): FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        if(position == 5) {
            return OnboardingFragment.newInstance(boards[position])
        } else {
            return ConnectFragment.newInstance(boards[position])
        }

    }

    override fun getCount(): Int {
        return boards.size
    }
}