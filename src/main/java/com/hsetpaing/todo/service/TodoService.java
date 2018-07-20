package com.hsetpaing.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hsetpaing.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;
	
	static {
		todos.add(new Todo(1, "hsetpaing", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "hsetpaing", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "hsetpaing", "Learn Spring Boot", new Date(), false));
	}
	
	public List<Todo> retrieveTodos(String user){
		List<Todo> filteredTodo = new ArrayList<Todo>();
		for(Todo todo : todos) {
			if (todo.getUser().equals(user)) {
				filteredTodo.add(todo);
			}
		}
		return filteredTodo;
	}
	
	public Todo retrieveTodo(int id) {
		for(Todo todo : todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	public void updateTodo(Todo todo) {
		todos.remove(todo);
		todos.add(todo);
	}
	
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}
	
	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}
}
