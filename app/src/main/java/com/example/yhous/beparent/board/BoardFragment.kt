package com.example.yhous.beparent.board


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.example.yhous.beparent.R
import com.example.yhous.beparent.navigation.NavigationFragment
import com.example.yhous.beparent.news.NewsHelper
import com.example.yhous.beparent.news.NewsPagerAdapter
import com.example.yhous.beparent.utils.AnimBehaviours
import com.example.yhous.beparent.utils.custom_components.ObservableScrollView
import kotlinx.android.synthetic.main.fragment_board.*


/**
 * A simple [Fragment] subclass.
 */
class BoardFragment : Fragment(), ObservableScrollView.OnScrollChangedListener  {

  lateinit var viewPager: ViewPager
  lateinit var pagerAdapter: NewsPagerAdapter
  companion object {
    fun newInstance() : BoardFragment {
      return BoardFragment()
    }
  }
  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    val view = inflater!!.inflate(R.layout.fragment_board, container, false)
    val observable_sv = view.findViewById<ObservableScrollView>(R.id.observable_sv)
    val egg_status = view.findViewById<ImageView>(R.id.egg_status)
    observable_sv.setOnScrollChangedListener(this)
    egg_status.setOnClickListener {
      AnimBehaviours.animateBtn(egg_status, activity, 90L)
    }

    val news = NewsHelper.getNews()
    viewPager = view.findViewById(R.id.vp_news)
    pagerAdapter = NewsPagerAdapter(childFragmentManager, news)
    viewPager.adapter = pagerAdapter
    return view
  }
  override fun onScrollChanged(deltaX: Int, deltaY: Int) {
    val scrollY = observable_sv.scrollY
    main_background.translationY = scrollY * 0.5f
  }

}// Required empty public constructor
