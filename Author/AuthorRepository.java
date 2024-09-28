package com.example.demo.Author;
import com.example.demo.Collection.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findAuthorByIdAuthor(int id);

    Optional<Author> findByIdCard(int idCard);
}