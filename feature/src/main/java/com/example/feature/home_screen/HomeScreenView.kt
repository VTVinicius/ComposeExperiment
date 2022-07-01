package com.example.feature.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.feature.commom.navigation.HomeNavigation
import com.example.feature.home_screen.components.CardButtons



@Composable
fun LayoutHomeScreen(listener: HomeNavigation?, navController: NavController){

    val listenerNav = listener

    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        CardButtons(textButtonOne = "Sim - Card 1", textButtonTwo = "Não - Card 1" , onClickButtonOne = {listenerNav?.goToYesScreen(navController)}, onClickButtonTwo = {listenerNav?.goToNoScreen(navController)})

        CardButtons(textButtonOne = "Sim - Card 2", textButtonTwo = "Não - Card 2", onClickButtonOne = {listenerNav?.goToYesScreen(navController)}, onClickButtonTwo = {listenerNav?.goToNoScreen(navController)})

        CardButtons(textButtonOne = "Sim - Card 3", textButtonTwo = "Não - Card 3", onClickButtonOne = {listenerNav?.goToYesScreen(navController)}, onClickButtonTwo = {listenerNav?.goToNoScreen(navController)})
    }
}