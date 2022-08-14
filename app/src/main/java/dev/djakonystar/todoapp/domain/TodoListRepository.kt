package dev.djakonystar.todoapp.domain

interface TodoListRepository {

    fun getTodoList(): List<TodoItem>

    fun getTodoItem(id: Int): TodoItem

    fun addTodoItem(todoItem: TodoItem)

    fun editTodoItem(todoItem: TodoItem)

    fun deleteTodoItem(todoItem: TodoItem)
}
