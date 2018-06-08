package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDao {


    List<User> getUserList();
    User getUsreBYId(int id);
    void addUser(User user);
    void editUser(User user);
    void deleteUser(User user);

}
