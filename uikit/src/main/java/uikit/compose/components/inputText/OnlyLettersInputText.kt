

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uikit.compose.utils.RegexEnum

@Composable
fun OnlyLettersInputText(
    modifier: Modifier = Modifier,
    state: InputTextState = InputTextState.NORMAL,
    hint: String = "",
    maxLength: Int,
    onSearch: (String) -> Unit
) {
    state.getPasswordIcon(null)

    BaseInputText(
        modifier = modifier,
        hint = hint,
        state = state,
        mask = VisualTransformation.None,
        maxLength = maxLength,
        inputType = RegexEnum.LETTERS,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        onSearch = onSearch
    )
}

@Preview
@Composable
fun OnlyLettersInputTextPreview() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        OnlyLettersInputText(
            state = InputTextState.NORMAL,
            hint = "Campo Simples apenas Letras",
            maxLength = 100,
            onSearch = {}
        )
    }
}