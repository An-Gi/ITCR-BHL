package com.example.demo.publication;

import com.example.demo.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
    @Query("SELECT p From Publication p WHERE p.doi=?1")
    Optional<Publication> findPublicationByDoi (String doi);
}
