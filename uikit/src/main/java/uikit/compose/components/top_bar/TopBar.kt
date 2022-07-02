package uikit.compose.components.top_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.uikit.R
import uikit.compose.components.buttons.BackButton

@Composable
fun TopBar(
    onClickBack: () -> Unit,
    onClickExit: () -> Unit,
    title: String = ""
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.lightGreen))
    ) {

        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            BackButton(onClick = { onClickBack })
            Text(text = title)
        }

    }


}