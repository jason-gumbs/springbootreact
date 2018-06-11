//package com.example.demo.dao.impl;
//
//import com.example.demo.exception.ResourceNotFound;
//import com.example.demo.model.User;
//
//
//import com.example.demo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//
//import java.util.LinkedList;
//import java.util.List;
//
//@Repository
//@Transactional
//public class UserDaoImpl  {
//
//    @Autowired
//    private UserRepository userRepository;
//
//        public User getUserById (Long id ) {
//            return userRepository.findById(id)
//                    .orElseThrow(() -> new ResourceNotFound("User", "id", id));
//        }
//
//
//        public List<User> getUserList() {
//
//            List<User> myList = new LinkedList<User>();
//            for (User e:userRepository.findAll()) {
//                myList.add(e);
//            }
//            return myList;
//        }
//
//        public void addUser (User user) {
//
//            userRepository.save(user);
//
//        }
//
//        public void editUser (User user) {
//
//            userRepository.save(user);
//
//        }
//
//        public void deleteUser (User user) {
//            userRepository.delete(user);
//        }
//    }
//
//
//
