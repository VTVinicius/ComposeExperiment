package com.example.navigation.navigatiors.pokedex

import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.feature_pokedex.common.navigation.PokedexNavigation

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
    override fun goToPokemonDetails(navController: NavController, dominantColor: Int ,pokemonName: String) {
        navController.navigate("pokemonDetails/${dominantColor}/$pokemonName")
    }

}