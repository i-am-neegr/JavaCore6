package com.example.demo.models;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SessionScope
@Service
public class ShoppingCart {
    private final Set<Integer> items = new HashSet<>(List.of());

    public void addItem(List<Integer> numbers) {
        items.addAll(numbers);
    }

    public Set<Integer> getItems() {
        return items;
    }
}
