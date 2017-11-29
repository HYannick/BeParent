package com.example.yhous.beparent.health_followup


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.yhous.beparent.R


/**
 * A simple [Fragment] subclass.
 */
class HealthFollowupFragment : Fragment() {

  companion object {
    fun newInstance() : HealthFollowupFragment {
      return HealthFollowupFragment()
    }
  }
  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater!!.inflate(R.layout.fragment_health_followup, container, false)
  }

}// Required empty public constructor
