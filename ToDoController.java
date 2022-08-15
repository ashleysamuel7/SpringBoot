package com.ashley.springboot.webApp.toDo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class ToDoController {
	
	private ToDoService toDoService;
	
	
	
	public ToDoController(ToDoService toDoService) {
		super();
		this.toDoService = toDoService;
	}


	@RequestMapping("listTo")
	public String listAllToDo(ModelMap model){
		List<ToDo> toDos = toDoService.findByUserName("asp");
		model.addAttribute("toDo", toDos);	
		return "listToDo";
	}
	
	@RequestMapping(value="addTodo",method=RequestMethod.GET)
	public String addTodo(ModelMap model){
		ToDo todo = new ToDo(0, "Default Desc", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "addTodo";
	}
	@RequestMapping(value="addTodo",method=RequestMethod.POST)
	public String addTo(@Valid ToDo toDo,ModelMap model){
		toDoService.addTodo((String) model.get("name"),toDo.getDescription(), LocalDate.now().plusYears(1), false);
		return "redirect:listTo";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id){
		toDoService.delete(id);
		return "redirect:listTo";
	}
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id,ModelMap model){
		ToDo todo=toDoService.findById(id);
		model.addAttribute("todo",todo);	
		return "addTodo";
	}
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updateTodo(@RequestParam int id,ToDo todo,ModelMap model){
		toDoService.updateTodo(todo);
		return "redirect:listTo";
	}
	

}
