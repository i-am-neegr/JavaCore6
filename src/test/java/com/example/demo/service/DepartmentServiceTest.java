package com.example.demo.service;

import com.example.demo.models.Employee;
import com.example.demo.services.DepartmentService;
import com.example.demo.services.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentService departmentService;

    private final List<Employee> employees = Arrays.asList(
            new Employee("John", "Lennon", 10_000, 1),
            new Employee("Paul", "McCartney", 10_000, 1),
            new Employee("Mick", "Gordon", 100_000, 2)
    );

    @BeforeEach
    public void setUp() {
        when(employeeService.getEmployees()).thenReturn(employees);
    }

    @Test
    public void getEmployees() {
        List<Employee> department1Employees = departmentService.getEmployees(1);
        Assertions.assertEquals(department1Employees.size(), 2);
        Assertions.assertEquals(department1Employees.get(0).getFullName(), employees.get(0).getFullName());

        List<Employee> department2Employees = departmentService.getEmployees(2);
        Assertions.assertEquals(department2Employees.size(), 1);
        Assertions.assertEquals(department2Employees.get(0).getFullName(), employees.get(2).getFullName());

        List<Employee> department3Employees = departmentService.getEmployees(3);
        Assertions.assertTrue(department3Employees.isEmpty());
    }

    @Test
    public void maxSalaryTest() {
        Employee maxSalaryFirstDepartment = departmentService.maxSalary(1);
        Assertions.assertNotNull(maxSalaryFirstDepartment);
        Assertions.assertEquals(maxSalaryFirstDepartment.getFullName(), employees.get(0).getFullName());

        Employee maxSalarySecondDepartment = departmentService.maxSalary(2);
        Assertions.assertNotNull(maxSalarySecondDepartment);
        Assertions.assertEquals(maxSalarySecondDepartment.getFullName(), employees.get(2).getFullName());

        Assertions.assertThrows(RuntimeException.class, () -> departmentService.maxSalary(3));
    }

    @Test
    public void minSalaryTest() {
        Employee minSalaryFirstDepartment = departmentService.minSalary(1);
        Assertions.assertNotNull(minSalaryFirstDepartment);
        Assertions.assertEquals(minSalaryFirstDepartment.getFullName(), employees.get(0).getFullName());

        Employee minSalarySecondDepartment = departmentService.minSalary(2);
        Assertions.assertNotNull(minSalarySecondDepartment);
        Assertions.assertEquals(minSalarySecondDepartment.getFullName(), employees.get(2).getFullName());

        Assertions.assertThrows(RuntimeException.class, () -> departmentService.minSalary(3));
    }

    @Test
    public void getAllEmployees() {
        Assertions.assertEquals(2, departmentService.getEmployees().size());
    }

    @Test
    public void totalSalaryTest() {
        Assertions.assertEquals(departmentService.totalSalary(1), 20000);
        Assertions.assertEquals(departmentService.totalSalary(2), 100000);
    }




}
