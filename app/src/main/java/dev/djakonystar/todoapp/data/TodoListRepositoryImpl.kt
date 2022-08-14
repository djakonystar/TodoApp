package dev.djakonystar.todoapp.data

import dev.djakonystar.todoapp.domain.TodoItem
import dev.djakonystar.todoapp.domain.TodoListRepository

object TodoListRepositoryImpl: TodoListRepository {

    private val todoList = mutableListOf<TodoItem>()
    private var autoIncrementId = 0

    override fun getTodoList(): List<TodoItem> {
        return todoList.toList()
    }

    override fun getTodoItem(id: Int): TodoItem {
        return todoList.find {
            it.id == id
        } ?: throw RuntimeException("Element with id $id not found!")
    }

    override fun addTodoItem(todoItem: TodoItem) {
        if (todoItem.id == TodoItem.UNDEFINED_ID) {
            todoItem.id = autoIncrementId++
        }
        todoList.add(todoItem)
    }

    override fun editTodoItem(todoItem: TodoItem) {
        val oldElement = getTodoItem(todoItem.id)
        todoList.remove(oldElement)
        addTodoItem(todoItem)
    }

    override fun deleteTodoItem(todoItem: TodoItem) {
        todoList.remove(todoItem)
    }
}
