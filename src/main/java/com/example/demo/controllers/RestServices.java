package com.example.demo.controllers;


import com.example.demo.entitys.User;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RestServices {
    @Autowired
    ItemRepository groceryItemRepo;

    @RequestMapping("/rest")
    public List<User> buscarTodos() {
//        System.out.println(groceryItemRepo.findItemByName("Whole Wheat "));
        return groceryItemRepo.findAll();

    }
}