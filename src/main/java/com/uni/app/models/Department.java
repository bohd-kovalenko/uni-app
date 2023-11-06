package com.uni.app.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Department {
  private Integer id;
  private List<Lecturer> lecturers;
  private String name;
}
