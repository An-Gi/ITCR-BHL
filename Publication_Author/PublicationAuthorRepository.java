package com.example.demo.Publication_Author;

import com.example.demo.Publication.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PublicationAuthorRepository extends JpaRepository<PublicationAuthor, PublicationAuthorId> {
    /* Método para encontrar por publicación, recibe un
    objeto de tipo "Publication" y devuelve una lista de
     objetos de tipo "PublicationAuthor". */
    @Query("SELECT pa FROM PublicationAuthor pa WHERE pa.publication = :publication")
    List<PublicationAuthor> findByPublication(@Param("publication") Publication publication);

    /* Método para eliminar por publicación, recibe
    un objeto de tipo "Publication" y no devuelve nada. */
    void deleteByPublication(Publication publication);
}