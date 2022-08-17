package dev.djakonystar.todoapp.presentation

import androidx.lifecycle.ViewModel
import dev.djakonystar.todoapp.data.TodoListRepositoryImpl
import dev.djakonystar.todoapp.domain.DeleteTodoItemUseCase
import dev.djakonystar.todoapp.domain.EditTodoItemUseCase
import dev.djakonystar.todoapp.domain.GetTodoListUseCase
import dev.djakonystar.todoapp.domain.TodoItem

class MainViewModel: ViewModel() {

    private val repository = TodoListRepositoryImpl

    private val getTodoListUseCase = GetTodoListUseCase(repository)
    private val deleteTodoItemUseCase = DeleteTodoItemUseCase(repository)
    private val editTodoItemUseCase = EditTodoItemUseCase(repository)

    val todoList = getTodoListUseCase.getTodoList()

    fun deleteTodoItem(todoItem: TodoItem) {
        deleteTodoItemUseCase.deleteTodoItem(todoItem)
    }

    fun changeEnableState(todoItem: TodoItem) {
        val newItem = todoItem.copy(enabled = !todoItem.enabled)
        editTodoItemUseCase.editTodoItem(newItem)
    }
}
