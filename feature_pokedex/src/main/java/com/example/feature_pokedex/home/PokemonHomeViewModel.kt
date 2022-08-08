package com.example.feature_pokedex.home


import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.palette.graphics.Palette
import base_feature.utils.extensions.useCase
import com.example.domain.model.pokedex.PokedexListModel
import com.example.domain.model.pokedex.ResultModel
import com.example.domain.usecase.pokedex.pokedex_home.GetAllPokemonsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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




    fun calculateDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)

        Palette.from(bmp).generate { palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
        }
    }

    fun loadMorePokemons(){
        currentPage++
        limit + 20
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
