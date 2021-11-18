package com.example.shopproject.Service;

import com.example.shopproject.Mapper.AuthorMapper;
import com.example.shopproject.Mapper.BookMapper;
import com.example.shopproject.Model.DTO.Author.AuthorDTO;
import com.example.shopproject.Model.DTO.Book.BookDTO;
import com.example.shopproject.Model.Entity.BookAuthor;
import com.example.shopproject.Repository.AuthorRepository;
import com.example.shopproject.Repository.BookAuthorRepository;
import com.example.shopproject.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookAuthorService {

    @Autowired
    private BookAuthorRepository bookAuthorRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<AuthorDTO> GetIDAuthorsForBook(String ISBN){
        List<BookAuthor> bookAuthorsList = bookAuthorRepository.findAllByISBN(ISBN);
        List<AuthorDTO> authorDTOList = new ArrayList<>();

        for (BookAuthor bookAuthor: bookAuthorsList) {
            var author = authorRepository.findById(bookAuthor.getIDAUTHOR());
            if(author.isPresent())
                authorDTOList.add(AuthorMapper.AuthortoAuthorDTO(author.get()));
        }
        return authorDTOList;
    }
    public List<BookDTO> GetAllBooksForAuthor(Integer IDAUTHOR){
        List<BookAuthor> bookAuthorsList = bookAuthorRepository.findAllByIDAUTHOR(IDAUTHOR);
        List<BookDTO> bookDTOList = new ArrayList<>();

        for (BookAuthor bookAuthor: bookAuthorsList) {
            var book = bookRepository.findById(bookAuthor.getISBN());
            book.ifPresent(value -> bookDTOList.add(BookMapper.BooktoBookDTO(value)));
        }
        return bookDTOList;
    }

    public List<BookAuthor> GetISBNsForAuthor(Integer ID){
        return bookAuthorRepository.findAllByIDAUTHOR(ID);
    }

    public void PostBookAuthor(BookAuthor bookAuthor){
        bookAuthorRepository.save(bookAuthor);
    }
    public void DeleteByISBN(String ISBN){
        bookAuthorRepository.deleteByISBN(ISBN);
    }
    public void DeletebyIDAUTHOR(Integer IDAUTHOR){
        bookAuthorRepository.deleteByIDAUTHOR(IDAUTHOR);
    }
}
