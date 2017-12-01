package com.example.yhous.beparent.navigation

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.yhous.beparent.R
import com.example.yhous.beparent.utils.custom_components.HandleeTextView


/**
 * Created by yannickhoussin on 28/11/2017.
 */
class MenuGridAdapter(val context: Context, val menuItems: ArrayList<MenuItem>) : RecyclerView.Adapter<MenuGridAdapter.NavViewHolder>() {
  private lateinit var listener: SwitchFragments
  class NavViewHolder(v: View, listener: SwitchFragments) : RecyclerView.ViewHolder(v), View.OnClickListener {
    private var view: View = v
    private var listen: SwitchFragments = listener
    private var menuItem: MenuItem? = null

    init {
      v.setOnClickListener(this)
    }

    fun bindNav(menuItem: MenuItem) {
      this.menuItem = menuItem
      val imageView = view.findViewById<ImageView>(R.id.menu_btn)
      val buttonDesc = view.findViewById<HandleeTextView>(R.id.menu_desc)
      imageView.setImageResource(menuItem.menuIcon)
      buttonDesc.text = menuItem.menuText
    }

    override fun onClick(v: View) {
      Log.d("Switch to ->", "${menuItem!!.fragment}")
      if(!menuItem!!.fragment.isVisible) {
        listen.onFragmentSwitch(menuItem!!.fragment)
      }
//      val btn = v.findViewById<LinearLayout>(R.id.menu_item_btn)
//      btn.alpha = 0.5f
    }
  }

  override fun onBindViewHolder(holder: NavViewHolder, position: Int) {
    val menuItem = menuItems[position]
    holder.bindNav(menuItem)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavViewHolder {
    val inflatedView = parent.inflate(R.layout.menu_item, false)
    if (context is SwitchFragments) {
      listener = context
    } else {
      throw ClassCastException(context.toString() + " must implement SwitchFragments.")
    }

    return NavViewHolder(inflatedView, listener)
  }

  override fun getItemCount(): Int = menuItems.size

}

// to investigate
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
  return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}