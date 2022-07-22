package com.example.di.navigation

import base_feature.home.navigation.HomeNavigation
import com.example.feature.commom.navigation.ProfileNavigation
import com.example.feature_pokedex.common.navigation.PokedexNavigation
import com.example.navigation.navigatiors.base_feature.HomeNavigationImpl
import com.example.navigation.navigatiors.pokedex.PokedexNavigationImpl
import com.example.navigation.navigatiors.profile.ProfileNavigationImpl
import org.koin.dsl.module

val navigationExampleModule = module {

    factory<HomeNavigation> {
        HomeNavigationImpl()
    }

    factory<PokedexNavigation> {
        PokedexNavigationImpl()
    }

    factory<ProfileNavigation> {
        ProfileNavigationImpl()
    }

}