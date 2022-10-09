package com.example.feature_pokedex.common.navigation

import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

interface PokedexNavigation {

    fun goToHomeNavigation(navController: NavController)

    fun goBackToHomePokedex(navController: NavController)

    fun goToPokemonDetails(navController: NavController ,pokemonName: String)

}