//package com.example.demo.service;
//
//
//import com.example.demo.model.User;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//@Service
//public class UserService {
//
//
//    private static List<User> users = new ArrayList<User>();
//
//    static {
//        users.add(new User(1, "admin", "password"));
//
//
//    }
//
//    public List<User> userInfo() {
//        return users;
//    }
//
//    public User insertUser(User user) {
//        users.add(user);
//        return user;
//    }
//
//    public User findUser(Integer userId) {
//        for (User user : users) {
//            if (user.getId().equals(userId)) {
//                return user;
//            }
//        }
//        return null;
//    }
//
//
//    public void deleteUser(int userId) {
//        Iterator<User> iterator = users.iterator();
//        while (iterator.hasNext()) {
//            User user = iterator.next();
//            if (user.getId() == userId) {
//                iterator.remove();
//            }
//        }
//
//    }
//
//
//}
