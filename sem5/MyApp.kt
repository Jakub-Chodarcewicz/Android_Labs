package com.example.szablon


import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.szablon.ui.theme.SzablonTheme


class SharedViewModel : ViewModel() {
    var counter by mutableStateOf(0)
        private set

    fun incrementCounter() {
        counter++
    }
}

class SensorViewModel(applicationContext: Context) : ViewModel(), SensorEventListener {
    private val sensorManager =
        applicationContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    var X by mutableStateOf(0f)
    var Y by mutableStateOf(0f)
    var Z by mutableStateOf(0f)

    var lightLevel by mutableStateOf(0f)
        private set

    init {
        val accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL)

        val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            X = event.values[0]
            Y = event.values[1]
            Z = event.values[2]
        } else if (event.sensor.type == Sensor.TYPE_LIGHT) {
            lightLevel = event.values[0]
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Do nothing for now
    }

    override fun onCleared() {
        super.onCleared()
        sensorManager.unregisterListener(this)
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val applicationContext = LocalContext.current.applicationContext
    NavGraph(navController = navController, applicationContext = applicationContext)

}

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = "screen1",
    applicationContext: Context
) {
    val sharedViewModel: SharedViewModel = viewModel()
    val sensorViewModel: SensorViewModel = viewModel(factory = SensorViewModelFactory(applicationContext))

    NavHost(navController = navController, startDestination = startDestination) {
        addScreens(navController, sharedViewModel, sensorViewModel)
    }
}

@Composable
fun MyAppContent() {
    SzablonTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MyApp()
        }
    }
}

private fun NavGraphBuilder.addScreens(
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
    sensorViewModel: SensorViewModel) {
    composable("screen1") {
        Screen1(navController = navController, sharedViewModel = sharedViewModel, sensorViewModel = sensorViewModel)
    }
    composable(
        "screen2",

    ) {
        Screen2(
            navController = navController,
            x = sensorViewModel.X,
            y = sensorViewModel.Y,
            z = sensorViewModel.Z,
            sensorViewModel = sensorViewModel
        )
    }
    composable(
        "screen3",
    ) {
        Screen3(
            navController = navController,
            lightLevel = sensorViewModel.lightLevel
        )
    }
    // Add more screens as needed
}