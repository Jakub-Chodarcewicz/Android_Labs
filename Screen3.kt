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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
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
import com.example.szablon.ui.theme.Blue500
import com.example.szablon.ui.theme.Blue900
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text

@Composable
fun Screen3(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    counter: Int
) {
Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
) {
    Text(text = "To jest ekran 3", fontWeight = FontWeight.Bold , fontSize = 48.sp)
    Text(text = "Wartość:$counter")
    Spacer(modifier = Modifier.height(64.dp))
    ElevatedButton(
        onClick = {
            sharedViewModel.incrementCounter()
            val counterValue = sharedViewModel.counter
            navController.navigate("screen2/$counterValue")
        },
        modifier = Modifier,
        enabled = true,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = Blue900,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.onTertiaryContainer
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = "Navigate to Screen 2")
    }

}
}

@Preview
@Composable
fun PreviewScreen3(){
    MaterialTheme {
        Surface {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Naviaget to screen 1")
            }
        }

    }
}