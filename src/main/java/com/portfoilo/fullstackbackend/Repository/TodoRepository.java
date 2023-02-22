package com.portfoilo.fullstackbackend.Repository;

import com.portfoilo.fullstackbackend.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Query(value = "SELECT * FROM todos WHERE user_id = :id ORDER BY priority DESC" , nativeQuery = true)
    List<Todo> find(@Param("id") Integer id);

}
