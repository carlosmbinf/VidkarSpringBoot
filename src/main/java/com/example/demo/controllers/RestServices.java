package com.example.demo.controllers;

import com.example.demo.entitys.User;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestServices {
    @Autowired
    UsersRepository groceryItemRepo;

    @RequestMapping("/rest")
    public List<User> buscarTodos() {
//        System.out.println(groceryItemRepo.findItemByName("Whole Wheat "));
        return groceryItemRepo.findAll();

    }
}