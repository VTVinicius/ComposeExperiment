package com.example.baseapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feature.cards_list.CardsListLayout
import com.example.feature.home_screen.LayoutHomeScreen
import com.example.feature.profile.ProfileLayout
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
            composable("profileScreen") { ProfileLayout() }
            composable("cardsListScreen") { CardsListLayout() }
            /*...*/
        }
    }

}



