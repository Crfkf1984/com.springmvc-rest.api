package org.example.dao;

import org.example.entity.Todo;

import java.util.List;

public interface DaoTodo {
    List<Todo> getListTodo();

    void save(Todo todo);

    Todo getTodo(int id);

    void remove(int id);
}
