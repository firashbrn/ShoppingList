import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ItemInput(text: String, onTextChange: (String) -> Unit, onAddItem:
    () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            label = { Text("Add new item") },
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(16.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = onAddItem,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC58CB5),
                contentColor = Color(0xFF852F6A),
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.DarkGray
            )) {
            Icon(imageVector = Icons.Default.Add,
                contentDescription = "Add Item",
                )
            Spacer(modifier = Modifier.width(4.dp))
            Text("Add")
        }
    }
}