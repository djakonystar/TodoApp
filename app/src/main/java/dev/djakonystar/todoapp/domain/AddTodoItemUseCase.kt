package dev.djakonystar.todoapp.domain

class AddTodoItemUseCase(private val todoListRepository: TodoListRepository) {
    fun addTodoItem(todoItem: TodoItem) {
        todoListRepository.addTodoItem(todoItem)
    }
}
