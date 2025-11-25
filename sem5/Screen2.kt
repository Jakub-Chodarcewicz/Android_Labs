package com.example.szablon

import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.szablon.ui.theme.Blue200
import com.example.szablon.ui.theme.Blue500
import com.example.szablon.ui.theme.Blue900

@Composable
fun Screen2(
    navController: NavController,
    x: Float,
    y: Float,
    z: Float,
    sensorViewModel: SensorViewModel

) {
Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
) {
    val roundedX = String.format("%.2f", -(x*10))
    val roundedY = String.format("%.2f", -(y*10))
    val roundedZ = String.format("%.2f", -(z*10))
    Spacer(modifier = Modifier.height(64.dp))
    Text(text = "To jest ekran 2", fontWeight = FontWeight.Bold , fontSize = 48.sp)
    Spacer(modifier = Modifier.height(32.dp))
    // Display real-time accelerometer readings
    Text("Real-time Accelerometer X: $roundedX")
    Text("Real-time Accelerometer Y: $roundedY")
    Text("Real-time Accelerometer Z: $roundedZ")
    Spacer(modifier = Modifier.height(32.dp))
    ElevatedButton(
        onClick = {
            navController.navigate("screen3")
        },
        modifier = Modifier
            .width(170.dp),
        enabled = true,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = Blue500,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.onTertiaryContainer
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = "Navigate to Screen 3")
    }
    Spacer(modifier = Modifier.height(5.dp))
    
    SpiritLevelView()
}
}
@Preview
@Composable
fun PreviewScreen2(){
    MaterialTheme {
        Surface {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Naviaget to screen 3")
            }
        }

    }
}