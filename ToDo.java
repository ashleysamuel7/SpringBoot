package com.ashley.springboot.webApp.toDo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ToDo {
	private int id;

	private String description;
	private LocalDate target;
	private boolean done;

	public ToDo(int id, String description, LocalDate target, boolean done) {
		super();
		this.id = id;
		this.description = description;
		this.target = target;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTarget() {
		return target;
	}

	public void setTarget(LocalDate target) {
		this.target = target;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", description=" + description + ", target=" + target + ", done=" + done + "]";
	}

}
