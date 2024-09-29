package com.example.demo.Publication_Collection;

import com.example.demo.Collection.Collection;
import com.example.demo.Publication.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PublicationCollectionRepository extends JpaRepository<PublicationCollection, PublicationCollectionId> {
    /* Método para encontrar por colección, recibe un
    objeto de tipo "Collection" y devuelve una lista de
     objetos de tipo "PublicationCollection". */
    @Query("SELECT pc FROM PublicationCollection pc WHERE pc.collection = :collection")
    List<PublicationCollection> findByCollection(@Param("collection") Collection collection);

    /* Método para encontrar por publicación, recibe un
    objeto de tipo "Publication" y devuelve una lista de
     objetos de tipo "PublicationCollection". */
    @Query("SELECT pc FROM PublicationCollection pc WHERE pc.publication = :publication")
    List<PublicationCollection> findByPublication(@Param("publication") Publication publication);

    /* Método para eliminar por publicación, recibe
    un objeto de tipo "Publication" y no devuelve nada. */
    void deleteByPublication(Publication publication);

}
