package com.example.yhous.beparent.news

import com.example.yhous.beparent.R

/**
 * Created by yhous on 22/11/2017.
 */
object NewsHelper {

    val TITLE = "title"
    val RESOURCE_IMG = "resourceImg"
    val SHORT_DESC = "shortDesc"

    fun getNews(): ArrayList<DailyNews> {
        val boards = ArrayList<DailyNews>()
        boards.add(DailyNews("La grossesse et ton coeur", R.drawable.img_news_one, "Est ce que tes médicaments sont safes pour ton bout d’chou ?"))
        boards.add(DailyNews("La trousse pour bébé", R.drawable.img_news_two, "Plein de petites choses pour lui et toi"))
        boards.add(DailyNews("Que faire en cas de contractions ?", R.drawable.img_news_three, "Les techniques à reproduire ou éviter"))
        return boards
    }
}