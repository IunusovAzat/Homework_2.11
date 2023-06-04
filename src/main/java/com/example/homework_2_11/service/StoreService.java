package com.example.homework_2_11.service;

import com.example.homework_2_11.component.Basket;
import com.example.homework_2_11.model.Item;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StoreService {

    private final Basket basket;
    private Map<Integer,Item> items;



    public StoreService(Basket basket) {
        this.basket = basket;
    }

    @PostConstruct
    public void init() {
        items = Map.of(
                1,new Item(1,"телефон",15000),
                2,new Item(2,"смартфон",35000),
                3,new Item(3,"чехол",1500)
        );
    }

    public void add(List<Integer> ids) {
        basket.add(
                ids.stream()
                        .map(items::get)
                        .collect(Collectors.toList())
        );
    }


    public Collection<Item> get() {
        return basket.get();
    }
}