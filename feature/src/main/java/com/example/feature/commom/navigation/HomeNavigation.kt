package com.example.feature.commom.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

interface HomeNavigation {


    fun goToYesScreen(navController: NavController)

    fun goToHomeScreen(navController: NavController)

    fun goToNoScreen(navController: NavController)

}