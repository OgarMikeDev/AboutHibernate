package com.skillbox.hibernate.first;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .getMetadataBuilder()
                .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
                .build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        User user = new User();
        user.setName("Bob");
        user.setScore(87);

        User user2 = new User();
        user2.setName("Jack");
        user2.setScore(76);

        User user3 = new User();
        user3.setName("John");
        user3.setScore(61);

        session.save(user);
        session.save(user2);
        session.save(user3);

        User updateUser = session.get(User.class, "Bob");

        System.out.println(user + "\n" + user2 + "\n" + user3 + "\n" + updateUser);

        transaction.commit();
        sessionFactory.close();
    }
}
