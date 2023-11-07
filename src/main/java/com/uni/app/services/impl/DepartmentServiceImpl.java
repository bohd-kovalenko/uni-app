package com.uni.app.services.impl;

import com.uni.app.dto.DepartmentStatDto;
import com.uni.app.models.Department;
import com.uni.app.models.Lecturer;
import com.uni.app.models.enums.Degree;
import com.uni.app.repositories.DepartmentRepository;
import com.uni.app.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
  On real projects, those calculations should be performed on the side of database,
   because table could store the data, size of which overwhelm the RAM size an so
   it would cause errors. And usually such a calculations take more time on the side of app.
 */
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
  private final DepartmentRepository repository;

  @Override
  public Integer findEmployeesCountByDepartmentName(String departmentName) {
    return repository
        .findByName(departmentName)
        .getLecturers()
        .size();
  }

  @Override
  public Double findAverageSalaryByDepartmentName(String departmentName) {
    List<Lecturer> departmentEmployees = repository.findByName(departmentName).getLecturers();
    return (departmentEmployees
        .stream()
        .map(lecturer -> lecturer.getSalary())
        .reduce((salary, accum) -> accum += salary)
        .orElseThrow()) / departmentEmployees.size();
  }

  @Override
  public Lecturer findHeadLecturerByDepartmentName(String departmentName) {
    return repository
        .findByName(departmentName)
        .getHeadLecturer();
  }

  @Override
  public DepartmentStatDto findDepartmentStatByDepartmentName(String departmentName) {
    Map<Degree, Long> lecturersCounting = repository
        .findByName(departmentName)
        .getLecturers()
        .stream()
        .collect(Collectors.groupingBy(Lecturer::getDegree, Collectors.counting()));
    return new DepartmentStatDto(departmentName,
        lecturersCounting.containsKey(Degree.ASSISTANT) ? lecturersCounting.get(Degree.ASSISTANT).intValue() : 0,
        lecturersCounting.containsKey(Degree.ASSOCIATE_PROFESSOR) ? lecturersCounting.get(Degree.ASSOCIATE_PROFESSOR).intValue() : 0,
        lecturersCounting.containsKey(Degree.PROFESSOR) ? lecturersCounting.get(Degree.PROFESSOR).intValue() : 0);
  }

  @Override
  public List<Department> findDepartmentsNameCoincidesTemplate(String template) {
    return repository
        .findNameCoincides(template);
  }
}
