package com.example.CRUD;

import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Classe que representa a entidade Task
 * 
 * @author Pedro Víctor
 */
@Entity
@Table(name="tasks", schema="public")
public class Task {
	
	/*
	 * Variável para o identificador da Task
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/*
	 * Variável para o nome da Task
	 */
	@Column(name="taskname")
	private String name;
	
	/*
	 * Váriavel que indica se a Task está ou não finalizada
	 */
	@Column(name="completed")
	private boolean completed;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}
