package com.example.feature.commom.navigation

import androidx.navigation.NavController

interface ProfileNavigation {

    fun goToHomeNavigation(navController: NavController)

    fun goToProfileScreen(navController: NavController)

    fun goToCardsListScreen(navController: NavController)

    fun goToPopBackStack(navController: NavController)

}