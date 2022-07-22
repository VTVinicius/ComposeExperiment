package com.example.baseapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.navigation.navGraph.NavigationHostController
import uikit.theme.ComposeThemes


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeThemes {
                NavigationHostController()
            }
        }
    }
}






