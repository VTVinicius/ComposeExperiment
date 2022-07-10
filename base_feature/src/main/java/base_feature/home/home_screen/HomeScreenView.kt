package base_feature.home.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import base_feature.home.home_screen.components.ComposeImage
import base_feature.home.navigation.HomeNavigation
import uikit.compose.components.buttons.OutlineButton


@Composable
fun LayoutHomeScreen(listener: HomeNavigation?, navController: NavController) {

    val listenerNav = listener

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ComposeImage()

        Spacer(modifier = Modifier.padding(48.dp))

        OutlineButton(
            text = "Perfil",
            onClick = {  },
            backgroundColor = R.color.lightGreen,
        )

    }


}