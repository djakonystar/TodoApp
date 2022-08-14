package dev.djakonystar.todoapp.domain

class EditTodoItemUseCase(private val todoListRepository: TodoListRepository) {
    fun editTodoItem(todoItem: TodoItem) {
        todoListRepository.editTodoItem(todoItem)
    }
}
