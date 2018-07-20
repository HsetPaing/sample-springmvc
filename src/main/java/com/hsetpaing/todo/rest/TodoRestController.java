package com.hsetpaing.todo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsetpaing.model.Todo;
import com.hsetpaing.todo.service.TodoService;

@RestController
public class TodoRestController {

	@Autowired
	private TodoService service;

	/*@RequestMapping(value = "/todo/", method = RequestMethod.GET)
	public List<Todo> listAllTodo() {
		List<Todo> user = service.retrieveTodos("hsetpaing");
		return user;
	}

	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
	public Todo retrieveTodo(@PathVariable("id") int id) {
		return service.retrieveTodo(id);
	}*/
}
