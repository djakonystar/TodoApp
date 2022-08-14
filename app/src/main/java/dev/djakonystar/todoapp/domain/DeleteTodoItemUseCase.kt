package dev.djakonystar.todoapp.domain

class DeleteTodoItemUseCase(private val todoListRepository: TodoListRepository) {
    fun deleteTodoItem(todoItem: TodoItem) {
        todoListRepository.deleteTodoItem(todoItem)
    }
}
