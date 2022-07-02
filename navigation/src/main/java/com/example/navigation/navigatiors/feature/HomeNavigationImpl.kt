package com.example.navigation.navigatiors.feature

import androidx.navigation.NavController
import com.example.feature.commom.navigation.HomeNavigation


class HomeNavigationImpl() : HomeNavigation {



    override fun goToHomeScreen(navController: NavController) {
        navController.navigate("homeScreen")
    }

    override fun goToYesScreen(navController: NavController) {
        navController.navigate("yesScreen")
    }

    override fun goToNoScreen(navController: NavController) {
        navController.navigate("noScreen")
    }

}


