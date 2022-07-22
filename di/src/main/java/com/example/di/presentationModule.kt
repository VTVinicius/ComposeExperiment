package com.example.di

import base_feature.home.home_screen.HomeScreenViewModel
import com.example.feature_pokedex.home.PokemonHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

//    viewModel { CardListViewModel() }
    viewModel { HomeScreenViewModel() }
    viewModel { PokemonHomeViewModel() }



}