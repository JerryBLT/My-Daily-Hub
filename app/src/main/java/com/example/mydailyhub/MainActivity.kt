package com.example.mydailyhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mydailyhub.ui.theme.MyDailyHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyDailyHubTheme {
                MyDailyHubApp()
            }
        }
    }
}

/**
 * MyDailyHubApp:
 * Hosts the navigation graph and ViewModel.
 * Displays three screens (Notes, Tasks, Calendar) using BottomNavigation.
 */
@Composable
fun MyDailyHubApp(vm: HubViewModel = viewModel()) {
    val nav = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { HubBottomBar(nav) },
        containerColor = MaterialTheme.colorScheme.background
    ) { pad ->
        // Navigation graph defining all destinations in the app
        NavHost(
            navController = nav,
            startDestination = HubRoutes.Notes.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
        ) {
            // Define each composable route
            composable(HubRoutes.Notes.route) { NotesScreen(vm) }
            composable(HubRoutes.Tasks.route) { TasksScreen(vm) }
            composable(HubRoutes.Calendar.route) { CalendarScreen() }
        }
    }
}
