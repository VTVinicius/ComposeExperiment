package com.example.feature_examples.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import base_feature.utils.extensions.compose.VerticalSpacer
import com.example.feature_examples.R
import com.example.feature_examples.navigation.ExamplesNavigation
import uikit.compose.components.buttons.BackButton
import uikit.compose.components.buttons.OutlineButton
import uikit.compose.components.buttons.PrimaryButton
import uikit.theme.background

@Composable
fun ButtonsScreen(
    navigation: ExamplesNavigation,
    navController: NavController
) {

    Column(
        Modifier
            .fillMaxSize()
            .background(background)
            .verticalScroll(state = rememberScrollState())
            .padding(16.dp)) {



        BackButton(onClick = {navigation.goToHomeExample(navController = navController)})

        VerticalSpacer(height = 16)

        OutlineButton(text = "OutlineButton", onClick = {  })

        VerticalSpacer(height = 16)

        PrimaryButton(text = "PrimaryButton", onClick = {  })

        VerticalSpacer(height = 16)

        OutlineButton(text = "OutlineButton - Icon Left", onClick = {  }, iconLeft = R.drawable.ic_left_arrow)

        VerticalSpacer(height = 16)

        PrimaryButton(text = "PrimaryButton - Icon Left", onClick = {  }, iconLeft = R.drawable.ic_left_arrow)

        VerticalSpacer(height = 16)

        OutlineButton(text = "OutlineButton - Icon Right", onClick = {  }, iconRight = R.drawable.ic_right_arrow)

        VerticalSpacer(height = 16)

        PrimaryButton(text = "PrimaryButton - Icon Right", onClick = {  }, iconRight = R.drawable.ic_right_arrow)
    }

}