package com.example.shopproject.Model.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
public class Book implements Serializable {

    @Id
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "year")
    private Integer year;

    @Column(name = "genre")
    private String genre;

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }
}
