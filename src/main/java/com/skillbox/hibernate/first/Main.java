package com.skillbox.hibernate.first;

import com.skillbox.hibernate.mToM.Reader;
import com.skillbox.hibernate.manyToOne.University;
import com.skillbox.hibernate.oneToOne.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    private static SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

    public static void main(String[] args) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            Reader reader = session.get(Reader.class, 1L);

            System.out.println(reader.getBooks());
            session.getTransaction().commit();
            session.close();

//            System.out.println(university.getTitle());
//            System.out.println(university.getStudents());


//            session = sessionFactory.getCurrentSession();
//            session.getTransaction().begin();
//            User user = session.get(User.class, 3L);
//            System.out.println(user);
//            session.getTransaction().commit();
//            session.close();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
