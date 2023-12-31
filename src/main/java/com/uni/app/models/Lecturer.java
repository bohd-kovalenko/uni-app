package com.uni.app.models;

import com.uni.app.models.enums.Degree;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "lecturers")
@AllArgsConstructor
@NoArgsConstructor
public class Lecturer {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecturers_seq")
  @SequenceGenerator(name = "lecturers_seq", sequenceName = "LECTURERS_SEQUENCE_PK", initialValue = 1, allocationSize = 20)
  @Column(name = "id", nullable = false, unique = true, updatable = false)
  private int id;
  @ManyToMany(fetch = FetchType.EAGER)
  @Fetch(FetchMode.JOIN)
  @JoinTable(name = "departments_lecturers", inverseJoinColumns = {@JoinColumn(name = "department_id", nullable = false)}, joinColumns = {@JoinColumn(name = "lecturer_id", nullable = false)})
  private List<Department> departments;
  @Enumerated(EnumType.STRING)
  @Column(name = "degree")
  private Degree degree;
  @Column(name = "name")
  private String name;
  @Column(name = "surname")
  private String surname;
  @Column(name = "salary")
  private double salary;
}
