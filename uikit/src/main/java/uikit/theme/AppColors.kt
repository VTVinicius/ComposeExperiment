package uikit.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class AppColors(
    primary: Color,
    textPrimary: Color,
    textSecondary: Color,
    background: Color,
    error: Color,
    success: Color,
    isLight: Boolean,
) {



    var primary by mutableStateOf(primary)
    var textSecondary by mutableStateOf(textSecondary)
    var textPrimary by mutableStateOf(textPrimary)
    var error by mutableStateOf(error)
    var background by mutableStateOf(background)
    var success by mutableStateOf(success)
    var isLight by mutableStateOf(isLight)

    fun copy(
        primary: Color = this.primary,
        textPrimary: Color = this.textPrimary,
        textSecondary: Color = this.textSecondary,
        error: Color = this.error,
        background: Color = this.background,
        success: Color = this.success,
        isLight: Boolean = this.isLight
    ): AppColors = AppColors(
        primary,
        textPrimary,
        textSecondary,
        error,
        background,
        success,
        isLight
    )

    fun updateColorsFrom(other: AppColors) {
        primary = other.primary
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        background = other.background
        error = other.error
    }
}

private val colorPrimary = Color(0xFF000000)
private val colorTextPrimary = Color(0xFF323F4B)
private val colorTextSecondary = Color(0xFF556F97)
private val colorBackground = Color(0xFFF6F6F6)
private val colorError = Color(0xFFBC2F2F)
private val colorSuccess = Color(0xFF008423)

fun lightColors(
    primary: Color = colorPrimary,
    textPrimary: Color = colorTextPrimary,
    textSecondary: Color = colorTextSecondary,
    background: Color = colorBackground,
    error: Color = colorError,
    success: Color = colorSuccess
): AppColors = AppColors(
    primary = primary,
    textPrimary = textPrimary,
    textSecondary = textSecondary,
    background = background,
    error = error,
    success = success,
    isLight = true
)

val LocalColors = staticCompositionLocalOf { lightColors() }

val hpColor = Color(0xFFF5FF00)
val atkColor = Color(1f, 0f, 0f, 0.66f)
val defColor = Color(0f, 0f, 1f, 0.44f)
val spAtkColor = Color(0.671f, 0f, 1f, 0.57f)
val spDefColor = Color(1f, 0f, 0.8f, 0.7f)
val spdColor = Color(0f, 1f, 0.063f, 0.55f)

val typeNormal = Color(0xFFA8A77A)
val typeFire = Color(0xFFEE8130)
val typeWater = Color(0xFF6390F0)
val typeElectric = Color(0xFFF7D02C)
val typeGrass = Color(0xFF7AC74C)
val typeIce = Color(0xFF96D9D6)
val typeFighting = Color(0xFFC22E28)
val typePoison = Color(0xFFA33EA1)
val typeGround = Color(0xFFE2BF65)
val typeFlying = Color(0xFFA98FF3)
val typePsychic = Color(0xFFF95587)
val typeBug = Color(0xFFA6B91A)
val typeRock = Color(0xFFB6A136)
val typeGhost = Color(0xFF735797)
val typeDragon = Color(0xFF6F35FC)
val typeDark = Color(0xFF705746)
val typeSteel = Color(0xFFB7B7CE)
val typeFairy = Color(0xFFD685AD)
val cinza = Color(0xFF515151)
var red = Color(0xFFFF0000)
val inputTextGrey = Color(0XFFEBEBEB)
val background = Color(0XFFDDDADA)