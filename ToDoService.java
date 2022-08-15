package com.ashley.springboot.webApp.toDo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	private static List <ToDo> toDos= new ArrayList<ToDo>();
	
	private static  int countTodo=0;
	static {
		toDos.add(new ToDo(++countTodo,"hello",LocalDate.now().plusYears(1),false));
		toDos.add(new ToDo(++countTodo,"how ",LocalDate.now().plusYears(1),false));
		toDos.add(new ToDo(++countTodo,"are",LocalDate.now().plusYears(1),false));
		
	}
	public List<ToDo> findByUserName(String username){
		return toDos;
	}

	public void addTodo(String username, String description,LocalDate targetDate, boolean istrue ) {
		
		ToDo todo =new ToDo(++ countTodo,  description,  targetDate,  istrue );
		toDos.add(todo);
	}
	public void delete(int id) {
		Predicate<? super ToDo> Predicate= todo->todo.getId()==id;
		toDos.removeIf(Predicate);
	}

	public ToDo findById(int id) {
		Predicate<? super ToDo> Predicate= todo->todo.getId()==id;
		ToDo todo = toDos.stream().filter(Predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(ToDo todo) {
		delete(todo.getId());
		toDos.add(todo);
	}


}
