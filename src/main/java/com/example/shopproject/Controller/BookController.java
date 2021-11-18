package com.example.shopproject.Controller;


import com.example.shopproject.Model.DTO.Author.AuthorDTO;
import com.example.shopproject.Model.DTO.Book.BookDTO;
import com.example.shopproject.Model.DTO.Book.PostBookDTO;
import com.example.shopproject.Model.DTO.DTO;
import com.example.shopproject.Model.Entity.BookAuthor;
import com.example.shopproject.Service.BookAuthorService;
import com.example.shopproject.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/bookcollection/books")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookAuthorService bookAuthorService;


    @GetMapping("/{ISBN}")
    public DTO GetBookByISBN(@PathVariable String ISBN, @RequestParam(required = false, defaultValue = "true") String verbose){
        if(Objects.equals(verbose, "true"))
            return bookService.GetBookByISBN(ISBN);
        else{
            System.out.println(bookService.GetPartialBookByISBN(ISBN));
            return bookService.GetPartialBookByISBN(ISBN);
        }
    }


    @PostMapping
    public void PostBook(@RequestBody PostBookDTO postBookDTO){
        bookService.PostBook(postBookDTO);
    }

    @DeleteMapping
    public void DeleteBook(@RequestParam String ISBN){
        bookService.DeleteBook(ISBN);
    }

    @GetMapping("/all")
    public List<BookDTO> GetAllBooks(){
        return bookService.GetAllBooks();
    }

    @GetMapping("/{ISBN}/authors")
    public List<AuthorDTO> GetIDAuthorsForBook(@PathVariable String ISBN){
        return bookAuthorService.GetIDAuthorsForBook(ISBN);
    }

//    @GetMapping("/{ID}/authors")
//    public List<BookAuthor> GetISBNsForAuthor(@RequestParam Integer IDAUTHOR){
//        return bookAuthorService.GetISBNsForAuthor(IDAUTHOR);
//    }

    @PostMapping("/{IDAUTHOR}/authors/{ISBN}")
    public void PostBookAuthor(@PathVariable Integer IDAUTHOR, @PathVariable String ISBN){
        bookAuthorService.PostBookAuthor(new BookAuthor(ISBN,IDAUTHOR));
    }

    @GetMapping
    public List<BookDTO> GetBooksPerPage(@RequestParam Integer page, @RequestParam(required = false, defaultValue = "10") Integer itemsPerPage){
        return bookService.GetBooksPerPage(page, itemsPerPage);
    }

    @GetMapping("/find")
    public List<BookDTO> GetBooksByGenreYear(@RequestParam(required = false, defaultValue = "") String GENRE, @RequestParam(required = false, defaultValue = "0") Integer YEAR){
        if(!Objects.equals(GENRE, "") && YEAR != 0){
            return bookService.GetBooksByGenreAndYear(GENRE, YEAR);
        }
        else if(!Objects.equals(GENRE, "")){
            return bookService.GetBooksByGenre(GENRE);
        }
        else if(YEAR != 0){
            return bookService.GetBooksByYear(YEAR);
        }
        else
            return new ArrayList<BookDTO>();
    }

}
