package uikit.compose.base

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import uikit.theme.ComposeTheme
import uikit.theme.ComposeThemes

abstract class BaseComposeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AbstractComposeView(context, attrs, defStyle) {

    @Composable
    override fun Content() {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        ComposeThemes {
            Component()
        }
    }

    @Composable
    abstract fun Component()
}