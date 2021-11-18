package com.example.shopproject.Model.DTO.Author;

import com.example.shopproject.Model.DTO.DTO;
import com.example.shopproject.Model.Entity.Author;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AuthorDTO implements DTO {

    private Integer ID;
    private String PRENUME;
    private String NUME;

}
