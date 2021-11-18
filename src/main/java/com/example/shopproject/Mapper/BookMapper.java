package com.example.shopproject.Mapper;
import com.example.shopproject.Model.DTO.Book.BookDTO;
import com.example.shopproject.Model.DTO.Book.PartialBookDTO;
import com.example.shopproject.Model.DTO.Book.PostBookDTO;
import com.example.shopproject.Model.Entity.Book;

public class BookMapper {
    public static BookDTO BooktoBookDTO(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAN(book.getAN());
        bookDTO.setEDITURA(book.getEDITURA());
        bookDTO.setGEN(book.getGEN());
        bookDTO.setISBN(book.getISBN());
        bookDTO.setTITLU(book.getTITLU());
        return bookDTO;
    }
    public static Book BookDTOtoBook(BookDTO bookDTO){
        Book book = new Book();
        book.setAN(bookDTO.getAN());
        book.setEDITURA(bookDTO.getEDITURA());
        book.setGEN(bookDTO.getGEN());
        book.setISBN(bookDTO.getISBN());
        book.setTITLU(bookDTO.getTITLU());
        return book;
    }
    public static PartialBookDTO BooktoPartialBookDTO(Book book){
        PartialBookDTO partialBookDTO = new PartialBookDTO();
        partialBookDTO.setIsbn(book.getISBN());
        partialBookDTO.setTitlu(book.getTITLU());
        return partialBookDTO;
    }
    public static PostBookDTO BooktoPostBookDTO(Book book){
        PostBookDTO postBookDTO = new PostBookDTO();
        postBookDTO.setAN(book.getAN());
        postBookDTO.setEDITURA(book.getEDITURA());
        postBookDTO.setGEN(book.getGEN());
        postBookDTO.setTITLU(book.getTITLU());
        return postBookDTO;
    }
    public static Book PostBookDTOtoBook(PostBookDTO postBookDTO){
        Book book = new Book();
        book.setAN(postBookDTO.getAN());
        book.setEDITURA(postBookDTO.getEDITURA());
        book.setGEN(postBookDTO.getGEN());
        book.setTITLU(postBookDTO.getTITLU());
        return book;
    }
}
