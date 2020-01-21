package com.example.CRUD;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/*
 * Classe DAO para acessar as Tasks
 * 
 * @author Pedro Víctor
 */
@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
	
	/*
	 * Método para buscar uma Task pelo nome
	 */
	@Query(value="SELECT * FROM tasks t WHERE t.taskname = :name", nativeQuery=true)
	List<Task> findByName(@Param("name") String name);
	
	/*
	 * Método para buscar as Tasks finalizadas ou as não finalizadas
	 */
	@Query(value="SELECT * FROM tasks t WHERE t.completed = :completed", nativeQuery=true)
	List<Task> findByStatus(@Param("completed") boolean completed);

}
