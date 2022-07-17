package com.example.feature_pokedex.common.navigation

import androidx.navigation.NavController

interface PokedexNavigation {

    fun goToHomeNavigation(navController: NavController)

    fun goBackToHomePokedex(navController: NavController)

    fun goToLayout2Pokedex(navController: NavController)

}