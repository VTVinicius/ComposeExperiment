package com.example.feature_pokedex.home

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import base_feature.home.navigation.HomeNavigation
import base_feature.utils.extensions.compose.VerticalSpacer
import com.example.feature_pokedex.R
import com.example.feature_pokedex.common.navigation.PokedexNavigation
import com.example.feature_pokedex.home.components.BasicSearchBar
import uikit.compose.components.buttons.OutlineButton


@Composable
fun PokedexHomeLayout(listener: PokedexNavigation?, navController: NavController) {


    Column() {

        VerticalSpacer(height = 24)
        Image(
            painter = painterResource(id = R.drawable.img_pokemon_logo),
            contentDescription = "POKEMON LOGO",
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)
        )
        VerticalSpacer(height = 24)

        BasicSearchBar()
    }




}