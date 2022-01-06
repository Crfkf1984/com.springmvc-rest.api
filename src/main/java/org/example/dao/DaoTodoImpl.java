package org.example.dao;

import org.example.entity.Todo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoTodoImpl implements DaoTodo{
    private SessionFactory sessionFactory;

    @Autowired
    public DaoTodoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Todo> getListTodo() {
        Session session = sessionFactory.getCurrentSession();
        List<Todo> todoList = session.createQuery("from Todo", Todo.class).getResultList();
        return todoList;
    }

    @Override
    public void save(Todo todo) {

    }

    @Override
    public Todo getTodo(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }
}
