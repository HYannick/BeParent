package com.example.yhous.beparent


import android.os.Bundle
import android.support.v4.app.Fragment
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_onboarding.*

interface Communicator {
  fun respond(data: String)
}

/**
 * A simple [Fragment] subclass.
 */
class OnboardingFragment : Fragment() {

  companion object {
    fun newInstance(): OnboardingFragment {
      return OnboardingFragment()
    }
  }

  var counter: Int = 0
  private lateinit var comm: Communicator
  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    val view : View = inflater!!.inflate(R.layout.fragment_onboarding, container, false)
    return view
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if(savedInstanceState == null) {
      counter = 0
    } else {
      counter = savedInstanceState.getInt("counter")
    }
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    outState.putInt("counter", counter)
  }
  override fun onAttach(context: Context?) {
    super.onAttach(context)

    if (context is Communicator) {
      comm = context
    } else {
      throw ClassCastException(context.toString() + " must implement Communicator.")
    }
  }
}// Required empty public constructor
