
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import uikit.compose.SmallBoldText
import uikit.compose.SmallText
import uikit.compose.utils.HorizontalSpacer
import uikit.compose.utils.RegexEnum
import uikit.compose.utils.VerticalSpacer
import uikit.theme.ComposeTheme
import uikit.theme.cinza
import uikit.theme.red


@Composable
fun BaseInputText(
    modifier: Modifier = Modifier,
    hint: String = "",
    mask: VisualTransformation? = null,
    maxLength: Int? = null,
    state: InputTextState = InputTextState.NORMAL,
    onSearch: (String) -> Unit = {},
    onIconClick: () -> Unit = {},
    inputType: RegexEnum? = null,
    styleType: InputTextStyleType = InputTextStyleType.NOTHING,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
) {

    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }
    var isFieldEmpty by remember {
        mutableStateOf(true)
    }

    Column {
        Box(
            modifier = modifier
        ) {
            TextField(
                value = text,
                onValueChange = {
                    if (it.length > (maxLength ?: 0)) {
                        return@TextField
                    } else if (it.matches(inputType?.value ?: RegexEnum.ALL.value)) {
                        text = it
                        onSearch(it)
                        isFieldEmpty = it == ""
                    } else if (it.length < text.length) {
                        text = it
                        isFieldEmpty = it == ""
                    }
                },
                visualTransformation =
                if (mask != null && mask is PasswordVisualTransformation) {
                    PasswordVisualTransformation()
                } else mask ?: VisualTransformation.None,
                trailingIcon =
                {
                    if (state.rightIcon != null) {
                        IconButton(
                            onClick = {
                                onIconClick()
                            }
                        ) {

                            Icon(
                                painter = painterResource(id = state.rightIcon!!),
                                contentDescription = "visibility Icon"
                            )
                        }
                    } else {
                        onIconClick()
                    }
                },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = keyboardOptions,
                textStyle = TextStyle(color = Color.Black),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = state.getBackgroundColor(),
                    cursorColor = Color.Black,
                    disabledLabelColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = ComposeTheme.dimensions.defaultSize,
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .border(
                        width = state.getBorderSize(),
                        color = state.getBorderColor(),
                        shape = ComposeTheme.dimensions.defaultSize,
                    )
                    .background(
                        state.getBackgroundColor(),
                        ComposeTheme.dimensions.defaultSize
                    )
                    .onFocusChanged {
                        if (isFieldEmpty) {
                            isHintDisplayed = it.isFocused != true
                        } else {
                            isHintDisplayed = false
                        }
                    },

                )
            if (isHintDisplayed) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp)
                ) {
                    SmallBoldText(text = hint, cinza)
                }
            }
        }
        VerticalSpacer(height = 2)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (styleType.errorMessage != "") {
                Icon(
                    painter = painterResource(id = R.drawable.ic_error_alert ),
                    tint = red,
                    modifier = Modifier.size(16.dp),
                    contentDescription = "Error Icon"
                )

                HorizontalSpacer(width = 4)

                SmallText(
                    text = styleType.errorMessage,
                    colors = red,
                    align = TextAlign.Start,
                )
            }
        }
    }
}


