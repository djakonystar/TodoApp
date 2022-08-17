package dev.djakonystar.todoapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.djakonystar.todoapp.domain.TodoItem
import dev.djakonystar.todoapp.domain.TodoListRepository

object TodoListRepositoryImpl: TodoListRepository {

    private val todoListLiveData = MutableLiveData<List<TodoItem>>()
    private val todoList = mutableListOf<TodoItem>()
    private var autoIncrementId = 0

    override fun getTodoList(): LiveData<List<TodoItem>> = todoListLiveData

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
        updateList()
    }

    override fun editTodoItem(todoItem: TodoItem) {
        val oldElement = getTodoItem(todoItem.id)
        todoList.remove(oldElement)
        addTodoItem(todoItem)
    }

    override fun deleteTodoItem(todoItem: TodoItem) {
        todoList.remove(todoItem)
        updateList()
    }

    private fun updateList() {
        todoListLiveData.value = todoList.toList()
    }
}
