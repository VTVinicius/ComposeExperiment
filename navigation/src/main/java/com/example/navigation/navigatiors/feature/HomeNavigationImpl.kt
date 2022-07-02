package com.example.navigation.navigatiors.feature

import androidx.navigation.NavController
import com.example.feature.commom.navigation.HomeNavigation


class HomeNavigationImpl() : HomeNavigation {



    override fun goToHomeScreen(navController: NavController) {
        navController.navigate("homeScreen")
    }

    override fun goToProfileScreen(navController: NavController) {
        navController.navigate("profileScreen")
    }

    override fun goToCardsListScreen(navController: NavController) {
        navController.navigate("cardsListScreen")
    }

}


