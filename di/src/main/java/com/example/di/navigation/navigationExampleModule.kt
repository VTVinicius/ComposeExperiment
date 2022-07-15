package com.example.di.navigation

import com.example.feature.commom.navigation.ProfileNavigation
import com.example.feature_pokedex.home.common.navigation.PokedexNavigation
import com.example.navigation.navigatiors.pokedex.PokedexNavigationImpl
import com.example.navigation.navigatiors.profile.ProfileNavigationImpl
import org.koin.dsl.module

val navigationExampleModule = module {

    factory<ProfileNavigation> {
        ProfileNavigationImpl()
    }

    factory<PokedexNavigation> {
        PokedexNavigationImpl()
    }

    factory<ProfileNavigation> {
        ProfileNavigationImpl()
    }

}