package com.example.navigation.navigatiors.examples

import androidx.navigation.NavController
import com.example.feature_examples.navigation.ExamplesNavigation

class ExamplesNavigationImpl: ExamplesNavigation {

    override fun goToHomeNavigation(navController: NavController) {
        navController.navigate("homeScreen"){
            popUpTo("homeScreen") { inclusive = true }
        }
    }

    override fun goToHomeExample(navController: NavController) {
        navController.navigate("examplesNavigation"){
            popUpTo("examplesNavigation") { inclusive = true }
        }
    }

    override fun goToInputText(navController: NavController) {
        navController.navigate("inputTextScreen"){
            popUpTo("inputTextScreen") { inclusive = true }
        }
    }

    override fun goToButtons(navController: NavController) {
        navController.navigate("buttonsScreen"){
            popUpTo("buttonsScreen") { inclusive = true }
        }
    }
}