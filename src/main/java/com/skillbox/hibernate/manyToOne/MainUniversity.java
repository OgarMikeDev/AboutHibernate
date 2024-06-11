package com.skillbox.hibernate.manyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class MainUniversity {
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

        University university = new University();
        university.setTitle("МИФИ");

        Student student = new Student();
//        student.setUniversity(university);
        student.setName("Anna");
        session.save(student);

        Student studentTwo = new Student();
//        studentTwo.setUniversity(university);
        studentTwo.setName("Boris");
        session.save(studentTwo);

//        university.setStudents(List.of(student, studentTwo));
        session.save(university);

        University universityTwo = new University();
        universityTwo.setTitle("МГУ им. Ломоносова");

        Student studentThree = new Student();
//        studentThree.setUniversity(universityTwo);
        studentThree.setName("Air");
        session.save(studentThree);

        Student studentFour = new Student();
//        studentFour.setUniversity(universityTwo);
        studentFour.setName("Kiril");
        session.save(studentFour);

//        universityTwo.setStudents(List.of(studentThree, studentFour));
        session.save(universityTwo);

        System.out.println(university.getStudents() + "\n" + universityTwo.getStudents());

        transaction.commit();
        sessionFactory.close();
    }
}
