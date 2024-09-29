package com.example.demo.Publication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
    /* Método para buscar una publicación por el DOI, recibe un string que representa
    el doi y devuelve un objeto de "Publication" si es que se encuentra.*/
    @Query("SELECT p From Publication p WHERE p.doi=?1")
    Optional<Publication> findPublicationByDoi (String doi);

    /* Método para buscar una publicación por el título, recibe un string que representa
    el título y devuelve un objeto de "Publication" si es que se encuentra.*/
    @Query("SELECT PN FROM Publication PN WHERE PN.title LIKE %:title%")
    List<Publication> findByTitleLike(@Param("title") String title);

}
