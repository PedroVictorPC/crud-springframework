package com.example.CRUD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * Classe Service para a entidade Task
 * 
 * @author Pedro Víctor
 */
@Service
@Transactional
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	/*
	 * Método responsável por salvar ou atualizar uma Task
	 */
	public void save(Task t) {
		taskRepository.save(t);
	}
	
	/*
	 * Método que retorna a lista de Tasks dependendo do filtro de exibição
	 */
	public List<Task> getTaskList(String displayFilter) {
		if (displayFilter.equals("all")) {
			return taskRepository.findAll();
		}
		else {
			return taskRepository.findByStatus(displayFilter.equals("completed"));
		}
	}
	
	/*
	 * Método para verificar se já existe uma Task com um dado nome
	 */
	public boolean hasTask(String taskName) {
		return taskRepository.findByName(taskName).size() >= 1;
	}
	
	/*
	 * Método para apagar uma Task
	 */
	public void delete(Task t) {
		taskRepository.delete(t);
	}
	
}
 