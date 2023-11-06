package com.uni.app.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
public class Lecturer {
  private Integer id;
  private List<Department> departments;
  private Degree degree;
  private String name;
}
