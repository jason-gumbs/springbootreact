package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


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

        return repository.save(user);

    }
    @GetMapping("/User/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        Optional<User> user = this.repository.findById(id);
        return user;
    }

    @DeleteMapping("/User/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        this.repository.deleteById(id);
    }

    @PutMapping("/User/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {

        user.setId(id);
        return repository.save( user);



    }
}



