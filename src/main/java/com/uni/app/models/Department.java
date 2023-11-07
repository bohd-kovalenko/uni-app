package com.uni.app.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departmentSequence")
  @SequenceGenerator(name = "departmentSequence", sequenceName = "DEPARTMENT_SEQUENCE_PK", initialValue = 1, allocationSize = 20)
  @Column(name = "id", unique = true, updatable = false, nullable = false)
  private int id;
  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "departments")
  @Fetch(FetchMode.SUBSELECT)
  private List<Lecturer> lecturers;
  @Column(name = "name", unique = true, nullable = false)
  private String name;
  @ManyToOne(fetch = FetchType.LAZY)
  @Fetch(FetchMode.SELECT)
  @JoinColumn(name = "head_lecturer_id")
  private Lecturer headLecturer;
}
