package com.example.shopproject.Repository;

import com.example.shopproject.Model.Entity.BookAuthor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface BookAuthorRepository extends CrudRepository<BookAuthor, Integer> {
    List<BookAuthor> findAllByIDAUTHOR(Integer idauthor);
    List<BookAuthor> findAllByISBN(String isbn);
    void deleteByISBN(String isbn);
    void deleteByIDAUTHOR(Integer idauthor);
}
