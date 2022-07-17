package com.example.feature.profile

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.feature.commom.navigation.ProfileNavigation

@Composable
fun ProfileLayout(listener: ProfileNavigation, navController: NavController) {

    Text(text = "VOCE ESTÁ NA TELA DE PROFILE")

}