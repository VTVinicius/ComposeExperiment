package base_feature.utils.extensions.compose

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.*


//@Composable
//fun ScrollState.OnBottomReached(
//    offset: Int = 0,
//    loadMore: () -> Unit,
//) {
//    val shouldLoadMore = remember {
//        derivedStateOf {
//            this.value >= (this.maxValue - offset)
//        }
//    }
//
//    // Convert the state into a cold flow and collect
//    LaunchedEffect(shouldLoadMore) {
//        snapshotFlow { shouldLoadMore.value }
//            .collect {
//                if (it) loadMore()
//            }
//    }
//}

@Composable
fun LazyListState.OnBottomReached(
    offset: Int = 1,
    loadMore: () -> Unit,
){
    if(layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - offset){
        loadMore()
    }
}

//@Composable
//fun LazyListState.OnBottomReached2(
//    offset: Int = 1,
//    loadMore: () -> Unit,
//){
//    val shouldLoadMore = remember {
//        derivedStateOf {
//            layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - offset
//        }
//    }
//
//    LaunchedEffect(shouldLoadMore) {
//        snapshotFlow { shouldLoadMore.value }
//            .collect {
//                if (it) loadMore()
//            }
//    }
//}