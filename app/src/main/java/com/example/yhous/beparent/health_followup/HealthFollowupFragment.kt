package com.example.yhous.beparent.health_followup


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.Toast

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

  override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
    super.onCreateOptionsMenu(menu, inflater)
    return inflater.inflate(R.menu.main_menu, menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    super.onOptionsItemSelected(item)
    return when (item.getItemId()) {
      R.id.go_board -> {
        Toast.makeText(activity, "board clicked", Toast.LENGTH_SHORT).show();
        true;
      }
      else -> super.onOptionsItemSelected(item);
    }
  }


}// Required empty public constructor
