package uikit.compose.components.buttons

import android.view.View
import android.widget.Button
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import uikit.compose.ButtonText
import java.lang.reflect.Modifier

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    iconLeft: Int? = null,
    iconRight: Int? = null,
    modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            onClick = onClick,
            modifier = modifier,
        ) {
            Row(
                androidx.compose.ui.Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
            BaseIconLeftButton(iconLeft = iconLeft)
            ButtonText(text = text, modifier = modifier)
            BaseIconRightButton(iconRight = iconRight)
        }
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    PrimaryButton(
        text = "OutlineButton",
        onClick = {},
        iconLeft = null,
        iconRight = null,
        modifier = androidx.compose.ui.Modifier.padding(16.dp)
    )
}
