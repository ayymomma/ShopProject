package com.example.shopproject.Controller;

import com.example.shopproject.Model.DTO.Author.AuthorDTO;
import com.example.shopproject.Model.DTO.Book.BookDTO;
import com.example.shopproject.Model.DTO.Author.PostAuthorDTO;
import com.example.shopproject.Service.AuthorService;
import com.example.shopproject.Service.BookAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/bookcollection/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @Autowired
    BookAuthorService bookAuthorService;

    @GetMapping
    public @ResponseBody
    AuthorDTO GetAuthorByID(@RequestParam Integer ID){
        return authorService.GetAuthorByID(ID);
    }

    @PostMapping
    public void PostAuthor(@RequestBody PostAuthorDTO postAuthorDTO){
        authorService.PostAuthor(postAuthorDTO);
    }

    @DeleteMapping
    public void DeleteAuthor(@RequestParam Integer ID){
        authorService.DeleteAuthor(ID);
    }

    @GetMapping("/all")
    public List<AuthorDTO> GetAllAuthors(){
        return authorService.GetAllAuthors();
    }

    @GetMapping("/{IDAUTHOR}/books")
    public List<BookDTO> GetAllBooksForAuthor(@PathVariable Integer IDAUTHOR){
        return bookAuthorService.GetAllBooksForAuthor(IDAUTHOR);
    }

    @GetMapping("/find")
    public List<AuthorDTO> GetAllAuthorsByName(@RequestParam String NAME, @RequestParam(required = false, defaultValue = "") String MATCH){
        if(Objects.equals(MATCH, "exact"))
            return authorService.GetAuthorByExactName(NAME);
        else
            return authorService.GetAuthorByApproximativeName(NAME);
    }
}
