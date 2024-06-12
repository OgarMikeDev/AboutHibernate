package com.skillbox.hibernate.manyToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    static private int id = 0;

    @Id
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "university_title")
    private University university;

    public Student() {
        id += 1;
    }

    public Student(String name, University university) {
        this.name = name;
        this.university = university;
        id += 1;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }


    @Override
    public String toString() {
        return String.format("Student [id = %d, name = %s]", id, name);
    }
}
