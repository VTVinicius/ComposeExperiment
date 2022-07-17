package com.example.navigation.navigatiors.pokedex

import androidx.navigation.NavController
import com.example.feature_pokedex.home.common.navigation.PokedexNavigation

class PokedexNavigationImpl(): PokedexNavigation {

    override fun goToHomeNavigation(navController: NavController) {
        navController.navigate("homeScreen"){
            popUpTo("homeScreen") { inclusive = true }
        }
    }

    override fun goBackToHomePokedex(navController: NavController) {
        navController.navigate("pokedexHomeScreen"){
            popUpTo("pokedexHomeScreen") { inclusive = true }
        }
    }
    override fun goToLayout2Pokedex(navController: NavController) {
        navController.navigate("layout2")
    }

}