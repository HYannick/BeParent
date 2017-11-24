package com.example.yhous.beparent.onboarding


import android.os.Bundle
import android.support.v4.app.Fragment
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.yhous.beparent.R
import android.text.Html
import android.text.Spanned


@Suppress("DEPRECATION")
/**
 * A simple [Fragment] subclass.
 */
class OnboardingFragment : Fragment() {

    companion object {
        fun newInstance(board: Board, position: Int): OnboardingFragment {
            val args = Bundle()
            args.putString(BoardHelper.TOP_TEXT, board.topText)
            args.putInt(BoardHelper.RESOURCE_IMG, board.resourceImg)
            args.putString(BoardHelper.BOTTOM_TEXT, board.bottomText)
            args.putInt("position", position)
            val fragment = OnboardingFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_onboarding, container, false)
        val topTitle = view.findViewById<TextView>(R.id.top_text)
        val imgBoard = view.findViewById<ImageView>(R.id.cute_egg)
        val bottomTitle = view.findViewById<TextView>(R.id.bottom_text)

        // Pull args and set values
        val args = arguments

        imgBoard.setImageResource(args.getInt(BoardHelper.RESOURCE_IMG))
        bottomTitle.text = args.getString(BoardHelper.BOTTOM_TEXT)

        val pos = args.getInt("position")

        if(pos == 0) {
            val beParent = args.getString(BoardHelper.TOP_TEXT).replace("Be", "<font color=#95D4FC>Be</font>")
            val customTxt: Spanned = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(beParent, Html.FROM_HTML_MODE_LEGACY)
            }  else {
                Html.fromHtml(beParent)
            }

            topTitle.text = customTxt
            topTitle.textSize = 48f
        } else {
            topTitle.text = args.getString(BoardHelper.TOP_TEXT)
            topTitle.textSize = 20f
        }

        return view
    }
}// Required empty public constructor
