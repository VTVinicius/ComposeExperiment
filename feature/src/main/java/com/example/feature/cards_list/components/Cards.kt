package com.example.feature.cards_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import uikit.compose.NormalText


@Composable
fun IdCards(name: String, company: String, profession: String) {

    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = colorResource(id = R.color.white),
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            NormalText(text = name)
            Spacer(modifier = Modifier.height(4.dp))
            NormalText(text = company)
            Spacer(modifier = Modifier.height(4.dp))
            NormalText(text = profession)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}