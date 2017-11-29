package com.example.yhous.beparent.navigation

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.ImageView
import com.example.yhous.beparent.R
import com.example.yhous.beparent.utils.AnimBehaviours
import com.example.yhous.beparent.utils.custom_components.HandleeTextView
import com.squareup.picasso.Picasso


/**
 * Created by yannickhoussin on 28/11/2017.
 */
class MenuGridAdapter(val context: Context, val menuItems: ArrayList<MenuItem>): BaseAdapter() {
  override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
    val menuItem = menuItems[position]
    val layoutInflater = LayoutInflater.from(context)
    val view: View = layoutInflater.inflate(R.layout.menu_item, null)

    val imageView = view.findViewById<ImageView>(R.id.menu_btn)
    val buttonDesc = view.findViewById<HandleeTextView>(R.id.menu_desc)

    imageView.setImageResource(menuItem.menuIcon)
    buttonDesc.text = menuItem.menuText

    return view
  }

  override fun getItem(position: Int): Any {
    return 0
  }

  override fun getItemId(position: Int): Long {
    return 0
  }

  override fun getCount(): Int {
    return menuItems.size
  }
}

