package com.example.yhous.beparent


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yhous.beparent.onboarding.Board
import com.example.yhous.beparent.onboarding.BoardHelper


/**
 * A simple [Fragment] subclass.
 */
class ConnectFragment : Fragment() {
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
        return inflater!!.inflate(R.layout.fragment_connect, container, false)
    }

}// Required empty public constructor
