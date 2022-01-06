package org.example.service;

import org.example.dao.DaoTodo;
import org.example.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{
    private DaoTodo daoTodo;

    @Autowired
    public ServiceImpl(DaoTodo daoTodo) {
        this.daoTodo = daoTodo;
    }

    @Override
    @Transactional
    public List<Todo> getListTodo() {
        return daoTodo.getListTodo();
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
