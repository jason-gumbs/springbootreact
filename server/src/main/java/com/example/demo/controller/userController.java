package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.LinkedList;
import java.util.List;


@RestController
public class userController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/user")
    public List<User> getUsers() {
        List<User> myList = new LinkedList<User>();
        for (User e : repository.findAll()) {
            myList.add(e);
        }
        return myList;
    }

    @PostMapping("/user/new")
    public User createUsers(@RequestBody User user) {

        List<User> userList = new LinkedList<User>();
        for (User e : repository.findAll()) {
            userList.add(e);
        }

        for (int i = 0; i < userList.size(); i++) {
            if (user.getUsername().equals(userList.get(i).getUsername()) && user.getUsername().equals(userList.get(i).getPassword())) {
                System.out.println("username/ password exist");
                return null;
            }

        }

        return repository.save(user);
    }


}

