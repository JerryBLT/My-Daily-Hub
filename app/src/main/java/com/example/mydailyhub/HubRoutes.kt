package com.example.mydailyhub

/**
 * Sealed class defining all routes (destinations) for navigation.
 * Ensures type safety and avoids typos when navigating between screens.
 */
sealed class HubRoutes(val route: String) {
    object Notes : HubRoutes("notes")
    object Tasks : HubRoutes("tasks")
    object Calendar : HubRoutes("calendar")
}
