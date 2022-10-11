package com.example.feature_examples.inptu_text

import BasicInputText
import CPFInputText
import CepInputText
import EmailInputText
import NameInputText
import OnlyLettersInputText
import OnlyNumbersInputText
import PasswordInputText
import PhoneInputText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import base_feature.utils.extensions.compose.VerticalSpacer
import com.example.feature_examples.navigation.ExamplesNavigation
import uikit.compose.SubtitleText
import uikit.compose.Title18Text
import uikit.compose.Title20BoldText
import uikit.theme.background
import uikit.theme.cinza


@Composable
fun InputTextsView(
    navigation: ExamplesNavigation,
    navController: NavController
) {

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .background(background)
            .padding(32.dp)

    ) {

        Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
            Title20BoldText(text = "Campos de Texto")
        }

        VerticalSpacer(height = 24)

        SubtitleText(text = "Input de Texto para CEP.")

        VerticalSpacer(height = 8)

        CepInputText(onSearch = {}, state = InputTextState.NORMAL)

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto para CPF.")

        VerticalSpacer(height = 8)

        CPFInputText(onSearch = {}, state = InputTextState.GRAY)

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto para Email.")

        VerticalSpacer(height = 8)

        EmailInputText(onSearch = {}, state = InputTextState.OUTLINE)

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto para Nome.")

        VerticalSpacer(height = 8)

        NameInputText(onSearch = {}, state = InputTextState.NORMAL)

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto para Senha.")

        VerticalSpacer(height = 8)

        PasswordInputText(onSearch = {})

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto para Celular.")

        VerticalSpacer(height = 8)

        PhoneInputText(onSearch = {}, state = InputTextState.GRAY)

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto que aceita apenas Letras.")

        VerticalSpacer(height = 8)

        OnlyLettersInputText(maxLength = 60, onSearch = {}, state = InputTextState.OUTLINE)

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto que aceita apenas Numeros.")

        VerticalSpacer(height = 8)

        OnlyNumbersInputText(maxLength = 10, onSearch = {}, state = InputTextState.NORMAL)

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto basico, sem validações.")

        VerticalSpacer(height = 8)

        BasicInputText(maxLength = 100, onSearch = {}, state = InputTextState.GRAY)

    }


}