package uikit.compose.components.buttons

import android.content.Context
import android.util.AttributeSet
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.uikit.R
import uikit.compose.base.BaseComposeView
import uikit.theme.AppColors

@Composable
fun OutlineButton(
    text: String,
    onClick: () -> Unit,
    iconLeft: Int? = null,
    iconRight: Int? = null,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        border = BorderStroke(1.dp, colorResource(id = R.color.black)),
        shape = RoundedCornerShape(8.dp),
        onClick = onClick,
        modifier = modifier.defaultMinSize(290.dp, 48.dp)
    ) {
        BaseIconLeftButton(iconLeft = iconLeft)
        Text(
            text = text,
            style = TextStyle(
                color = colorResource(id = R.color.black),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(4.dp)
        )
        BaseIconRightButton(iconRight = iconRight)
    }
}

@Preview
@Composable
fun OutlineButtonPreview() {
    MaterialTheme {
        AndroidView(
            factory = {
                OutlineButtonView(context = it).apply {
                    setText("Teste interator")
                    setOnClick {
                        setText("Test")
                    }
                }
            }
        )
    }
}

class OutlineButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : BaseComposeView(context, attrs, defStyle) {

    private var _text by mutableStateOf("Teste")
    private var _onClick by mutableStateOf({})

    @Composable
    override fun Component() {
        OutlineButton(_text, _onClick)
    }

    fun setText(input: String) {
        _text = input
    }

    fun setOnClick(onClick: () -> Unit) {
        _onClick = onClick
    }
}