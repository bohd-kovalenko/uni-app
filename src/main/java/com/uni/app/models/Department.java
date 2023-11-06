package com.uni.app.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "departments")
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departmentSequence")
  @SequenceGenerator(name = "departmentSequence", sequenceName = "DEPARTMENT_SEQUENCE_PK", initialValue = 1, allocationSize = 20)
  @Column(name = "id", unique = true, updatable = false, nullable = false)
  private Integer id;
  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "departments")
  @Fetch(FetchMode.SUBSELECT)
  private List<Lecturer> lecturers;
  @Column(name = "name")
  private String name;
}
