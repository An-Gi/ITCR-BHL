package com.example.demo.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    /*Método para obtener un autor por medio del número de cédula, le entra un int
     que representa el número de cédula y devuelve un objeto de tipo "Author" si es
     que se encuentra*/
    public Optional<Author> getAuthorByIdCard(int idCard){
        return authorRepository.findByIdCard(idCard);
    }
}