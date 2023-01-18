package com.example.demo.controllers;


import com.example.demo.entitys.Profile;
import com.example.demo.entitys.User;
import com.example.demo.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class ControllerBasicAndMaps {

    @Autowired
     ItemRepository groceryItemRepo;

    //CREATE
    void createGroceryItems() {
        System.out.println("Data creation started...");
        groceryItemRepo.save(new User("097842877",new Profile("Carlos","Medina","admin")));
        groceryItemRepo.save(new User("097842877",new Profile("Carlos","Medina","admin")));
        groceryItemRepo.save(new User("097842877",new Profile("Carlos","Medina","admin")));
        groceryItemRepo.save(new User("097842877",new Profile("Carlos","Medina","admin")));
        System.out.println("Data creation complete...");
    }


    @GetMapping(path = {"/list", "all"})
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("inicio");
        modelAndView.addObject("users", groceryItemRepo.findAll());
        return modelAndView;
    }

    @GetMapping(path = {"/import"})
    public ModelAndView importar() {
        createGroceryItems();
//        ModelAndView modelAndView = new ModelAndView("inicio");
//        modelAndView.addObject("persons", groceryItemRepo.findAll());
        return null;
    }


//    public List<Person> getPersons() {
//        ArrayList<Person> listadoDePersonas = new ArrayList<>();
//        listadoDePersonas.add(new Person("Carlos", "Medina", "097842877"));
//        listadoDePersonas.add(new Person("Yaima", "Rodriguez", "056527222"));
//
//        return listadoDePersonas;
//    }

}

