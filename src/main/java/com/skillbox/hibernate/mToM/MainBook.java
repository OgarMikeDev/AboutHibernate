package com.skillbox.hibernate.mToM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class MainBook {
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


//        Reader reader = new Reader();
//        reader.setName("Dima");
//
//        Reader reader2 = new Reader();
//        reader2.setName("Zakhar");
//
//        Reader reader3 = new Reader();
//        reader3.setName("Dinar");
//
//        Reader reader4 = new Reader();
//        reader4.setName("Denis");
//
//        Book book = new Book();
//        book.setTitle("7 skills effective peoples");
//        book.setReaders(List.of(reader));
//
//        Book book2 = new Book();
//        book2.setTitle("Warn and world");
//        book.setReaders(List.of(reader3, reader4));
//
//        Book book3 = new Book();
//        book3.setTitle("Faust");
//        book3.setReaders(List.of(reader2, reader4));
//
//        Book book4 = new Book();
//        book4.setTitle("Dog hearts");
//        book4.setReaders(List.of(reader, reader2, reader3, reader4));
//
//        reader.setBooks(List.of(book, book2, book3, book4));
//        reader2.setBooks(List.of(book2, book3));
//        reader3.setBooks(List.of(book3, book4));
//        reader4.setBooks(List.of(book));
//
//        session.save(reader);
//        session.save(reader2);
//        session.save(reader3);
//        session.save(reader4);
//        session.save(book);
//        session.save(book2);
//        session.save(book3);
//        session.save(book4);

        Reader getReader = session.get(Reader.class, 1L);
        Book getBook = session.get(Book.class, 1L);
        System.out.println(getReader + "\n" + getBook);

        transaction.commit();
        sessionFactory.close();
    }
}
