package com.example.navigation.navigatiors.feature

import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feature.commom.navigation.HomeNavigation
import com.example.feature.home_screen.LayoutHomeScreen
import com.example.feature.no_screen.NoScreenLayout
import com.example.feature.yes_screen.YesScreenLayout
import com.example.navigation.R
import com.example.navigation.utils.popBackStack
import com.example.navigation.utils.safeNavigate


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


