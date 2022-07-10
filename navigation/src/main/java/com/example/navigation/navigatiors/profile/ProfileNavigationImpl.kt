package com.example.navigation.navigatiors.profile

import androidx.navigation.NavController
import com.example.feature.commom.navigation.ProfileNavigation


class ProfileNavigationImpl() : ProfileNavigation {



    override fun goToHomeNavigation(navController: NavController) {
        navController.navigate("homeScreen")
    }

    override fun goToProfileScreen(navController: NavController) {
        navController.navigate("profileScreen")
    }

    override fun goToCardsListScreen(navController: NavController) {
        navController.navigate("cardsListScreen")
    }

    override fun goToPopBackStack(navController: NavController) {
        navController.popBackStack()
    }

}


