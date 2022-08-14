package dev.djakonystar.todoapp.domain

class GetTodoItemUseCase(private val todoListRepository: TodoListRepository) {
    fun getTodoItem(id: Int): TodoItem {
        return todoListRepository.getTodoItem(id)
    }
}
