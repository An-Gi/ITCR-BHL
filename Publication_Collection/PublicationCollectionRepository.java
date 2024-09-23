package com.example.demo.Publication_Collection;

import com.example.demo.Collection.Collection;
import com.example.demo.publication.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface PublicationCollectionRepository extends JpaRepository<PublicationCollection, PublicationCollectionId> {
    @Query("SELECT pc FROM PublicationCollection pc WHERE pc.collection = :collection")
    List<PublicationCollection> findByCollection(@Param("collection") Collection collection);

    @Query("SELECT pc FROM PublicationCollection pc WHERE pc.publication = :publication")
    List<PublicationCollection> findByPublication(@Param("publication") Publication publication);

}
