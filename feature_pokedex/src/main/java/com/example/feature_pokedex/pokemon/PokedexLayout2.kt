package com.example.feature_pokedex.home

import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import base_feature.home.navigation.HomeNavigation
import com.example.feature_pokedex.common.navigation.PokedexNavigation
import uikit.compose.components.buttons.OutlineButton


@Composable
fun PokedexLayout2(listener: PokedexNavigation?, navController: NavController) {

    Text(text = "Teste layout 2")

    OutlineButton(
        onClick = { listener?.goBackToHomePokedex(navController) },
        text = "Voltar para Home Pokedex"
    )
}