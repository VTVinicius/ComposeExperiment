package base_feature.utils.extensions.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

@Composable
fun LifecycleManager(
    lifeCycle: State<LifecycleOwner>,
    onCreate: (() -> Unit)? = null,
    onPause: (() -> Unit)? = null,
    onDestroy: (() -> Unit)? = null,
    onResume: (() -> Unit)? = null,
) {
    DisposableEffect(lifeCycle.value) {
        val lifecycle = lifeCycle.value.lifecycle
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> onCreate?.invoke()
                Lifecycle.Event.ON_RESUME -> onResume?.invoke()
                Lifecycle.Event.ON_PAUSE -> onPause?.invoke()
                Lifecycle.Event.ON_DESTROY -> onDestroy?.invoke()
                else -> {}
            }
        }
        lifecycle.addObserver(observer)

        onDispose {
            lifecycle.removeObserver(observer)
        }
    }
}