package com.example.feature_pokedex.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import uikit.compose.NormalText


@Composable
fun BasicSearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {},
    onIconClick: (String) -> Unit = {},
) {

    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier) {
        TextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            trailingIcon = {
                    IconButton(
                        onClick = {
                            if (text.isEmpty()) {

                            } else {
                                onIconClick(text)
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = com.example.uikit.R.drawable.ic_right_arrow),
                            contentDescription = "visibility Icon"
                        )
                    }
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                cursorColor = Color.Black,
                disabledLabelColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .border(
                    width = 0.dp,
                    color = Color.Transparent,
                    shape = RoundedCornerShape(10.dp),
                )
                .background(
                    color = Color.White,
                    RoundedCornerShape(10.dp),
                )
                .onFocusChanged {
                    isHintDisplayed = it.isFocused != true
                })

        if (isHintDisplayed) {
            Row(modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp)) {
                NormalText(text = hint, textColor = com.example.uikit.R.color.lightGrey)
            }

        }
    }


}