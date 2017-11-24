package com.example.yhous.beparent.onboarding


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.transitionseverywhere.Fade
import com.transitionseverywhere.Slide
import com.transitionseverywhere.TransitionManager
import com.transitionseverywhere.TransitionSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.yhous.beparent.CustomDialogFragment
import com.example.yhous.beparent.R
import com.example.yhous.beparent.auth.ConnectActivity
import com.example.yhous.beparent.utils.custom_components.HandleeTextView
import com.example.yhous.beparent.utils.AnimBehaviours
import kotlinx.android.synthetic.main.fragment_connect.*


/**
 * A simple [Fragment] subclass.
 */
class ConnectFragment : Fragment() {
  companion object {
    fun newInstance(board: Board): ConnectFragment {
      val args = Bundle()
      args.putString(BoardHelper.TOP_TEXT, board.topText)
      val fragment = ConnectFragment()
      fragment.arguments = args
      return fragment
    }
  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    val view = inflater!!.inflate(R.layout.fragment_connect, container, false)
    val args = arguments
    val questionName = view.findViewById<HandleeTextView>(R.id.question_name)
    val edUsername = view.findViewById<EditText>(R.id.ed_username)
    questionName.text = args.getString(BoardHelper.TOP_TEXT)
    val goToAuth = view.findViewById<Button>(R.id.btn_auth)

    goToAuth.setOnClickListener {
      AnimBehaviours.animateBtn(goToAuth, activity, 90L)
      val extraUsername = edUsername.text.toString()
      if (!edUsername.text.isEmpty()) {
        val intent = Intent(activity, ConnectActivity::class.java)
        intent.putExtra("pseudo", extraUsername)
        startActivity(intent)
      } else {
        val dialog = CustomDialogFragment()
        val frag = fragmentManager.findFragmentByTag("fragment_edit_name")
        if (frag != null) {
          fragmentManager.beginTransaction().remove(frag).commit();
        }
        dialog.show(fragmentManager, "fragment_edit_name")
      }

    }
    return view
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
  }

}// Required empty public constructor
