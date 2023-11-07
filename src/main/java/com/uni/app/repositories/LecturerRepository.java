package com.uni.app.repositories;

import com.uni.app.models.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
  @Query(value = "SELECT l FROM Lecturer l WHERE CONCAT(l.name, ' ', l.surname) LIKE %:template%")
  List<Lecturer> findNameSurnameCoincidesTemplate(@Param("template") String template);
}
