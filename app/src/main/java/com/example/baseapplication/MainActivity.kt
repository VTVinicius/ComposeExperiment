package com.example.baseapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feature.cards_list.CardsListLayout
import base_feature.home.home_screen.LayoutHomeScreen
import com.example.feature.profile.ProfileLayout
import com.example.feature_pokedex.home.PokedexHomeLayout
import com.example.navigation.navigatiors.base_feature.HomeNavigationImpl
import com.example.navigation.navigatiors.pokedex.PokedexNavigationImpl
import com.example.navigation.navigatiors.profile.ProfileNavigationImpl
import uikit.theme.ComposeThemes


class MainActivity : ComponentActivity() {


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
            composable("pokedexHomeScreen") {
                PokedexHomeLayout(
                    PokedexNavigationImpl(),
                    navController
                )
            }
        }
    }


    @Composable
    fun NavigationPokedexController() {

        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "pokedexHomeScreen") {
            composable("homeNavigation") { HomeNavigationImpl().goToHomeScreen(navController) }
            composable("pokedexNavigation") { PokedexNavigationImpl().goToHomePokedex(navController) }
            composable("pokedexHomeScreen") {
                PokedexHomeLayout(
                    PokedexNavigationImpl(),
                    navController
                )
            }
        }


    }
}




