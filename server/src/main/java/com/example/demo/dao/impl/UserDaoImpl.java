package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import java.util.List;

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

        public Event getUserById (int id) {
            Session session = sessionFactory.getCurrentSession();
            Event event = (Event) session.get(Event.class, id);
            session.flush();

            return event;
        }

        public List<User> getUserList() {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from User");
            List<Event> eventList = query.list();
            session.flush();

            return eventList;
        }

        public void addEvent (Event event) {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(event);
            session.flush();
        }

        public void editEvent (Event event) {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(event);
            session.flush();
        }

        public void deleteEvent (Event event) {
            Session session = sessionFactory.getCurrentSession();
            session.delete(event);
            session.flush();
        }
    }



