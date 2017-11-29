package com.example.yhous.beparent.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.RelativeLayout
import com.example.yhous.beparent.R
import com.example.yhous.beparent.board.BoardFragment
import com.example.yhous.beparent.health_followup.HealthFollowupFragment
import com.transitionseverywhere.TransitionManager
import kotlinx.android.synthetic.main.fragment_navigation.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [NavigationFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [NavigationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
interface SwitchFragments {
  fun switchFragz(newFrag: Fragment)
}

class NavigationFragment : Fragment() {

  private lateinit var listener: SwitchFragments

  companion object {
    fun newInstance(): NavigationFragment {
      return NavigationFragment()
    }
  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    val view = inflater!!.inflate(R.layout.fragment_navigation, container, false)
    val gridView = view.findViewById<GridView>(R.id.gv_menu)
    val menuItems = MenuHelper.getMenuItems()
    val menuLinks = MenuHelper.getLinks()
    val booksAdapter = MenuGridAdapter(activity, menuItems)
    val menuBtn = view.findViewById<ImageView>(R.id.menu_main_btn)
    val goBoard = view.findViewById<ImageView>(R.id.go_board)
    val nav = view.findViewById<RelativeLayout>(R.id.nav)
    var visible = false

    fun changeFragment(Frag: Fragment) {
      listener.switchFragz(Frag)
      TransitionManager.beginDelayedTransition(nav)
      gridView.visibility = View.GONE
      gridView
              .animate()
              .setDuration(200L)
              .translationY(30f).interpolator = AccelerateDecelerateInterpolator()
      visible = !visible
    }
    gridView.adapter = booksAdapter

    gridView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
      if (position < menuLinks.size) {
        changeFragment(HealthFollowupFragment.newInstance())
      }
    }


    menuBtn.setOnClickListener {
      TransitionManager.beginDelayedTransition(nav)
      gridView.visibility = if (visible) View.GONE else View.VISIBLE
      gridView
              .animate()
              .setDuration(200L)
              .translationY(if (visible) 30f else 0f).interpolator = AccelerateDecelerateInterpolator()
      visible = !visible
    }

    goBoard.setOnClickListener {
      Log.d("NavigationFrag", "isAdded $isAdded")
      Log.d("NavigationFrag", "isHidden $isHidden")
      Log.d("NavigationFrag", "isDetached $isDetached")
      Log.d("NavigationFrag", "isStateSaved $isStateSaved")
      Log.d("NavigationFrag", "isVisible $isVisible")
      Log.d("NavigationFrag", "isInLayout $isInLayout")
      if(!isAdded) {
        changeFragment(BoardFragment.newInstance())
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
