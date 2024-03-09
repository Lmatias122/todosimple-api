package com.leomatias.todosimple.repositories;

import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.leomatias.todosimple.models.task;


@Repository
public interface TaskRepository extends JpaRepository<task,Long> {
 
    
    
    List<task> findByUser_Id(Long Id);

   // @Query(value = "SELECT t FROM task t WHERE t.user.id = : id")
   // List<task> findByUser_Id(@Param("id") Long id);

  // @Query(value = "SELECT * FROM task t WHERE t.user_id = :id",nativeQuery =true)
  // List<task> findByUser_Id(Long Id);

}
