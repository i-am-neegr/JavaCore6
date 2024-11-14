package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.services.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaseController {
    BaseService baseService;

    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/add")
    public ResponseEntity<Object> add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return baseService.add(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return baseService.getEmployee(firstName, lastName);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        baseService.delete(firstName, lastName);
    }

}
