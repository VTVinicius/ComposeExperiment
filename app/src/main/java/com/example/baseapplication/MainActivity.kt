package com.example.baseapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uikit.compose.components.buttons.OutlineButton
import uikit.compose.components.buttons.PrimaryButton
import uikit.theme.ComposeThemes


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeThemes {
                Layout()
            }


        }
    }

    @Composable
    fun Layout(  modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier) {
        Column(
            modifier = modifier
                .background(Color.DarkGray)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom,
        ) {
            CardButtons()
        }
    }

    @Preview
    @Composable
    fun CardButtons(
        modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
    ) {

            Card(
                elevation = 4.dp,
                backgroundColor = Color.Gray,
                modifier =
                modifier
                    .padding(32.dp),
                shape = RoundedCornerShape(8.dp),
            ) {
                Column(
                    modifier = modifier.padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlineButton(text = "Sim", onClick = { /*TODO*/ })

                    Spacer(modifier = Modifier.height(32.dp))

                    PrimaryButton(text = "Não", onClick = { /*TODO*/ })

            }
        }
    }
}



