package com.example.mydailyhub

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

/**
 * HubBottomBar:
 * Bottom navigation bar that allows switching between Notes, Tasks, and Calendar screens.
 * Uses currentBackStackEntryAsState() to highlight the active tab.
 */

@Composable
fun HubBottomBar(nav: NavHostController) {
    val items = listOf(HubRoutes.Notes, HubRoutes.Tasks, HubRoutes.Calendar)
    val current by nav.currentBackStackEntryAsState()
    val route = current?.destination?.route

    NavigationBar {
        items.forEach {
            // Assign icons to each screen
            val icon = when (it) {
                HubRoutes.Notes -> Icons.Default.Edit
                HubRoutes.Tasks -> Icons.Default.CheckBox
                HubRoutes.Calendar -> Icons.Default.CalendarToday
            }
            // Create each navigation item
            NavigationBarItem(
                selected = route == it.route,
                onClick = {
                    nav.navigate(it.route) {
                        // Control backstack and state restoration
                        popUpTo(nav.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(icon, contentDescription = it.route) },
                label = { Text(it.route.replaceFirstChar { c -> c.uppercase() }) }
            )
        }
    }
}
