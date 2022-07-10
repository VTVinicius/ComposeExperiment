package com.example.navigation.navigatiors.pokedex

import androidx.navigation.NavController
import com.example.feature_pokedex.home.common.navigation.PokedexNavigation

class PokedexNavigationImpl(): PokedexNavigation {

    override fun goToHomeNavigation(navController: NavController) {
        navController.navigate("homeNavigation")
    }
}