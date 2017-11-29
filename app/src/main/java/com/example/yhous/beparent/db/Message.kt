package com.example.yhous.beparent.db

import android.content.Context
import android.widget.Toast

/**
 * Created by yannickhoussin on 24/11/2017.
 */
object Message {
  fun print(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
  }
}