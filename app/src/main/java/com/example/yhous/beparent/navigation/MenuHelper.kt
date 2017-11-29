package com.example.yhous.beparent.navigation

import android.support.v7.app.AppCompatActivity
import com.example.yhous.beparent.HealthFollowup
import com.example.yhous.beparent.R

/**
 * Created by yannickhoussin on 28/11/2017.
 */
object MenuHelper {
  val TITLE = "title"
  val RESOURCE_IMG = "resourceImg"

  fun getMenuItems(): ArrayList<MenuItem> {
    val menuItems = ArrayList<MenuItem>()
    menuItems.add(MenuItem(R.drawable.ic_followup, "Suivi santé"))
    menuItems.add(MenuItem(R.drawable.ic_calendar, "Calendrier"))
    menuItems.add(MenuItem(R.drawable.ic_counters, "Compteurs"))
    menuItems.add(MenuItem(R.drawable.ic_weight, "Poids"))
    menuItems.add(MenuItem(R.drawable.ic_recipes, "Alimentation"))
    menuItems.add(MenuItem(R.drawable.ic_luggage, "Ma valise"))
    menuItems.add(MenuItem(R.drawable.ic_name_select, "Prénoms"))
    return menuItems
  }

  fun getLinks(): ArrayList<AppCompatActivity> {
    val menuLinks = ArrayList<AppCompatActivity>()
    menuLinks.add(HealthFollowup())
    return menuLinks
  }
}