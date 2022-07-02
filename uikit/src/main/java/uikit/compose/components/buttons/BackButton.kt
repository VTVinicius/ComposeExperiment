package uikit.compose.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R

@Composable
fun BackButton(
    onClick: () -> Unit,
    backgroundColor : Int = R.color.lightBlue,
    strokeColor: Int = R.color.darkBlue
){
    OutlinedButton(
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = backgroundColor)),
        border = BorderStroke(1.dp, colorResource(id = strokeColor)),
        shape = RoundedCornerShape(16.dp),
        onClick = onClick,
        modifier = Modifier.size(height = 48.dp, width = 48.dp)
    ) {
            BaseIconCenterButton(R.drawable.ic_back_arrow)
    }
}