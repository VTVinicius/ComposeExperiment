package com.example.di

import com.example.feature.cards_list.CardListViewModel
import com.example.feature.home_screen.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { CardListViewModel() }
    viewModel { HomeScreenViewModel() }


}