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
fun TitleText(text: String, textColor: Int = R.color.black) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = typography.title.fontFamily,
            color = colorResource(id = textColor)
        )
    )
}

@Composable
fun SubtitleText(text: String, textColor: Int = R.color.black) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = typography.subtitle.fontFamily,
            color = colorResource(id = textColor)
        )
    )
}

@Composable
fun NormalText(text: String, textColor: Int = R.color.black) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = typography.normal.fontFamily,
            color = colorResource(id = textColor)
        )
    )
}

@Composable
fun NormalBoldText(text: String, textColor: Int = R.color.black) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = typography.normalBold.fontFamily,
            color = colorResource(id = textColor)
        )
    )
}

@Composable
fun ButtonText(text: String, textColor: Int = R.color.black) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = typography.button.fontFamily,
            color = colorResource(id = textColor)
        )
    )
}