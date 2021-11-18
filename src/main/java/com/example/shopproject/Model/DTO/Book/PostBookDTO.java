package com.example.shopproject.Model.DTO.Book;

import com.example.shopproject.Model.DTO.DTO;
import lombok.Data;

@Data
public class PostBookDTO implements DTO {
    private String TITLU;
    private String EDITURA;
    private Integer AN;
    private String GEN;
}
