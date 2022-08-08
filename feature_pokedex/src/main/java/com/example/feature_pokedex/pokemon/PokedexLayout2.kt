package com.example.feature_pokedex.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import base_feature.home.navigation.HomeNavigation
import com.example.feature_pokedex.common.navigation.PokedexNavigation
import uikit.compose.components.buttons.OutlineButton


@Composable
fun PokedexLayout2(listener: PokedexNavigation?, navController: NavController, dominantColor: Int, pokemonName: String) {

    Column(Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = pokemonName)

        OutlineButton(
            onClick = { listener?.goBackToHomePokedex(navController) },
            text = "Voltar para Home Pokedex"
        )
    }
}