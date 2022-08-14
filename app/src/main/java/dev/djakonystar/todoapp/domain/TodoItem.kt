package dev.djakonystar.todoapp.domain

data class TodoItem(
    val id: Int,
    val name: String,
    val enabled: Boolean
)
