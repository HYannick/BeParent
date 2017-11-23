package com.example.yhous.beparent.utils.custom_components

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.TextView
import com.example.yhous.beparent.fonts.FontCache


/**
 * Created by yannickhoussin on 22/11/2017.
 */
class HandleeButton : Button {

  constructor(context: Context) : super(context) {
    applyCustomFont(context)
  }

  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    applyCustomFont(context)
  }

  constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
    applyCustomFont(context)
  }

  private fun applyCustomFont(context: Context) {
    val customFont = FontCache.getTypeface("fonts/Handlee-Regular.ttf", context)
    typeface = customFont
  }
}