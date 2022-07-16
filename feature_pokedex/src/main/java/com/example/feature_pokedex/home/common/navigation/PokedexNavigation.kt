package com.example.feature_pokedex.home.common.navigation

import androidx.navigation.NavController

interface PokedexNavigation {

    fun goToHomeNavigation(navController: NavController)
    fun goToPokedexNavigation(navController: NavController)
    fun goToHomePokedex(navController: NavController)

}