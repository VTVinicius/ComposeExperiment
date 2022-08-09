package com.example.feature_pokedex.utils

import androidx.compose.ui.graphics.Color
import com.example.data_remote.model.pokemon.StatModel
import com.example.data_remote.model.pokemon.Type
import com.example.data_remote.model.pokemon.TypeModel
import uikit.theme.*
import uikit.theme.ComposeTheme.colors
import java.util.*

fun parseTypeToColor(type: TypeModel): Color {
    return when(type.type.name.lowercase(Locale.ROOT)) {
        "normal" -> typeNormal
        "fire" -> typeFire
        "water" -> typeWater
        "electric" -> typeElectric
        "grass" -> typeGrass
        "ice" -> typeIce
        "fighting" -> typeFighting
        "poison" -> typePoison
        "ground" -> typeGround
        "flying" -> typeFlying
        "psychic" -> typePsychic
        "bug" -> typeBug
        "rock" -> typeRock
        "ghost" -> typeGhost
        "dragon" -> typeDragon
        "dark" -> typeDark
        "steel" -> typeSteel
        "fairy" -> typeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(stat: StatModel): Color {
    return when(stat.stat.name.lowercase()) {
        "hp" -> hpColor
        "attack" -> atkColor
        "defense" -> defColor
        "special-attack" -> spAtkColor
        "special-defense" -> spDefColor
        "speed" -> spdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: StatModel): String {
    return when(stat.stat.name.lowercase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}

