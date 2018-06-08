package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import java.util.List;

import com.example.demo.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

        @Autowired
        private SessionFactory sessionFactory;

        public User getUserById (int id) {
            Session session = sessionFactory.getCurrentSession();
            User user = (User) session.get(User.class, id);
            session.flush();

            return user;
        }

        public List<User> getUserList() {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from User");
            List<User> userList = query.list();
            session.flush();

            return userList;
        }

        public void addUser (User user) {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(user);
            session.flush();
        }

        public void editUser (User user) {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(user);
            session.flush();
        }

        public void deleteUser (User user) {
            Session session = sessionFactory.getCurrentSession();
            session.delete(user);
            session.flush();
        }
    }



