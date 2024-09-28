package com.example.demo.Publication_Author;
import com.example.demo.Publication.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationAuthorRepository extends JpaRepository<PublicationAuthor, PublicationAuthorId> {
    @Query("SELECT pa FROM PublicationAuthor pa WHERE pa.publication = :publication")
    List<PublicationAuthor> findByPublication(@Param("publication") Publication publication);

    void deleteByPublication(Publication publication);
}