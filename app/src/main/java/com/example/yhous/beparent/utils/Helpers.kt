@file:Suppress("DEPRECATION")

package com.example.yhous.beparent.utils

import android.os.Build
import android.text.Html
import android.text.Spanned

/**
 * Created by yannickhoussin on 25/11/2017.
 */
object Helpers {
  fun setTextColor(fullText: String, color: String, toExtract: String) :Spanned {
    val toParse = fullText.replace(toExtract, "<font color=$color>$toExtract</font>")
    return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      Html.fromHtml(toParse, Html.FROM_HTML_MODE_LEGACY)
    }  else {
      Html.fromHtml(toParse)
    }
  }
}