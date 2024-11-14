package com.example.demo.services;

import com.example.demo.models.Employee;
import org.springframework.http.ResponseEntity;

public interface BaseServiceInterface {
    ResponseEntity<Object> add(String firstName, String lastName);
    void delete(String firstName, String lastName);
    Employee getEmployee(String firstName, String lastName);
}
