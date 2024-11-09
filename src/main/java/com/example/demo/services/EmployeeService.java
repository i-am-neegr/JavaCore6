package com.example.demo.services;

import com.example.demo.exceptions.EmployeeAlreadyAddedException;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.exceptions.EmployeeStorageIsFullException;
import com.example.demo.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private final List<Employee> employeeList = new ArrayList<>();
    private final int maxEmployees = 5;

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public boolean validEmployee(Employee employee) {
        for (Employee emp : employeeList) {
            if (emp.equals(employee)) {
                return false;
            }
        }
        return true;
    }

    public int freePlaces() {
        return maxEmployees - employeeList.size();
    }

    public boolean isListFull() {
        return (freePlaces() == 0);
    }

    @Override
    public void add(String firstName, String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        if (isListFull()) {
            throw new EmployeeStorageIsFullException("Employee list is full");
        }

        Employee employee = new Employee(firstName, lastName);
        if (validEmployee(employee)) {
            employeeList.add(employee);
        } else {
            throw new EmployeeAlreadyAddedException("Employee already added");
        }
    }

    @Override
    public void delete(String firstName, String lastName) throws EmployeeNotFoundException {
        boolean found = false;
        for (Employee employee : employeeList) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                employeeList.remove(employee);
                found = true;
            }
        }
        if (!found) {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }

    @Override
    public Employee getEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = null;
        for (Employee emp : employeeList) {
            if (emp.getFirstName().equals(firstName) && emp.getLastName().equals(lastName)) {
                employee = emp;
            }
        }
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found");
        } else {
            return employee;
        }
    }
}
