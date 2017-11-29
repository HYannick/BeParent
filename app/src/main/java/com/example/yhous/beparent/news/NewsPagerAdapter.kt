package com.example.yhous.beparent.news

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import com.example.yhous.beparent.utils.SmartFragmentStatePagerAdapter

/**
 * Created by yhous on 22/11/2017.
 */
class NewsPagerAdapter(fragmentManager: FragmentManager, private val news: ArrayList<DailyNews>): SmartFragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return DailyNewsFragment.newInstance(news[position])
    }

    override fun getCount(): Int {
        return news.size
    }
}