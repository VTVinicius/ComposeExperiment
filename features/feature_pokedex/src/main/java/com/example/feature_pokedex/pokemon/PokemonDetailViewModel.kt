package com.example.feature_pokedex.pokemon

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import base_feature.utils.extensions.useCase
import coil.imageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.domain.model.pokedex.PokedexListModel
import com.example.domain.model.pokedex.PokemonModel
import com.example.domain.usecase.pokedex.pokedex_home.GetAllPokemonsUseCase
import com.example.domain.usecase.pokedex.pokedex_pokemon.GetPokemonUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class PokemonDetailViewModel  : ViewModel(), KoinComponent {

    private val getPokemonUseCase: GetPokemonUseCase by useCase()

    private val _getPokemonViewState = MutableStateFlow<PokemonModel?>(null)

    val getPokemonViewState: StateFlow<PokemonModel?> = _getPokemonViewState

    private val _errorMessage = MutableStateFlow<String?>(null)

    val errorMessage: StateFlow<String?> = _errorMessage


    fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)

        Palette.from(bmp).generate{ palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
        }
    }

    fun fetchColors(url: String, context: Context, onCalculated: (Color) -> Unit) {
        viewModelScope.launch {
            // Requesting the image using coil's ImageRequest
            val req = ImageRequest.Builder(context)
                .data(url)
                .allowHardware(false)
                .build()

            val result = req.context.imageLoader.execute(req)

            if (result is SuccessResult) {
                // Save the drawable as a state in order to use it on the composable
                // Converting it to bitmap and using it to calculate the palette
                calcDominantColor(result.drawable) { color ->
                    onCalculated(color)
                }
            }
        }
    }

    fun getPokemon(name: String) {
        getPokemonUseCase(
            params = GetPokemonUseCase.Params(name),
            onSuccess = {
                it.let {
                    _getPokemonViewState.value = it
                }
            },
            onError = {
                _errorMessage.value = it.message
            }
        )
    }

}