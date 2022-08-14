package dev.djakonystar.todoapp.domain

class GetTodoListUseCase(private val todoListRepository: TodoListRepository) {
    fun getTodoList(): List<TodoItem> {
        return todoListRepository.getTodoList()
    }
}
