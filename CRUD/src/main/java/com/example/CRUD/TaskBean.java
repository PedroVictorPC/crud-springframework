package com.example.CRUD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/*
 * Classe controller da entidade Task
 * 
 * @author Pedro Víctor
 */
@Component
@SessionScope
public class TaskBean {
	
	@Autowired
	private TaskService taskService;
	
	/*
	 * Variável da nova Task que será adicionado
	 */
	private Task curTask;
	
	/*
	 * Variável da lista das tasks a serem exibidas
	 */
	private List<Task> taskList;
	
	/*
	 * Variável que informa o filtro de exibição da lista
	 */
	private String statusDisplay;
	
	/*
	 * Construtor da classe
	 */
	public TaskBean() {
		init(); 
	}
	
	/*
	 * Metódo de inicialização da classe
	 */
	@PostConstruct
	private void init() {
		curTask = new Task();
		taskList = new ArrayList<Task>();
		setStatusDisplay("all");
		if (taskService != null) {
			taskList = taskService.getTaskList(statusDisplay);
		}
	}
	
	/*
	 * Método para salvar uma nova Task
	 */
	public String save() throws IOException {
		if (curTask.getName() != null && !curTask.getName().isEmpty()) {
			if (!taskService.hasTask(curTask.getName())) {
				curTask.setCompleted(false);
				taskService.save(curTask);
				updateList();
			}
			else {
				PrimeFaces.current().executeScript("PF('dlg').show();");
			}
		}
		curTask = new Task();
		return null;
	}
	
	/*
	 * Método para apagar uma Task
	 */
	public String delete(Task t) throws IOException {
		taskService.delete(t);
		updateList();
		return null;
	}
	
	/*
	 * Método para atualizar o estado de uma Task
	 */
	public String setTaskStatus(Task t, boolean completed) throws IOException {
		t.setCompleted(completed);
		taskService.save(t);
		updateList();
		return null;
	}
	
	/*
	 * Método para atualizar a lista de exibição
	 */
	public void updateList() throws IOException {
		taskList = taskService.getTaskList(statusDisplay);
	}
	
	/*
	 * Método que atua como Listener para a mudança de valor no menu de seleção do filtro de exibição
	 */
	public void changeList(ValueChangeEvent e) throws IOException {
		String s = (String) e.getNewValue();
		setStatusDisplay(s);
		updateList();
	}

	public Task getCurTask() {
		return curTask;
	}

	public void setCurTask(Task curTask) {
		this.curTask = curTask;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTasks(List<Task> taskList) {
		this.taskList = taskList;
	}

	public String getStatusDisplay() {
		return statusDisplay;
	}

	public void setStatusDisplay(String statusDisplay) {
		this.statusDisplay = statusDisplay;
	}
	
}
