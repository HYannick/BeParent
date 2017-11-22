package com.example.yhous.beparent


import android.os.Bundle
import android.support.v4.app.Fragment
import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.yhous.beparent.onboarding.Board
import com.example.yhous.beparent.onboarding.BoardHelper

/**
 * A simple [Fragment] subclass.
 */
class OnboardingFragment : Fragment() {

    companion object {
        fun newInstance(board: Board): OnboardingFragment {
            val args = Bundle()
            args.putString(BoardHelper.TOP_TEXT, board.topText)
            args.putInt(BoardHelper.RESOURCE_IMG, board.resourceImg)
            args.putString(BoardHelper.BOTTOM_TEXT, board.bottomText)
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
        topTitle.text = args.getString(BoardHelper.TOP_TEXT)
        imgBoard.setImageResource(args.getInt(BoardHelper.RESOURCE_IMG))
        bottomTitle.text = args.getString(BoardHelper.BOTTOM_TEXT)

        val mainTypeFace: Typeface = Typeface.createFromAsset(context.assets, "fonts/Handlee-Regular.ttf")

        topTitle.typeface = mainTypeFace
        bottomTitle.typeface = mainTypeFace
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }
}// Required empty public constructor
