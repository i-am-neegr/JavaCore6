package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/departments")
@RestController
public class DepartmentController {
    @Autowired
    final private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("max-salary")
    public Employee maxSalary(@RequestParam(value = "departmentId") int departmentID) {
        return departmentService.maxSalary(departmentID);
    }

    @GetMapping("min-salary")
    public Employee minSalary(@RequestParam(value = "departmentId") int departmentID) {
        return departmentService.minSalary(departmentID);
    }

    @GetMapping("all")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getEmployees();
    }

    @GetMapping("all")
    public List<Employee> getAllEmployees(@RequestParam(value = "departmentId") int departmentId) {
        return departmentService.getEmployees(departmentId);
    }
}


