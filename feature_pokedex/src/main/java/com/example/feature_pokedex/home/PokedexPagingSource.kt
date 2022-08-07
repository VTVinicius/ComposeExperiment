//package com.example.feature_pokedex.home
//
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.example.domain.model.pokedex.PokedexListModel
//import com.example.domain.model.pokedex.ResultModel
//import com.example.domain.usecase.pokedex.pokedex_home.GetAllPokemonsUseCase
//import kotlinx.coroutines.async
//import kotlinx.coroutines.coroutineScope
//import kotlinx.coroutines.flow.collectLatest
//
//class PokedexPagingSource (
//    private val getAllPokemonsUseCase: GetAllPokemonsUseCase
//): PagingSource<Int, PokedexListModel>() {
//
//    private val initialPageIndex: Int = 0
//
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokedexListModel> {
//        val position = params.key ?: initialPageIndex
//        var response: LoadResult<Int, PokedexListModel> = LoadResult.Error(Throwable())
//        return coroutineScope {
//            val result = async {
//                try {
//                    getAllPokemonsUseCase.run(
//                        GetAllPokemonsUseCase.Params(
//                            NETWORK_PAGE_SIZE,
//                            params.key ?: initialPageIndex
//                        )
//                    ).collectLatest {
//                        response = LoadResult.Page(
//                            data = it,
//                            prevKey = if (position == initialPageIndex) null else position - 1,
//                            nextKey = if (it.isNullOrEmpty() || it.size < NETWORK_PAGE_SIZE) null else position + 1
//                        )
//                    }
//                } catch (exception: Exception) {
//                    response = LoadResult.Error(exception)
//                }
//            }
//
//            result.await()
//            return@coroutineScope response
//        }
//    }
//
//    companion object {
//        const val NETWORK_PAGE_SIZE = 20
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, PokedexListModel>): Int? = null
//
//
//}
