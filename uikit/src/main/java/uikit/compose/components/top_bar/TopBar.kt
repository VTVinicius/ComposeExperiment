package uikit.compose.components.top_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import uikit.compose.components.buttons.BackButton

@Composable
fun TopBar(
    onClickBack: () -> Unit,
    onClickExit: () -> Unit,
    title: String = ""
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(colorResource(id = R.color.lightGreen))
        .padding(top = 16.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .padding(start = 16.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackButton(onClick = { onClickBack })
            }

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = title)
        }
    }
}


