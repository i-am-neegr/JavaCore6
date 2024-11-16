package com.example.demo.service;

import com.example.demo.exceptions.EmployeeAlreadyAddedException;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.exceptions.EmployeeStorageIsFullException;
import com.example.demo.models.Employee;
import com.example.demo.services.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeServiceTest {
    EmployeeService employeeService = new EmployeeService();

    @Test
    public void testAddEmployee() {
        int employeesCounter = employeeService.getEmployees().size();
        employeeService.add("Alain", "Delon");
        assert ++employeesCounter == employeeService.getEmployees().size();

        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add("Alain", "Delon"));
        assert employeesCounter == employeeService.getEmployees().size();

        employeeService.add("Ian", "Curtis");
        employeeService.add("James", "Hendrix");
        employeeService.add("Doyle", "Wolfgang von Frankenstein");
        employeeService.add("Igor", "Letov");
        Assertions.assertThrows(EmployeeStorageIsFullException.class, () -> employeeService.add("Mikhail", "Gorsheniov"));
    }

    @Test
    public void testRemoveEmployee() {
        int employeesCounter = employeeService.getEmployees().size();
        employeeService.delete("Alain", "Delon");
        assert employeesCounter - 1 == employeeService.getEmployees().size();

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.delete("Alain", "Delon"));
    }

    @Test
    public void testGetEmployee() {
        assert employeeService.getEmployee("James", "Hendrix").equals(new Employee("James", "Hendrix", 10_000, 1));

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.getEmployee("vova", "pupkin"));

    }
}
