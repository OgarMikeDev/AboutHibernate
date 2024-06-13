package com.skillbox.hibernate.mToM;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    private static Long count = 0L;
    @Column(name = "id")
    private Long id;

    @Id
    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(
            name = "books_readers",
            joinColumns = @JoinColumn(name = "book_title"),
            inverseJoinColumns = @JoinColumn(name = "reader_name")
    )
    private List<Reader> readers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public Book() {
        count += 1;
        id = count;
    }

    @Override
    public String toString() {
        return String.format("Book [id = %d, title = %s]", id, title);
    }
}
