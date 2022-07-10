package base_feature.home.navigation

import androidx.navigation.NavDirections

interface HomeNavigation {

    fun goToProfileNavigation(navDirections: NavDirections)

    fun goToPokedexNavigation(navDirections: NavDirections)

}