package com.uni.app.controllers.console;

import com.uni.app.dto.DepartmentStatDto;
import com.uni.app.models.Department;
import com.uni.app.models.Lecturer;
import com.uni.app.services.DepartmentService;
import com.uni.app.services.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@RequiredArgsConstructor
@ShellComponent
public class DepartmentShellHandler {
  private static final String INFORMATION_ABOUT_TURNED_OFF_SHELL = "Your shell interaction is in disabled state, to enable it enter: Enable S/I ";
  private final DepartmentService departmentService;
  private final LecturerService lecturerService;
  private boolean enable = false;


  @ShellMethod(key = "Enable S/I")
  public void handleEnableCommand() {
    if (!enable) {
      enable = true;
      System.out.println("You successfully enabled shell interaction!");
    } else System.out.println("Your shell interaction is already turned in");
  }

  @ShellMethod(key = "Disable S/I")
  public void handleDisableCommand() {
    if (enable) {
      enable = false;
      System.out.println("You successfully disabled shell interaction!");
    } else System.out.println("Your shell interaction is already turned off.");
  }

  @ShellMethod(key = "Show count of employee for department ")
  public void handleCountDepartmentEmployeesCommand(String departmentName) {
    if (enable) {
      System.out.printf("%d employees found in department %s%n",
          departmentService.findEmployeesCountByDepartmentName(departmentName),
          departmentName);
    } else System.out.println(INFORMATION_ABOUT_TURNED_OFF_SHELL);
  }

  @ShellMethod(key = "Show the average salary for the department ")
  public void handleGetAverageDepartmentSalary(String departmentName) {
    if (enable) {
      System.out.printf("The average salary for the department %s is %f",
          departmentName,
          departmentService.findAverageSalaryByDepartmentName(departmentName));
    } else System.out.println(INFORMATION_ABOUT_TURNED_OFF_SHELL);
  }

  @ShellMethod(key = "Who is head of department ")
  public void handleGetDepartmentHead(String departmentName) {
    if (enable) {
      System.out.printf("The head of department %s is lecturer with the name %s%n",
          departmentName,
          departmentService.findHeadLecturerByDepartmentName(departmentName).getName());
    } else System.out.println(INFORMATION_ABOUT_TURNED_OFF_SHELL);
  }

  @ShellMethod(key = "Show statistics of department ")
  public void handleGetDepartmentStat(String departmentName) {
    if (enable) {
      DepartmentStatDto departmentStat = departmentService.findDepartmentStatByDepartmentName(departmentName);
      System.out.printf("Assistants: %d, associate professors: %d, professors: %d",
          departmentStat.assistantsCount(),
          departmentStat.associateProfessorsCount(),
          departmentStat.professorsCount());
    } else System.out.println(INFORMATION_ABOUT_TURNED_OFF_SHELL);
  }

  @ShellMethod(key = "Global search by ")
  public void handleGlobalSearchRequest(String template) {
    if (enable) {
      List<Lecturer> lecturers = lecturerService.findNameSurnameCoincidesTemplate(template);
      System.out.printf("Found %d lecturers: \n", lecturers.size());
      lecturers
          .forEach(lecturer -> System.out.println(lecturer.getName() + " " + lecturer.getSurname()));
      List<Department> departments = departmentService.findDepartmentsNameCoincidesTemplate(template);
      System.out.printf("Found %d departments: \n", departments.size());
      departments
          .forEach(department -> System.out.println(department.getName()));
    } else System.out.println(INFORMATION_ABOUT_TURNED_OFF_SHELL);
  }
}
