package com.uni.app.services;

import com.uni.app.dto.DepartmentStatDto;
import com.uni.app.models.Department;
import com.uni.app.models.Lecturer;

import java.util.List;

public interface DepartmentService {
  Integer findEmployeesCountByDepartmentName(String departmentName);

  Double findAverageSalaryByDepartmentName(String departmentName);

  Lecturer findHeadLecturerByDepartmentName(String departmentName);

  DepartmentStatDto findDepartmentStatByDepartmentName(String departmentName);

  List<Department> findDepartmentsNameCoincidesTemplate(String template);
}
