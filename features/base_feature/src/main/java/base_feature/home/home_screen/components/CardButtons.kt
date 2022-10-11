package base_feature.home.home_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uikit.compose.components.buttons.OutlineButton
import uikit.compose.components.buttons.PrimaryButton

@Composable
fun CardButtons(
    modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier,
    textButtonOne: String = "" ,
    textButtonTwo: String = "",
    onClickButtonOne: () -> Unit? ,
    onClickButtonTwo: () -> Unit?
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
            OutlineButton(text = "$textButtonOne", onClick = {onClickButtonOne.invoke()})

            Spacer(modifier = Modifier.height(32.dp))

            PrimaryButton(text = "$textButtonTwo", onClick = { onClickButtonTwo.invoke() })

        }
    }
}