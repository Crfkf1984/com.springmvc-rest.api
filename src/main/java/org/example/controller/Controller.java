package org.example.controller;

import org.example.entity.Todo;
import org.example.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private Service service;
    @GetMapping("/todos")
    public List<Todo> todosList() {
        List<Todo> todoList = service.getListTodo();
        return todoList;
    }

//    @GetMapping("api/todos/{id}")
//    public Todo todos() {
//        Todo todoList = service.getTodo(@RestParam("id") int id);
//        return todos;
//    }
}
