package com.example.demo.controller;

import com.example.demo.service.ShoppingCartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class ShoppingCartController {
    ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/add")
    public List<Integer> add(@RequestParam List<Integer> items) {
        shoppingCartService.addItem(items);
        return items;
    }

    @GetMapping("/get")
    public Set<Integer> get() {
        return shoppingCartService.getShoppingCart();
    }
}
