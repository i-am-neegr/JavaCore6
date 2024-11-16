package com.example.demo.services;

import com.example.demo.models.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentServiceInterface {
    Employee maxSalary(int departmentID);
    Employee minSalary(int departmentID);
    Map<Integer, List<Employee>> getEmployees();
    List<Employee> getEmployees(int departmentID);
}
