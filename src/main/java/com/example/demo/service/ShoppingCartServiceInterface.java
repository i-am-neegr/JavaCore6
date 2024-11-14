package com.example.demo.service;

import java.util.List;
import java.util.Set;

public interface ShoppingCartServiceInterface {
    void addItem(List<Integer> itemName);
    Set<Integer> getShoppingCart();
}
