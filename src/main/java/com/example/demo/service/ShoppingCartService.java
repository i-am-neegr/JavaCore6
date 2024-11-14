package com.example.demo.service;

import com.example.demo.models.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ShoppingCartService implements ShoppingCartServiceInterface {
    private final ShoppingCart items;

    public ShoppingCartService(ShoppingCart shoppingCart) {
        items = shoppingCart;
    }

    @Override
    public void addItem(List<Integer> itemName) {
        items.addItem(itemName);
    }

    @Override
    public Set<Integer> getShoppingCart() {
        return items.getItems();
    }
}
