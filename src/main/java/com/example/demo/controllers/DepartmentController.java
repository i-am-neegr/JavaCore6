package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/department")
@RestController
public class DepartmentController {
    @Autowired
    final private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployees(@PathVariable int id) {
        return departmentService.getEmployees(id);
    }

    @GetMapping("/{id}/salary/sum")
    public int getSalarySum(@PathVariable int id) {
        return departmentService.totalSalary(id);
    }

    @GetMapping("/{id}/salary/max")
    public int getMaxSalary(@PathVariable int id) {
        return departmentService.maxSalary(id).getSalary();
    }

    @GetMapping("/{id}/salary/min")
    public int getMinSalary(@PathVariable int id) {
        return departmentService.minSalary(id).getSalary();
    }

    @GetMapping("employees")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getEmployees();
    }

    
}


