package com.example.yhous.beparent.navigation

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import android.widget.RelativeLayout
import com.example.yhous.beparent.R
import com.example.yhous.beparent.board.BoardFragment
import com.transitionseverywhere.TransitionManager


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [NavigationFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [NavigationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
interface SwitchFragments {
  fun onFragmentSwitch(newFragment: Fragment)
}

class NavigationFragment : Fragment() {

  private lateinit var listener: SwitchFragments
  private lateinit var glManager: GridLayoutManager
  private lateinit var adapter: MenuGridAdapter

  companion object {
    fun newInstance(): NavigationFragment {
      return NavigationFragment()
    }
  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    val view = inflater!!.inflate(R.layout.fragment_navigation, container, false)
    val rvGridView = view.findViewById<RecyclerView>(R.id.rv_menu)
    val menuItems = MenuHelper.getMenuItems()

    glManager = GridLayoutManager(activity, 3)
    adapter = MenuGridAdapter(activity, menuItems)
    rvGridView.layoutManager = glManager
    rvGridView.adapter = adapter

    val menuBtn = view.findViewById<ImageView>(R.id.menu_main_btn)
    val goBoard = view.findViewById<ImageView>(R.id.go_board)
    val nav = view.findViewById<RelativeLayout>(R.id.nav)

    var visible = false

    fun changeFragment(listener: SwitchFragments, Frag: Fragment) {
      listener.onFragmentSwitch(BoardFragment.newInstance())
      TransitionManager.beginDelayedTransition(nav)
      rvGridView.visibility = View.GONE
      rvGridView
              .animate()
              .setDuration(200L)
              .translationY(30f).interpolator = AccelerateDecelerateInterpolator()
      visible = false
    }

    menuBtn.setOnClickListener {
      TransitionManager.beginDelayedTransition(nav)
      rvGridView.visibility = if (visible) View.GONE else View.VISIBLE
      rvGridView
              .animate()
              .setDuration(200L)
              .translationY(if (visible) 30f else 0f).interpolator = AccelerateDecelerateInterpolator()
      visible = !visible
    }

    goBoard.setOnClickListener {
      val checkFrag = activity.supportFragmentManager.findFragmentByTag("mainWrapper")
      if(checkFrag !is BoardFragment) {
        changeFragment(listener, BoardFragment.newInstance())
      }
    }

    return view
  }
  override fun onAttach(context: Context?) {
    super.onAttach(context)
    if (context is SwitchFragments) {
      listener = context
    } else {
      throw ClassCastException(context.toString() + " must implement OnRageComicSelected.")
    }
  }
}
