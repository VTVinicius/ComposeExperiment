import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import uikit.compose.utils.RegexEnum
import uikit.compose.utils.Validation

@Composable
fun PasswordInputText(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit,
    state: InputTextState = InputTextState.PASSWORD,
    showError: Boolean = true
) {

    var currentState: InputTextState = state

    val styleType: InputTextStyleType = InputTextStyleType.PASSWORD

    var passwordVisualTransformation: VisualTransformation by remember {
        mutableStateOf(PasswordVisualTransformation())
    }

    var error = remember { mutableStateOf(false) }

    LaunchedEffect(LocalContext.current) {
        currentState.getPasswordIcon(R.drawable.ic_eye_closed)
    }

    if (showError) {
        when (error.value) {
            true -> {
                currentState = InputTextState.PASSWORD_ERROR
                styleType.getErrorMessage("Sua senha deve conter no minimo 6 digitos, Letras Maiúsculas, Minúsculas, Números e Símbolos")
            }
            false -> {
                currentState = InputTextState.PASSWORD
                styleType.getErrorMessage("")
            }
        }
    }

    BaseInputText(
        modifier = modifier,
        hint = "Senha",
        state = currentState,
        mask = passwordVisualTransformation,
        maxLength = 100,
        inputType = RegexEnum.ALL,
        styleType = styleType,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        onIconClick = {
            if (passwordVisualTransformation is PasswordVisualTransformation) {
                passwordVisualTransformation = VisualTransformation.None
                currentState.getPasswordIcon(R.drawable.ic_eye_open)
            } else {
                passwordVisualTransformation = PasswordVisualTransformation()
                currentState.getPasswordIcon(R.drawable.ic_eye_closed)
            }
        },
        onSearch = {
            onSearch(it)
            when (Validation().validatePassword(it)) {
                true -> {
                    error.value = false
                }
                false -> {
                    error.value = true
                }
            }
        }
    )
}

@Preview
@Composable
fun PasswordInputTextPreview() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        PasswordInputText(onSearch = {})

    }
}