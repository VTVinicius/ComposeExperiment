package com.example.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import base_feature.home.home_screen.LayoutHomeScreen
import com.example.feature.profile.ProfileLayout
import com.example.feature_pokedex.home.PokedexHomeLayout
import com.example.feature_pokedex.home.PokedexLayout2
import com.example.navigation.navigatiors.base_feature.HomeNavigationImpl
import com.example.navigation.navigatiors.pokedex.PokedexNavigationImpl
import com.example.navigation.navigatiors.profile.ProfileNavigationImpl



@Composable
fun NavigationHostController() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "homeScreen", route = "homeNavigation") {

        //Home Graph
        composable("homeScreen") { LayoutHomeScreen(HomeNavigationImpl(), navController) }

        //Pokedex Graph
        composable("pokedexHomeScreen") { PokedexHomeLayout(PokedexNavigationImpl(), navController) }
        composable("pokemonDetails") { PokedexLayout2(PokedexNavigationImpl(), navController) }

        //Profile Grahp
        composable("profileHomeScreen") { ProfileLayout(ProfileNavigationImpl(), navController) }
    }
}