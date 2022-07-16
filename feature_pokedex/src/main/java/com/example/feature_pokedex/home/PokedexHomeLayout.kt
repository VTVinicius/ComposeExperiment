package com.example.feature_pokedex.home

import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import base_feature.home.navigation.HomeNavigation
import com.example.feature_pokedex.home.common.navigation.PokedexNavigation
import uikit.compose.components.buttons.OutlineButton


@Composable
fun PokedexHomeLayout(listener: PokedexNavigation?, navController: NavController) {

    OutlineButton(
        onClick = { listener?.goToHomeNavigation(navController) },
        text = "Voltar para Home"
    )
}