package com.example.shopproject.Service;


import com.example.shopproject.Mapper.AuthorMapper;
import com.example.shopproject.Model.DTO.Author.AuthorDTO;
import com.example.shopproject.Model.DTO.Author.PostAuthorDTO;
import com.example.shopproject.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorDTO GetAuthorByID(Integer ID){
        var author = authorRepository.findById(ID);
        return author.map(AuthorMapper::AuthortoAuthorDTO).orElse(null);
    }

    public void PostAuthor(PostAuthorDTO postAuthorDTO){
        authorRepository.save(AuthorMapper.PostAuthorDTOtoAuthor(postAuthorDTO));
    }
    public void DeleteAuthor(Integer id)
    {
        authorRepository.deleteById(id);
    }
    public List<AuthorDTO> GetAllAuthors(){
        List<AuthorDTO> authorDTOS = new ArrayList<>();
        authorRepository.findAll().forEach(author -> {authorDTOS.add(AuthorMapper.AuthortoAuthorDTO(author));});
        return authorDTOS;
    }
    public List<AuthorDTO> GetAuthorByExactName(String NAME){
        List<AuthorDTO> authorDTOS = new ArrayList<>();
        authorRepository.findAllByNUME(NAME).forEach(author -> {authorDTOS.add(AuthorMapper.AuthortoAuthorDTO(author));});
        return authorDTOS;
    }
    public List<AuthorDTO> GetAuthorByApproximativeName(String NAME){
        List<AuthorDTO> authorDTOS = new ArrayList<>();
        authorRepository.findAllByNUMEIsContaining(NAME).forEach(author -> {authorDTOS.add(AuthorMapper.AuthortoAuthorDTO(author));});
        return authorDTOS;
    }
}
