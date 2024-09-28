package com.example.demo.Author;

import com.example.demo.Collection.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorByID(int id){
        return authorRepository.findAuthorByIdAuthor(id);
    }

    public Optional<Author> getAuthorByIdCard(int idCard){
        return authorRepository.findByIdCard(idCard);
    }
}