package com.example.shopproject.Model.Entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bookauthor")
public class BookAuthor {

    @Id
    @GeneratedValue
    private Integer ID;

    private String ISBN;
    private Integer IDAUTHOR;

    public BookAuthor() {

    }
    public BookAuthor(String ISBN, Integer IDAUTHOR) {
        this.ISBN = ISBN;
        this.IDAUTHOR = IDAUTHOR;
    }

    public String getISBN() {
        return ISBN;
    }

    public Integer getIDAUTHOR() {
        return IDAUTHOR;
    }
}
