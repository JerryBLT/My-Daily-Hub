package com.example.mydailyhub

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

/**
 * HubViewModel:
 * Centralized state holder for Notes and Tasks.
 * ViewModel ensures that data persists across configuration changes and recompositions.
 */
class HubViewModel : ViewModel() {
    // --- Notes ---
    private val _notes = mutableStateListOf("Finish CS501 HW", "Finish CS411 HW", "Finish BB522 HW")
    val notes: List<String> get() = _notes

    /**
     * Adds a new note to the list if not blank.
     */
    fun addNote(text: String) {
        if (text.isNotBlank()) _notes.add(0, text.trim())
    }

    // --- Tasks ---
    var tasks = mutableStateListOf(
        "Laundry" to false,
        "Groceries" to false,
        "Pay bills" to false
    )

    /**
     * Toggles a task’s completion status (checked/unchecked).
     */
    fun toggleTask(index: Int) {
        val (text, done) = tasks[index]
        tasks[index] = text to !done
    }

    /**
     * Adds a new task if not blank.
     */
    fun addTask(task: String) {
        if (task.isNotBlank()) tasks.add(task to false)
    }
}

