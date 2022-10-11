package com.example.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import base_feature.home.home_screen.LayoutHomeScreen
import com.example.feature.profile.ProfileLayout
import com.example.feature_examples.buttons.ButtonsScreen
import com.example.feature_examples.home.ExamplesHomeScreen
import com.example.feature_examples.inptu_text.InputTextsView
import com.example.feature_pokedex.home.PokedexHomeLayout
import com.example.feature_pokedex.home.PokemonDetail
import com.example.navigation.navigatiors.base_feature.HomeNavigationImpl
import com.example.navigation.navigatiors.examples.ExamplesNavigationImpl
import com.example.navigation.navigatiors.pokedex.PokedexNavigationImpl
import com.example.navigation.navigatiors.profile.ProfileNavigationImpl


@Composable
fun NavigationHostController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "homeScreen",
        route = "homeNavigation"
    ) {

        //Home Graph
        composable("homeScreen") { LayoutHomeScreen(HomeNavigationImpl(), navController) }

        //Pokedex Graph
        composable("pokedexHomeScreen") {
            PokedexHomeLayout(
                PokedexNavigationImpl(),
                navController
            )
        }
        composable(
            "pokemonDetails/{pokemonName}",
            arguments = listOf(
                navArgument("pokemonName") { type = NavType.StringType },
            )
        ) {
            val arguments = requireNotNull(it.arguments)

            arguments.getString("pokemonName")?.let { it1 ->
                PokemonDetail(
                    listener = PokedexNavigationImpl(),
                    navController = navController,
                    pokemonName = it1,
                )
            }
        }

        //Profile Grahp
        composable("profileHomeScreen") {
            ProfileLayout(
                ProfileNavigationImpl(),
                navController
            )
        }

        //Examples Grahp
        composable("examplesNavigation") {
            ExamplesHomeScreen(
                ExamplesNavigationImpl(),
                navController
            )
        }
        composable("inputTextScreen") {
            InputTextsView(
                ExamplesNavigationImpl(),
                navController
            )
        }
        composable("buttonsScreen") {
            ButtonsScreen(
                ExamplesNavigationImpl(),
                navController
            )
        }
    }
}