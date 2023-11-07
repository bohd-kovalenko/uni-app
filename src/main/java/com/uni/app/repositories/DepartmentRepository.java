package com.uni.app.repositories;

import com.uni.app.models.Department;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
  @EntityGraph(attributePaths = {"lecturers", "headLecturer"})
  @Query("SELECT d FROM Department d WHERE d.name=:name")
  Department findByName(@Param("name") String name);

  @EntityGraph(attributePaths = {"lecturers", "headLecturer"})
  @Query(value = "SELECT d FROM Department d WHERE d.name LIKE %:template%")
  List<Department> findNameCoincides(@Param("template") String template);
}
