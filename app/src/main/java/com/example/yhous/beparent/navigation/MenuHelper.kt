package com.example.yhous.beparent.navigation



import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.yhous.beparent.HealthFollowup
import com.example.yhous.beparent.R
import com.example.yhous.beparent.board.BoardFragment
import com.example.yhous.beparent.calendar.CalendarFragment
import com.example.yhous.beparent.counters.CountersFragment
import com.example.yhous.beparent.health_followup.HealthFollowupFragment
import com.example.yhous.beparent.luggage.LuggageFragment
import com.example.yhous.beparent.name_select.NameSelectFragment
import com.example.yhous.beparent.recipes.RecipeFragment
import com.example.yhous.beparent.weight.WeightFragment

/**
 * Created by yannickhoussin on 28/11/2017.
 */
object MenuHelper {
  val TITLE = "title"
  val RESOURCE_IMG = "resourceImg"

  fun getMenuItems(): ArrayList<MenuItem> {
    val menuItems = ArrayList<MenuItem>()
    menuItems.add(MenuItem(R.drawable.ic_followup, "Suivi santé", "health_followup", HealthFollowupFragment()))
    menuItems.add(MenuItem(R.drawable.ic_calendar, "Calendrier", "calendar", CalendarFragment()))
    menuItems.add(MenuItem(R.drawable.ic_counters, "Compteurs", "counters", CountersFragment()))
    menuItems.add(MenuItem(R.drawable.ic_weight, "Poids", "weight", WeightFragment()))
    menuItems.add(MenuItem(R.drawable.ic_recipes, "Alimentation", "recipes", RecipeFragment()))
    menuItems.add(MenuItem(R.drawable.ic_luggage, "Ma valise", "my_luggage", LuggageFragment()))
    menuItems.add(MenuItem(R.drawable.ic_name_select, "Prénoms", "name_selection", NameSelectFragment()))
    return menuItems
  }
}