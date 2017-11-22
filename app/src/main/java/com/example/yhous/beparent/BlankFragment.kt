package com.example.yhous.beparent


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_blank.*


/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : Fragment() {

  lateinit var data: String
  companion object {
    fun newInstance(): BlankFragment {
      return BlankFragment()
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }
  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    val view: View = inflater!!.inflate(R.layout.fragment_blank, container, false)
    if(savedInstanceState == null) {
      data = ""
    } else {
      data = savedInstanceState.getString("text")
      view.findViewById<TextView>(R.id.txtToChange).text = data
    }
    return view
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    outState.putString("text", data)
  }

  fun changeText(data: String) {
    this.data = data
    txtToChange.text = data
  }

}// Required empty public constructor
