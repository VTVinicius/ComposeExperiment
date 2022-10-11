package uikit.compose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
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
fun NormalBoldText(text: String, textColor: Int = R.color.black, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontFamily = typography.normalBold.fontFamily,
            color = colorResource(id = textColor)
        )
    )
}

@Composable
fun TitleBoldText(text: String, textColor: Int = R.color.black, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontFamily = typography.title.fontFamily,
            color = colorResource(id = textColor)
        ),
        fontSize = typography.title.fontSize,
        fontWeight = typography.title.fontWeight

    )
}

@Composable
fun ButtonText(text: String, textColor: Int = R.color.black, modifier: Modifier) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontFamily = typography.button.fontFamily,
            color = colorResource(id = textColor)
        ),
        fontSize = typography.button.fontSize,
        fontWeight = typography.button.fontWeight
    )
}

@Composable
fun NormalText(
    text: String,
    colors: Color = Color.White,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = typography.normal.fontFamily,
            color = colors
        ),
        fontSize = typography.normal.fontSize,
        fontWeight = typography.normal.fontWeight
    )
}

@Composable
fun Title20Text(
    text: String,
    colors: Color = Color.White,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = typography.title20.fontFamily,
            color = colors
        ),
        fontSize = typography.title20.fontSize,
        fontWeight = typography.title20.fontWeight
    )
}

@Composable
fun Title20BoldText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = typography.title20Bold.fontFamily,
            color = colors
        ),
        fontSize = typography.title20Bold.fontSize,
        fontWeight = typography.title20Bold.fontWeight
    )
}

@Composable
fun Title18Text(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = typography.title18.fontFamily,
            color = colors
        ),
        fontSize = typography.title18.fontSize,
        fontWeight = typography.title18.fontWeight
    )
}

@Composable
fun Title18BoldText(
    text: String,
    colors: Color = Color.White,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = typography.title18Bold.fontFamily,
            color = colors
        ),
        fontSize = typography.title18Bold.fontSize,
        fontWeight = typography.title18Bold.fontWeight
    )
}

@Composable
fun TitleText(
    text: String,
    colors: Color = Color.White,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = typography.title22.fontFamily,
            color = colors
        ),
        fontSize = typography.title22.fontSize,
        fontWeight = typography.title22.fontWeight
    )
}

@Composable
fun BigTitleText(
    text: String,
    colors: Color = Color.White,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = typography.title40.fontFamily,
            color = colors
        ),
        fontSize = typography.title40.fontSize,
        fontWeight = typography.title40.fontWeight
    )
}

@Composable
fun SubtitleText(
    text: String,
    colors: Color = Color.White,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    maxLines: Int = 10
) {
    Text(
        maxLines = maxLines,
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = typography.subtitle.fontFamily,
            color = colors
        ),
        fontSize = typography.subtitle.fontSize,
        fontWeight = typography.subtitle.fontWeight,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun SubtitleBoldText(
    text: String,
    colors: Color = Color.White,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = typography.subtitleBold.fontFamily,
            color = colors
        ),
        fontSize = typography.subtitleBold.fontSize,
        fontWeight = typography.subtitleBold.fontWeight
    )
}

@Composable
fun NormalBoldText(
    text: String,
    colors: Color = Color.White,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = typography.normalBold.fontFamily,
            color = colors
        ),
        fontSize = typography.normalBold.fontSize,
        fontWeight = typography.normalBold.fontWeight
    )
}

@Composable
fun NormalSmallText(
    text: String,
    colors: Color = Color.White,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = typography.normalSmall.fontFamily,
            color = colors
        ),
        fontSize = typography.normalSmall.fontSize,
        fontWeight = typography.normalSmall.fontWeight
    )
}

@Composable
fun SmallBoldText(
    text: String,
    colors: Color = Color.White,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = typography.normalSmallBold.fontFamily,
            color = colors
        ),
        fontSize = typography.normalSmallBold.fontSize,
        fontWeight = typography.normalSmallBold.fontWeight
    )
}

@Composable
fun SmallText(
    text: String,
    colors: Color = Color.White,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = typography.normalSmall.fontFamily,
            color = colors
        ),
        fontSize = typography.normalSmall.fontSize,
        fontWeight = typography.normalSmall.fontWeight
    )
}
