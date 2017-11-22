package com.example.yhous.beparent.onboarding

import com.example.yhous.beparent.R

/**
 * Created by yhous on 22/11/2017.
 */
object BoardHelper {

    val TOP_TEXT = "topText"
    val RESOURCE_IMG = "resourceImg"
    val BOTTOM_TEXT = "BottomText"

    fun getBoards(): ArrayList<Board> {
        val boards = ArrayList<Board>()
        boards.add(Board("Bienvenue sur\nBeParent!", R.drawable.tamagochi_board, ""))
        boards.add(Board("L’application BeParent est ton assistante personnelle.", R.drawable.tamagochi_board, "Elle te guidera durant toute la période de gestation de ton bébé."))
        boards.add(Board("Elle te permettra de suivre en temps réel l'évolution de ton enfant et préparer son arrivée !", R.drawable.tamagochi_board, "Mais ce n'est pas tout !..."))
        boards.add(Board("Chaque jour tu auras une news, et une petite astuce pour toi et ton petit bout ! ", R.drawable.tamagochi_board, "Des recettes, des astuces bien être, Un générateur de prénoms... Tout y est !"))
        boards.add(Board("Mais avant tout cela... quel est ton petit nom ?", R.drawable.tamagochi_board, ""))
        return boards
    }
}