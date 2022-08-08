package com.example.feature_pokedex.home


import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import base_feature.utils.extensions.useCase
import coil.Coil
import coil.imageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.domain.model.pokedex.PokedexListModel
import com.example.domain.model.pokedex.ResultModel
import com.example.domain.usecase.pokedex.pokedex_home.GetAllPokemonsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class PokemonHomeViewModel : ViewModel(), KoinComponent {

    private val getAllPokemonsUseCase: GetAllPokemonsUseCase by useCase()

    private val _getAllPokemonsViewState = MutableStateFlow<PokedexListModel?>(null)

    val getAllPokemonsViewState: StateFlow<PokedexListModel?> = _getAllPokemonsViewState


    private val _errorMessage = MutableStateFlow<String?>(null)

    val errorMessage: StateFlow<String?> = _errorMessage

    private var currentPage = 0
    private var limit = 20

    var pokemonList = mutableStateOf(listOf<ResultModel>())



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


    fun calculateDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)

        Palette.from(bmp).generate { palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
        }
    }

    fun loadMorePokemons(){
        limit += 20
        getAllPokemons()
    }

    fun getAllPokemons() {
        getAllPokemonsUseCase(
            params = GetAllPokemonsUseCase.Params(limit, currentPage),
            onSuccess = {
                it.let {
                    _getAllPokemonsViewState.value = it
                }
            },
            onError = {
                    _errorMessage.value = it.message
            }
        )
    }


}
