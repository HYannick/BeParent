package com.example.yhous.beparent.weight


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.yhous.beparent.R


/**
 * A simple [Fragment] subclass.
 */
class WeightFragment : Fragment() {
  companion object {
    fun newInstance() : WeightFragment {
      return WeightFragment()
    }

    val FRAGMENT_SLUG = "weight"
  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater!!.inflate(R.layout.fragment_weight, container, false)
  }

}// Required empty public constructor
