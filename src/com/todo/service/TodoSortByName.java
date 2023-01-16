package com.todo.service;

import com.todo.dao.TodoItem;

import java.util.Comparator;

public class TodoSortByName implements Comparator<TodoItem> {
    @Override
    public int compare(TodoItem o1, TodoItem o2) {
        return o1.getCurrent_date().compareTo(o2.getCurrent_date());
    }
}
