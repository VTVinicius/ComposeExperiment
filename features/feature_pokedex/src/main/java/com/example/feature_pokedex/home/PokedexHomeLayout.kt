package com.example.feature_pokedex.home

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import base_feature.utils.extensions.compose.HorizontalSpacer
import base_feature.utils.extensions.compose.LifecycleManager
import base_feature.utils.extensions.compose.OnBottomReached
import base_feature.utils.extensions.compose.VerticalSpacer
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.domain.model.pokedex.PokedexListEntry
import com.example.domain.model.pokedex.ResultModel
import com.example.domain.utils.capitalized
import com.example.feature_pokedex.R
import com.example.feature_pokedex.common.navigation.PokedexNavigation
import com.example.feature_pokedex.home.components.BasicSearchBar
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import uikit.compose.TitleBoldText
import uikit.compose.components.buttons.BackButton


@Composable
fun PokedexHomeLayout(listener: PokedexNavigation, navController: NavController) {

    val viewmodel = getViewModel<PokemonHomeViewModel>()
    var entries: List<PokedexListEntry> by remember {
        mutableStateOf(emptyList<PokedexListEntry>())
    }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(LocalContext.current) {
        coroutineScope.launch {
            viewmodel.getAllPokemons()
        }
    }

    val response by viewmodel.getAllPokemonsViewState.collectAsState(initial = null)
    val error by viewmodel.errorMessage.collectAsState(initial = null)



    Surface(
        color = colorResource(id = R.color.lightBlue),
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            BackButton(onClick = { listener.goToHomeNavigation(navController) })
        }

        Column() {

            VerticalSpacer(height = 24)
            Image(
                painter = painterResource(id = R.drawable.img_pokemon_logo),
                contentDescription = "POKEMON LOGO",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally)
            )
            VerticalSpacer(height = 24)

            BasicSearchBar(
                modifier = Modifier.padding(24.dp),
                hint = "Pesquisar..",
                onIconClick = {
                    listener.goToPokemonDetails(
                        pokemonName = it,
                        navController = navController
                    )
                })

            VerticalSpacer(height = 24)

            PokemonList(navController = navController, listener = listener, viewmodel = viewmodel)
        }


    }
}


@Composable
fun PokemonList(
    navController: NavController,
    listener: PokedexNavigation,
    viewmodel: PokemonHomeViewModel
) {
    var entries: List<ResultModel> by remember {
        mutableStateOf(emptyList<ResultModel>())
    }

    val response by viewmodel.getAllPokemonsViewState.collectAsState(initial = null)
    val error by viewmodel.errorMessage.collectAsState(initial = null)

    entries = response?.results ?: emptyList()

    val lazyState = rememberLazyListState()

    lazyState.OnBottomReached(offset = 2) {
        viewmodel.loadMorePokemons()
    }

    LazyColumn(state = lazyState, contentPadding = PaddingValues(16.dp)) {
        val itemCount = if (entries.size % 2 == 0) {
            entries.size / 2
        } else {
            entries.size / 2 + 1
        }
        items(itemCount) {
            PokedexRow(
                rowIndex = it,
                entries = entries,
                navController = navController,
                listener = listener,
                viewmodel = viewmodel
            )
        }
    }
}

@Composable
fun PokedexEntry(
    entry: ResultModel,
    modifier: Modifier = Modifier,
    navController: NavController,
    listener: PokedexNavigation,
) {


    val viewmodel = getViewModel<PokemonHomeViewModel>()

    val defaultDominantColor = MaterialTheme.colors.surface
    var dominantColor by remember {
        mutableStateOf(defaultDominantColor)
    }


    val number = if (entry.url.endsWith("/")) {
        entry.url.dropLast(1).takeLastWhile { it.isDigit() }
    } else {
        entry.url.takeLastWhile { it.isDigit() }
    }
    val url =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"



    viewmodel.fetchColors(url, context = LocalContext.current) {
        dominantColor = it
    }


    Box(contentAlignment = Center,
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(
                Brush.verticalGradient(
                    listOf(
                        dominantColor,
                        defaultDominantColor
                    )
                )
            )
            .clickable {
                listener.goToPokemonDetails(navController, entry.name)
            }
    )
    {

        Column {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(url)
                    .crossfade(true)
                    .build(),
                contentDescription = entry.name,
                modifier = Modifier
                    .size(120.dp)
                    .align(CenterHorizontally)
            )

            TitleBoldText(
                text = entry.name.capitalized(),
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )


        }

    }
}


@Composable
fun PokedexRow(
    rowIndex: Int,
    entries: List<ResultModel>,
    navController: NavController,
    listener: PokedexNavigation,
    viewmodel: PokemonHomeViewModel
) {
    if (!entries.isEmpty()) {
        Column {
            Row {
                PokedexEntry(
                    entry = entries[rowIndex * 2],
                    navController = navController,
                    listener = listener,
                    modifier = Modifier.weight(1f),
                )
                HorizontalSpacer(height = 16)
                if (entries.size >= rowIndex * 2 + 2) {
                    PokedexEntry(
                        entry = entries[rowIndex * 2 + 1],
                        navController = navController,
                        listener = listener,
                        modifier = Modifier.weight(1f),
                    )
                } else {
                    Spacer(Modifier.weight(1f))
                }
            }
            VerticalSpacer(height = 16)

        }
    }
}