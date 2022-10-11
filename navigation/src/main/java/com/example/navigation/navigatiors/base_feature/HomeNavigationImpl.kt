package com.example.navigation.navigatiors.base_feature

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import base_feature.home.navigation.HomeNavigation

class HomeNavigationImpl() : HomeNavigation {


    override fun goToProfileNavigation(navController: NavController) {
        navController.navigate("profileHomeScreen")
    }
    override fun goToHomeNavigation(navController: NavController) {
        navController.navigate("homeNavigation")
    }
    override fun goToExamplesNavigation(navController: NavController) {
        navController.navigate("examplesNavigation")
    }

    override fun goToPokedexNavigation(navController: NavController) {
        navController.navigate("pokedexHomeScreen")
    }
    override fun goToHomeScreen(navController: NavController) {
        navController.navigate("homeScreen")

    }


}