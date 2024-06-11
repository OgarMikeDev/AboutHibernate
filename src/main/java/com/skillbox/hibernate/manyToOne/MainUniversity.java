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

//        //Университет МИФИ
//        University university = new University();
//        university.setTitle("МИФИ");
//
//        Student student = new Student();
//        student.setUniversity(university);
//        student.setName("Anna");
//        session.save(student);
//        university.setStudents(student);
//
//        Student studentTwo = new Student();
//        studentTwo.setUniversity(university);
//        studentTwo.setName("Boris");
//        session.save(studentTwo);
//        university.setStudents(studentTwo);
//
//        session.save(university);
//
//        //Университет МГУ им. Ломоносова
//        University universityTwo = new University();
//        universityTwo.setTitle("МГУ им. Ломоносова");
//
//        Student studentThree = new Student();
//        studentThree.setUniversity(universityTwo);
//        studentThree.setName("Air");
//        session.save(studentThree);
//        universityTwo.setStudents(studentThree);
//
//        Student studentFour = new Student();
//        studentFour.setUniversity(universityTwo);
//        studentFour.setName("Kiril");
//        session.save(studentFour);
//        universityTwo.setStudents(studentFour);
//
//        session.save(universityTwo);
//
//        System.out.println("First university: " + university.getStudents() + "\nSecond university: " + universityTwo.getStudents());
        Student student = session.get(Student.class, 2);
        Student student2 = session.get(Student.class, 3);
        System.out.println(student.getName() + "\n" + student2.getName());

        University university = session.get(University.class, 1);
        University university2 = session.get(University.class, 2);
        System.out.println(university.getTitle() + "\n" + university2.getTitle());

        transaction.commit();
        sessionFactory.close();
    }
}
