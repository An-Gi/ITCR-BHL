package com.example.demo.Author;
import com.example.demo.Collection.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    /*Método para encontrar un autor por número de cédula, le entra un int que representa
     el número de cédula y devuelve un objeto "Author" si es que se encuentra.*/
    Optional<Author> findByIdCard(int idCard);
}