package com.example.demo.controllers;


import com.example.demo.entitys.Profile;
import com.example.demo.entitys.User;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class ControllerBasicAndMaps {

    @Autowired
    UsersRepository userRepo;

    //CREATE
    void createGroceryItems() {
        System.out.println("Data creation started...");
        userRepo.save(new User("097842877",new Profile("Carlos","Medina","admin")));
        userRepo.save(new User("097842877",new Profile("Carlos","Medina","admin")));
        userRepo.save(new User("097842877",new Profile("Carlos","Medina","admin")));
        userRepo.save(new User("097842877",new Profile("Carlos","Medina","admin")));
        System.out.println("Data creation complete...");
    }


    @GetMapping(path = {"/import"})
    public ModelAndView importar() {
        createGroceryItems();
//        ModelAndView modelAndView = new ModelAndView("inicio");
//        modelAndView.addObject("persons", userRepo.findAll());
        return null;
    }


//    public List<Person> getPersons() {
//        ArrayList<Person> listadoDePersonas = new ArrayList<>();
//        listadoDePersonas.add(new Person("Carlos", "Medina", "097842877"));
//        listadoDePersonas.add(new Person("Yaima", "Rodriguez", "056527222"));
//
//        return listadoDePersonas;
//    }



    @GetMapping(path = {"/list", "all"})
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("inicio");
        modelAndView.addObject("users", userRepo.findAll());
        return modelAndView;
    }

    @GetMapping(path = {"/{id}"})
    public ModelAndView searchUserbyId(@PathVariable(name = "id") String id) {
        ModelAndView modelAndView = new ModelAndView("inicio");
        User otherUser = new User("",new Profile("","",""));
        modelAndView.addObject("users", userRepo.findById(id).orElse(otherUser));
        System.out.println(userRepo.findById(id).orElse(null));

        return modelAndView;
    }

}

