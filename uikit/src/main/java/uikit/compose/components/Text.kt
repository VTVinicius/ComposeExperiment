package uikit.compose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import uikit.theme.ComposeTheme.typography

@Composable
fun TitleText(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = typography.title.fontFamily,
            color = colorResource(id = R.color.black)
        )
    )
}