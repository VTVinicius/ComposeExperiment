package base_feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections

interface HomeNavigation {

    fun goToProfileNavigation(navController: NavController)
    fun goToHomeNavigation(navController: NavController)
    fun goToPokedexNavigation(navController: NavController)
    fun goToHomeScreen(navController: NavController)

}