package com.skillbox.hibernate.first;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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

        User user = session.get(User.class, "Bob");
        User user2 = session.get(User.class, "Jack");
        User user3 = session.get(User.class, "John");

//        User newUser = new User();
//        newUser.setName("Vasya");
//        newUser.setScore(98);
//        session.save(newUser);
        User updateUser = session.get(User.class, "Vasya");
        System.out.println(user + "\n" + user2 + "\n" + user3 + "\n" + updateUser);

        transaction.commit();
        sessionFactory.close();
    }
}
