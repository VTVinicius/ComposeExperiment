package com.example.feature.commom.navigation

import androidx.navigation.NavController

interface HomeNavigation {


    fun goToProfileScreen(navController: NavController)

    fun goToHomeScreen(navController: NavController)

    fun goToCardsListScreen(navController: NavController)

    fun goToPopBackStack(navController: NavController)

}