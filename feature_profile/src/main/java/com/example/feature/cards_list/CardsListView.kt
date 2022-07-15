package com.example.feature.cards_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.domain.model.cardlist.InfosCard
import com.example.feature.R
import com.example.feature.cards_list.components.IdCards
import com.example.feature.commom.navigation.ProfileNavigation
import uikit.compose.components.top_bar.TopBar

@Composable
fun CardsListLayout(listener: ProfileNavigation?, navController: NavController) {
    val listenerNav = listener
    val list: MutableList<InfosCard> = mutableListOf()
//    val viewModel by viewModel<CardListViewModel>()


    Column(Modifier.background(colorResource(id = R.color.background))) {
        TopBar(
            onClickBack = { listenerNav?.goToPopBackStack(navController = navController) },
            title = stringResource(R.string.cards_list)
        )

        LazyColumn() {
            items(list.size) {
                IdCards(list[it].name, list[it].company, list[it].profession )
            }
        }
    }


}

