package dev.djakonystar.todoapp.domain

import androidx.lifecycle.LiveData

interface TodoListRepository {

    fun getTodoList(): LiveData<List<TodoItem>>

    fun getTodoItem(id: Int): TodoItem

    fun addTodoItem(todoItem: TodoItem)

    fun editTodoItem(todoItem: TodoItem)

    fun deleteTodoItem(todoItem: TodoItem)
}
