package uikit.compose.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R

@Composable
fun OutlineButton(
    text: String,
    onClick: () -> Unit,
    iconLeft: Int? = null,
    iconRight: Int? = null,
    modifier: Modifier = Modifier,
    backgroundColor : Int = R.color.white,
    textColor: Int = R.color.black
) {
    Row(Modifier.fillMaxWidth()) {
        OutlinedButton(
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = backgroundColor)),
            border = BorderStroke(1.dp, colorResource(id = R.color.black)),
            shape = RoundedCornerShape(8.dp),
            onClick = onClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            BaseIconLeftButton(iconLeft = iconLeft)
            Text(
                text = text,
                style = TextStyle(
                    color = colorResource(id = textColor),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(4.dp)
            )
            BaseIconRightButton(iconRight = iconRight)
        }
    }
}

@Preview
@Composable
fun OutlineButtonPreview() {
    OutlineButton(
        text = "OutlineButton",
        onClick = {},
        iconLeft = null,
        iconRight = null,
        modifier = Modifier.padding(16.dp)
    )
}
