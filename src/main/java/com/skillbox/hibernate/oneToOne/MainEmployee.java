package com.skillbox.hibernate.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainEmployee {
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

        Employee employee = new Employee();
        employee.setName("Nikita");

        Employee employee2 = new Employee();
        employee2.setName("Nicolya");

        Employee employee3 = new Employee();
        employee3.setName("Tysya");

        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setEmployee(employee);
        employeeDetails.setEmail("terminator@gmail.com");
        employeeDetails.setCity("California");

        EmployeeDetails employeeDetails2 = new EmployeeDetails();
        employeeDetails2.setEmployee(employee);
        employeeDetails2.setEmail("rambo@gmail.com");
        employeeDetails2.setCity("Atlanta");

        EmployeeDetails employeeDetails3 = new EmployeeDetails();
        employeeDetails3.setEmployee(employee);
        employeeDetails3.setEmail("corben_dalos@gmail.com");
        employeeDetails3.setCity("New-York");

        session.save(employeeDetails);
        session.save(employeeDetails2);
        session.save(employeeDetails3);

        employee.setDetails(employeeDetails);
        employee2.setDetails(employeeDetails2);
        employee3.setDetails(employeeDetails3);

        session.save(employee);
        session.save(employee2);
        session.save(employee3);

        System.out.println(employee + "\n" + employee2 + "\n" + employee3);

        transaction.commit();
        sessionFactory.close();
    }
}
