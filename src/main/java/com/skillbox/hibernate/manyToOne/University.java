package com.skillbox.hibernate.manyToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "universities")
@NamedQueries({
        @NamedQuery(name = "withStudents", query = "SELECT u FROM University u JOIN FETCH u.students WHERE u.id = :id")
})
public class University {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Id
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "university")
    private List<Student> students;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University() {
    }

    @Override
    public String toString() {
        return String.format("University [id = %d, title = %s, students_count = %d]", id, title, students.size());
    }
}
