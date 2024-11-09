package com.example.demo.controllers;

import com.example.demo.exceptions.EmployeeAlreadyAddedException;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.exceptions.EmployeeStorageIsFullException;
import com.example.demo.models.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam(value = "firstName") String firstName,
                                @RequestParam(value = "lastName") String lastName)
            throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        employeeService.add(firstName, lastName);
        return employeeService.getEmployee(firstName, lastName);
    }


    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam(value = "firstName") String firstName,
                                   @RequestParam(value = "lastName") String lastName)
            throws EmployeeNotFoundException {
        Employee employee = employeeService.getEmployee(firstName, lastName);
        employeeService.delete(firstName, lastName);
        return employee;
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam(value = "firstName") String firstName,
                                 @RequestParam(value = "lastName") String lastName)
            throws EmployeeNotFoundException {
        return employeeService.getEmployee(firstName, lastName);
    }

    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    public ResponseEntity<String> handleEmployeeAlreadyAddedException(EmployeeAlreadyAddedException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(EmployeeStorageIsFullException.class)
    public ResponseEntity<String> handleEmployeeStorageIsFullException(EmployeeStorageIsFullException e) {
        return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(e.getMessage());
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}

