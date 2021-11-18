package com.example.shopproject.Mapper;
import com.example.shopproject.Model.DTO.Author.AuthorDTO;
import com.example.shopproject.Model.DTO.Author.PostAuthorDTO;
import com.example.shopproject.Model.Entity.Author;

public class AuthorMapper{
    public static AuthorDTO AuthortoAuthorDTO(Author author){
        var authorDTO = new AuthorDTO();
        authorDTO.setID(author.getID());
        authorDTO.setNUME(author.getNUME());
        authorDTO.setPRENUME(author.getPRENUME());
        return authorDTO;
    }
    public static PostAuthorDTO AuthortoPostAuthorDTO(Author author){
        var authorDTO = new PostAuthorDTO();
        authorDTO.setNUME(author.getNUME());
        authorDTO.setPRENUME(author.getPRENUME());
        return authorDTO;
    }

    public static Author AuthorDTOtoAuthor(AuthorDTO authorDTO){
        var author = new Author();
        author.setID(authorDTO.getID());
        author.setNUME(authorDTO.getNUME());
        author.setPRENUME(authorDTO.getPRENUME());
        return author;
    }
    public static Author PostAuthorDTOtoAuthor(PostAuthorDTO postAuthorDTO){
        var author = new Author();
        author.setNUME(postAuthorDTO.getNUME());
        author.setPRENUME(postAuthorDTO.getPRENUME());
        return author;
    }

}
