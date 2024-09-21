package com.example.demo.Publication_Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PublicationAuthorRepository extends JpaRepository<PublicationAuthor, PublicationAuthorId> {
}