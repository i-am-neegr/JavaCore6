package com.example.demo.services;

import com.example.demo.models.Employee;

public interface EmployeeServiceInterface {
    void add(String firstName, String lastName);
    void delete(String firstName, String lastName);
    Employee getEmployee(String firstName, String lastName);
}
