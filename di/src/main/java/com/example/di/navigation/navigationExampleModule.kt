package com.example.di.navigation

import androidx.navigation.NavController
import com.example.feature.commom.navigation.HomeNavigation
import com.example.navigation.navigatiors.feature.HomeNavigationImpl
import org.koin.dsl.module

val navigationExampleModule = module {

    factory<HomeNavigation> {
        HomeNavigationImpl()
    }

}