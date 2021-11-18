package com.example.shopproject.Service;

import com.example.shopproject.Mapper.BookMapper;
import com.example.shopproject.Model.DTO.Book.BookDTO;
import com.example.shopproject.Model.DTO.Book.PartialBookDTO;
import com.example.shopproject.Model.DTO.Book.PostBookDTO;
import com.example.shopproject.Model.Entity.Book;
import com.example.shopproject.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public BookDTO GetBookByISBN(String ISBN){
        var book = bookRepository.findById(ISBN);
        return book.map(BookMapper::BooktoBookDTO).orElse(null);
    }
    public PartialBookDTO GetPartialBookByISBN(String ISBN){
        var book = bookRepository.findById(ISBN);
        return book.map(BookMapper::BooktoPartialBookDTO).orElse(null);
    }

    public void PostBook(PostBookDTO postBookDTO){
        var book = BookMapper.PostBookDTOtoBook(postBookDTO);
        book.setISBN(UUID.randomUUID().toString());
        bookRepository.save(book);
    }

    public void DeleteBook(String isbn){
        bookRepository.deleteById(isbn);
    }

    public List<BookDTO> GetAllBooks(){
        List<BookDTO> bookDTOS = new ArrayList<>();
        bookRepository.findAll().forEach(book -> {bookDTOS.add(BookMapper.BooktoBookDTO(book));});
        return bookDTOS;
    }

    public List<BookDTO> GetBooksPerPage(Integer page, Integer itemsPerPage){
        List<BookDTO> bookList = GetAllBooks();

        if(page < 1)
            page = 1;
        if(itemsPerPage < 1)
            itemsPerPage = 10;
        if(page > (bookList.size() / itemsPerPage))
            if((bookList.size() % itemsPerPage == 0))
                page = bookList.size() / itemsPerPage;
            else
                page = bookList.size() / itemsPerPage + 1;

        int firstElement = (page - 1) * itemsPerPage;
        int lastElement = page * itemsPerPage - 1;


        if( lastElement >= bookList.size())
            lastElement = bookList.size()-1;

        return bookList.subList(firstElement, lastElement + 1);
    }

    public List<BookDTO> GetBooksByGenre(String GEN){
        List<BookDTO> bookDTOS = new ArrayList<>();
        bookRepository.findAllByGEN(GEN).forEach(book -> {bookDTOS.add(BookMapper.BooktoBookDTO(book));});
        return bookDTOS;
    }

    public List<BookDTO> GetBooksByYear(Integer AN){
        List<BookDTO> bookDTOS = new ArrayList<>();
        bookRepository.findAllByAN(AN).forEach(book -> {bookDTOS.add(BookMapper.BooktoBookDTO(book));});
        return bookDTOS;
    }

    public List<BookDTO> GetBooksByGenreAndYear(String GEN, Integer AN){
        List<BookDTO> bookDTOS = new ArrayList<>();
        bookRepository.findAllByGENAndAN(GEN, AN).forEach(book -> {bookDTOS.add(BookMapper.BooktoBookDTO(book));});
        return bookDTOS;
    }

}
