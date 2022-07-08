package uikit.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.uikit.R

private val nunitoRegular = FontFamily(
    Font(R.font.nunito_regular, FontWeight.Normal)
)

data class AppTypography(
    val h1: TextStyle = TextStyle(
        fontFamily = nunitoRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    val subtitle: TextStyle = TextStyle(
        fontFamily = nunitoRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    val body: TextStyle = TextStyle(
        fontFamily = nunitoRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    val button: TextStyle = TextStyle(
        fontFamily = nunitoRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    val caption: TextStyle = TextStyle(
        fontFamily = nunitoRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )  ,
    val title: TextStyle = TextStyle(
        fontFamily = nunitoRegular,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )  ,
    val normal: TextStyle = TextStyle(
        fontFamily = nunitoRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )  ,
    val normalBold: TextStyle = TextStyle(
        fontFamily = nunitoRegular,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )
)

internal val LocalTypography = staticCompositionLocalOf { AppTypography() }