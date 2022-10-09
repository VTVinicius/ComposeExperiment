package base_feature.utils.extensions.compose

import androidx.compose.runtime.Composable
import java.net.ConnectException
import java.net.UnknownHostException

interface ComposeViewStateListener {

    @Composable
    fun OnLoading()

    fun onLoading()

    fun hideLoading()

    @Composable
    fun HideLoading()

    @Composable
    fun HandleUnauthorizedException(error: Throwable)

    @Composable
    fun HandlePresentationException(error: Throwable, action: (() -> Unit)?)

    @Composable
    fun HandleNoNetworkConnectionException(action: (() -> Unit)?)

    @Composable
    fun HandleMaintenanceException()

    @Composable
    fun <T, State> ViewState<T>?.runOnState(
        onSuccess: (T?) -> State? = { null },
        onError: (Throwable?) -> State? = { null },
        onErrorAction: (() -> Unit)? = null,
        onDefault: () -> State? = { null },
        onLoading: (() -> Unit)? = null,
        showDataSourceException: Boolean = true
    ): State? {
        if (this.isLoading()) onLoading?.invoke() ?: OnLoading()

        return when {
            this.isSuccess() -> onSuccess.invoke(this?.data) ?: onDefault.invoke()
            this.isError() -> {
                HideLoading()
                this?.HandleError(onError, onErrorAction, showDataSourceException)
            }
            else -> onDefault.invoke()
        }
    }

    @Composable
    private fun <T, State> ViewState<T>.HandleError(
        onError: ((Throwable?) -> State)? = null,
        onErrorAction: (() -> Unit)? = null,
        showDataSourceException: Boolean = true
    ): State? {
        when (error) {
//            is UnauthorizedException -> {
//                HandleUnauthorizedException(error = error)
//            }
//            is DataSourceException -> {
//                if (error.itIsInMaintenance()) {
//                    HandleMaintenanceException()
//                } else {
//                    if (showDataSourceException) HandlePresentationException(
//                        error = error,
//                        action = onErrorAction
//                    )
//                }
//            }
            is UnknownHostException, is ConnectException -> {
                HandleNoNetworkConnectionException(action = onErrorAction)
            }
        }
        return onError?.invoke(error)
    }
}