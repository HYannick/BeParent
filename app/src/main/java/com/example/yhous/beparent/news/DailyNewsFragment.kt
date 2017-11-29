package com.example.yhous.beparent.news


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.yhous.beparent.R
import com.example.yhous.beparent.utils.ImageTransformation
import com.squareup.picasso.Picasso

@Suppress("DEPRECATION")
/**
 * A simple [Fragment] subclass.
 */
class DailyNewsFragment : Fragment() {

  companion object {
    fun newInstance(news: DailyNews): DailyNewsFragment {
      val args = Bundle()
      args.putString(NewsHelper.TITLE, news.title)
      args.putInt(NewsHelper.RESOURCE_IMG, news.resourceImg)
      args.putString(NewsHelper.SHORT_DESC, news.shortDesc)
      val fragment = DailyNewsFragment()
      fragment.arguments = args
      return fragment
    }
  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {

    // Inflate the layout for this fragment
    val view: View = inflater!!.inflate(R.layout.fragment_daily_news, container, false)

    val newsTitle = view.findViewById<TextView>(R.id.news_title)
    val newsImg = view.findViewById<ImageView>(R.id.news_img)
    val newsContent = view.findViewById<TextView>(R.id.news_content)

    // Pull args and set values
    val args = arguments

    newsTitle.text = args.getString(NewsHelper.TITLE)
    Picasso.with(context)
            .load(args.getInt(NewsHelper.RESOURCE_IMG))
            .resize(600, 600)
            .centerCrop()
            .transform(ImageTransformation())
            .into(newsImg)
    newsContent.text = args.getString(NewsHelper.SHORT_DESC)

    return view
  }
}// Required empty public constructor
