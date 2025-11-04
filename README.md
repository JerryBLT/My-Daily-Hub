# My-Daily-Hub
CS501 (Asgn5-Q2)
---
## My Daily Hub
A modern Android app built with **Jetpack Compose** and **Material 3**, designed to help users manage their daily life in one place.  
The app features **three functional screens** accessible via **Bottom Navigation**:

1. **Notes** – Create and view text notes  
2. **Tasks** – Manage a list of checkable to-do items  
3. **Calendar** – View a placeholder screen (for future scheduling features)

Each screen maintains its state through a shared **ViewModel**, ensuring that user data (like notes or tasks) persists across recompositions and navigation changes.

---

## AI Documentation
- **AI Usagage**: Improve Material 3 layout consistency and card styling, help with implementing Nav
- **Corrections**: AI suggested using multiple ViewModels for each screen, I used one for simplecity used. From the styling I had to fix the important and icnlude the most recent (not deprecated code). Also included `implementation("androidx.navigation:navigation-compose:2.9.5")
    implementation("androidx.compose.material:material-icons-extended:1.7.8")` 
