package com.example.yhous.beparent.fonts

import android.content.Context
import android.graphics.Typeface
import java.util.HashMap

/**
 * Created by yannickhoussin on 22/11/2017.
 */
object FontCache {
  private val fontCache = HashMap<String, Typeface>()

  fun getTypeface(fontname: String, context: Context): Typeface? {
    var typeface: Typeface? = fontCache[fontname]

    if (typeface == null) {
      try {
        typeface = Typeface.createFromAsset(context.assets, fontname)
      } catch (e: Exception) {
        return null
      }

      fontCache.put(fontname, typeface)
    }

    return typeface
  }
}