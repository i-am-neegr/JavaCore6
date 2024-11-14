package com.example.demo.services;

import com.example.demo.models.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseService implements BaseServiceInterface{

    List<Employee> employees = new ArrayList<>();

    @Override
    public ResponseEntity<Object> add(String firstName, String lastName) {
        if (StringUtils.isAlpha(firstName + lastName)) {
            Employee employee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName));
            employees.add(employee);
            return null;
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public void delete(String firstName, String lastName) {
        employees.removeIf(employee -> employee.getFullName().equals(firstName + " " + lastName));
    }

    @Override
    public Employee getEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFullName().equals(firstName + " " + lastName)) {
                return employee;
            }
        }
        return null;
    }
}
