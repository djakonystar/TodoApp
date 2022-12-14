package dev.djakonystar.todoapp.domain

data class TodoItem(
    val name: String,
    var enabled: Boolean,
    var id: Int = UNDEFINED_ID
) {

    companion object {
        const val UNDEFINED_ID = -1
    }
}
