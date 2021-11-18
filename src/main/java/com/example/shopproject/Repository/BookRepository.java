package com.example.shopproject.Repository;


import com.example.shopproject.Model.Entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,String> {
    List<Book> findAllByGEN(String GEN);
    List<Book> findAllByAN(Integer AN);
    List<Book> findAllByGENAndAN(String GEN, Integer AN);
}
