package com.example.demo.Publication;

import com.example.demo.Collection.Collection;
import com.example.demo.Publication_Collection.PublicationCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
    @Query("SELECT p From Publication p WHERE p.doi=?1")
    Optional<Publication> findPublicationByDoi (String doi);

    @Query("SELECT PN FROM Publication PN WHERE PN.title LIKE %:title%")
    List<Publication> findByTitleLike(@Param("title") String title);


    @Query("SELECT pc FROM PublicationCollection pc WHERE pc.collection = :collection")
    List<PublicationCollection> findByCollection(@Param("collection") Collection collection);
}
