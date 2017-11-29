package com.example.yhous.beparent.utils.custom_components

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import com.example.yhous.beparent.fonts.FontCache


/**
 * Created by yannickhoussin on 22/11/2017.
 */
class ObservableScrollView : ScrollView {
  interface OnScrollChangedListener {
    fun onScrollChanged(deltaX: Int, deltaY: Int)
  }

  private var mOnScrollChangedListener: OnScrollChangedListener? = null
  constructor(context: Context?) : super(context)
  constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
    super.onScrollChanged(l, t, oldl, oldt)
    if(mOnScrollChangedListener != null) {
      mOnScrollChangedListener!!.onScrollChanged(l - oldl, t - oldt)
    }
  }

  fun setOnScrollChangedListener(l: OnScrollChangedListener) {
    mOnScrollChangedListener = l
  }


}