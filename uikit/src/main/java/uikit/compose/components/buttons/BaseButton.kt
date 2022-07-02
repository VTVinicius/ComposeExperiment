package uikit.compose.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BaseIconLeftButton(iconLeft: Int?) {
    iconLeft?.let {
        Image(
            painterResource(id = it),
            contentDescription = null
        )
    } ?: Spacer(modifier = Modifier.size(48.dp))
}

@Composable
fun BaseIconRightButton(iconRight: Int?) {
    iconRight?.let {
        Image(
            painterResource(id = it),
            contentDescription = null
        )
    } ?: Spacer(modifier = Modifier.size(48.dp))
}

@Composable
fun BaseIconCenterButton(iconCenter: Int?) {
    iconCenter?.let {
        Image(
            painterResource(id = it),
            contentDescription = null,
        )
    } ?: Spacer(modifier = Modifier.size(48.dp))
}