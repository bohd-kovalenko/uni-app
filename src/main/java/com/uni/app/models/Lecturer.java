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
@Table(name = "lecturers")
public class Lecturer {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecturers_seq")
  @SequenceGenerator(name = "lecturers_seq", sequenceName = "LECTURERS_SEQUENCE_PK", initialValue = 1, allocationSize = 20)
  @Column(name = "id", nullable = false, unique = true, updatable = false)
  private Integer id;
  @ManyToMany(fetch = FetchType.LAZY)
  @Fetch(FetchMode.SUBSELECT)
  @JoinTable(name = "departments_lecturers", joinColumns = {@JoinColumn(name = "department_id", nullable = false)}, inverseJoinColumns = {@JoinColumn(name = "lecturer_id", nullable = false)})
  private List<Department> departments;
  @Enumerated(EnumType.STRING)
  @Column(name = "degree")
  private Degree degree;
  @Column(name = "name")
  private String name;
}
