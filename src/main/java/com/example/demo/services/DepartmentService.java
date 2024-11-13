package com.example.demo.services;

import com.example.demo.models.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentService implements DepartmentServiceInterface {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private Stream<Employee> employeesStream(int departmentID) {
        return employeeService.getEmployees().stream().filter(e -> e.getDepartmentID() == departmentID);
    }

    @Override
    public Employee maxSalary(int departmentID) {
        return employeesStream(departmentID)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Employee minSalary(int departmentID) {
        return employeesStream(departmentID)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Map<Integer, List<Employee>> getEmployees() {


        return employeeService.getEmployees().stream().
                collect(Collectors.groupingBy(Employee::getDepartmentID));
    }

    @Override
    public List<Employee> getEmployees(int departmentID) {
        return employeesStream(departmentID).toList();
    }
}
