package com.example.feature_examples.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.feature_examples.navigation.ExamplesNavigation
import uikit.compose.components.buttons.BackButton
import uikit.compose.components.buttons.OutlineButton
import uikit.compose.utils.VerticalSpacer
import uikit.theme.background


@Composable
fun ExamplesHomeScreen(
    navigation: ExamplesNavigation,
    navController: NavController
){


    Column(Modifier.fillMaxSize()
        .background(background)
        .padding(32.dp)) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .offset((-16).dp, (-16).dp),
            horizontalArrangement = Arrangement.Start
        ) {
            BackButton(onClick = { navigation.goToHomeNavigation(navController) })
        }

        VerticalSpacer(height = 32)

        OutlineButton(text = "Input Text", onClick = { navigation.goToInputText(navController) })

        VerticalSpacer(height = 32)

        OutlineButton(text = "Buttons", onClick = { navigation.goToButtons(navController) })


    }


}