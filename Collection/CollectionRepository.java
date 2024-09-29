package com.example.demo.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {
    /* Método para encontrar una colección por medio del nombre, recibe un string
    que representa el nombre y devuelve un objeto de tipo "Collection" si es que
    se encuentra. */
    Optional<Collection> findCollectionByName(String name);
}