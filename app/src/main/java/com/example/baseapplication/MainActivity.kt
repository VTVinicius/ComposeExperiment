package com.example.baseapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feature.cards_list.CardsListLayout
import base_feature.home.home_screen.LayoutHomeScreen
import com.example.feature.profile.ProfileLayout
import com.example.navigation.navigatiors.profile.ProfileNavigationImpl
import uikit.theme.ComposeThemes


class MainActivity: ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeThemes {
                NavigationHostController()
                NavigationPokedexController()
            }
        }
    }

    @Composable
    fun NavigationHostController() {

        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "homeScreen") {
            composable("homeScreen") { LayoutHomeScreen(ProfileNavigationImpl(), navController) }
            composable("profileScreen") { ProfileLayout() }
            composable("cardsListScreen") { CardsListLayout(ProfileNavigationImpl(), navController) }
            composable("pokedexNavigation") {  }
            /*...*/
        }
    }

    @Composable
    fun NavigationPokedexController() {

        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "pokedexHomeScreen") {
            composable("pokedexHomeScreen") { PokedexHomeLayout() }
            composable("profileScreen") { ProfileLayout() }
            composable("cardsListScreen") { CardsListLayout(ProfileNavigationImpl(), navController) }
            composable("pokedexNavigation") {  }
            /*...*/
        }
    }


}



