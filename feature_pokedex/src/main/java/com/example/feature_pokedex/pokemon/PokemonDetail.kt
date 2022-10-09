package com.example.feature_pokedex.home

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import base_feature.utils.extensions.compose.VerticalSpacer
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.data_remote.model.pokemon.TypeModel
import com.example.domain.model.pokedex.PokemonModel
import com.example.feature_pokedex.R
import com.example.feature_pokedex.common.navigation.PokedexNavigation
import com.example.feature_pokedex.pokemon.PokemonDetailViewModel
import com.example.feature_pokedex.utils.parseStatToColor
import com.example.feature_pokedex.utils.parseTypeToColor
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import uikit.theme.atkColor
import uikit.theme.defColor
import uikit.theme.hpColor
import java.util.*
import kotlin.math.round


@Composable
fun PokemonDetail(
    listener: PokedexNavigation?,
    navController: NavController,
    pokemonName: String,
) {

    val viewmodel = getViewModel<PokemonDetailViewModel>()

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(LocalContext.current) {
        coroutineScope.launch {
            viewmodel.getPokemon(pokemonName)
        }
    }

    val defaultDominantColor = MaterialTheme.colors.surface
    var dominantColor by remember {
        mutableStateOf(defaultDominantColor)
    }

    var entries: PokemonModel? by remember {
        mutableStateOf(null)
    }
    val response by viewmodel.getPokemonViewState.collectAsState(initial = null)
    val error by viewmodel.errorMessage.collectAsState(initial = null)

    val number = response?.id
    val url =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"

    viewmodel.fetchColors(url, context = LocalContext.current) {
        dominantColor = it
    }


    entries = response

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(dominantColor)
            .padding(bottom = 16.dp)
    ) {
        PokemonDetailTopSection(
            navController = navController,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .align(Alignment.TopCenter)
        )

        PokemonDetailStateWrapper(
            pokemonInfo = entries,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 20.dp + 200.dp / 2f,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
                .shadow(10.dp, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colors.surface)
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            loadingModifier = Modifier
                .size(100.dp)
                .align(Alignment.Center)
                .padding(
                    top = 20.dp + 200.dp / 2f,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                ),
            error = error != null,
        )
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(url)
                    .crossfade(true)
                    .build(),
                contentDescription = response?.name,
                modifier = Modifier
                    .size(200.dp)
                    .offset(y = 20.dp)
            )

        }
    }

}

@Composable
fun PokemonDetailTopSection(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = modifier
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.Black,
                        Color.Transparent
                    )
                )
            )
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(36.dp)
                .offset(16.dp, 16.dp)
                .clickable {
                    navController.popBackStack()
                }
        )
    }
}

@Composable
fun PokemonDetailStateWrapper(
    pokemonInfo: PokemonModel?,
    modifier: Modifier = Modifier,
    loadingModifier: Modifier = Modifier,
    error: Boolean
) {

    PokemonDetailSection(
        pokemonInfo = pokemonInfo,
        modifier = modifier
            .offset(y = (-20).dp)
    )
    if (error) {
        Text(
            text = "Error",
            color = Color.Red,
            modifier = modifier
        )
    }

}

@Composable
fun PokemonDetailSection(
    pokemonInfo: PokemonModel?,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .offset(y = 100.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "#${pokemonInfo?.id} ${pokemonInfo?.name?.capitalize(Locale.ROOT)}",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onSurface
        )

        PokemonTypeSection(types = pokemonInfo?.typeModels)
        if (pokemonInfo != null) {
            PokemonDetailDataSection(
                pokemonWeight = pokemonInfo.weight,
                pokemonHeight = pokemonInfo.height
            )
        }

        PokemonBaseStats(pokemonInfo = pokemonInfo)
    }
}

@Composable
fun PokemonTypeSection(types: List<TypeModel>?) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
    ) {
        if (types != null) {
            for (type in types) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                        .clip(CircleShape)
                        .background(parseTypeToColor(type))
                        .height(35.dp)
                ) {
                    type.type.name.capitalize(Locale.ROOT).let {
                        Text(
                            text = it,
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PokemonDetailDataSection(
    pokemonWeight: Int,
    pokemonHeight: Int,
    sectionHeight: Dp = 80.dp
) {
    val pokemonWeightInKg = remember {
        round((pokemonWeight.times(100f)) / 1000f)
    }
    val pokemonHeightInMeters = remember {
        round((pokemonHeight.times(100f)) / 1000f)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        PokemonDetailDataItem(
            dataValue = pokemonWeightInKg,
            dataUnit = "kg",
            dataIcon = R.drawable.ic_weight,
            modifier = Modifier.weight(1f)
        )
        Spacer(
            modifier = Modifier
                .size(1.dp, sectionHeight)
                .background(Color.LightGray)
        )
        PokemonDetailDataItem(
            dataValue = pokemonHeightInMeters,
            dataUnit = "m",
            dataIcon =  R.drawable.height_ic,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun PokemonDetailDataItem(
    dataValue: Float,
    dataUnit: String,
    dataIcon: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Icon(painter = painterResource(id = dataIcon), contentDescription = null, tint = MaterialTheme.colors.onSurface)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "$dataValue$dataUnit",
            color = MaterialTheme.colors.onSurface
        )
    }
}


@Composable
fun PokemonStat(
    statName: String,
    statValue: Int,
    statMaxValue: Int,
    statColor: Color,
    height: Dp = 28.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curPercent = animateFloatAsState(
        targetValue = if (animationPlayed) {
            statValue / statMaxValue.toFloat()
        } else 0f,
        animationSpec = tween(
            animDuration,
            animDelay
        )
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .clip(CircleShape)
            .background(
                if (isSystemInDarkTheme()) {
                    Color(0xFF505050)
                } else {
                    Color.LightGray
                }
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(curPercent.value)
                .clip(CircleShape)
                .background(statColor)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = statName,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = (curPercent.value * statMaxValue).toInt().toString(),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun PokemonBaseStats(
    pokemonInfo: PokemonModel?,
    animDelayPerItem: Int = 100
) {

    val maxBaseStat = remember {
        pokemonInfo?.statModels?.maxOf { it.base_stat }
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Base stats:",
            fontSize = 20.sp,
            color = MaterialTheme.colors.onSurface
        )


        Spacer(modifier = Modifier.height(4.dp))

        VerticalSpacer(height = 16)
        PokemonStat(statName = "HP", statValue = 45, statColor = hpColor, statMaxValue = 100)
        VerticalSpacer(height = 16)
        PokemonStat(statName = "Attack", statValue = 63, statColor = atkColor, statMaxValue = 100)
        VerticalSpacer(height = 16)
        PokemonStat(statName = "Defense", statValue = 35, statColor = defColor, statMaxValue = 100)
        VerticalSpacer(height = 16)


        pokemonInfo?.statModels?.forEach {
            PokemonStat(
                statName = it.stat.name,
                statValue = it.base_stat,
                statMaxValue = 100,
                statColor = Color.Red,
                animDelay = 2 * animDelayPerItem
            )
        }

    }
    Spacer(modifier = Modifier.height(8.dp))
}

