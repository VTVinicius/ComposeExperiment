package com.example.baseapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feature.commom.navigation.HomeNavigation
import com.example.feature.home_screen.LayoutHomeScreen
import com.example.feature.no_screen.NoScreenLayout
import com.example.feature.yes_screen.YesScreenLayout
import com.example.navigation.navigatiors.feature.HomeNavigationImpl
import uikit.theme.ComposeThemes


class MainActivity: ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeThemes {
                NavigationHostController()
            }
        }
    }

    @Composable
    fun NavigationHostController() {

        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "homeScreen") {
            composable("homeScreen") { LayoutHomeScreen(HomeNavigationImpl(), navController) }
            composable("yesScreen") { YesScreenLayout() }
            composable("noScreen") { NoScreenLayout() }
            /*...*/
        }
    }

}



