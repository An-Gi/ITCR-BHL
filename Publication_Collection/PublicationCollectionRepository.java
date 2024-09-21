package com.example.demo.Publication_Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PublicationCollectionRepository extends JpaRepository<PublicationCollection, PublicationCollectionId> {
}
