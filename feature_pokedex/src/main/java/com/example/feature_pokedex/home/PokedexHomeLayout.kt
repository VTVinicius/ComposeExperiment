package com.example.feature_pokedex.home

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import base_feature.home.navigation.HomeNavigation
import com.example.feature_pokedex.home.common.navigation.PokedexNavigation
import uikit.compose.components.buttons.OutlineButton


@Composable
fun PokedexHomeLayout(listener: PokedexNavigation?, navController: NavController) {

    Text(text = "Teste")

    Column(Modifier.fillMaxSize()) {
        OutlineButton(
            onClick = { listener?.goToHomeNavigation(navController) },
            text = "Voltar para Home"
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlineButton(
            onClick = { listener?.goToLayout2Pokedex(navController) },
            text = "Ir para Layout2"
        )
    }

}