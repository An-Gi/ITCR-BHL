package com.example.demo.Species;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    /* Método para encontrar una especie por medio de su nombre científico,
    recibe un String que representa el nombre y devuelve una lista de
    objetos de tipo "Species" */
    @Query("SELECT S FROM Species S WHERE S.name LIKE %:name%")
    List<Species> findByNameLikeIgnoreCase(String name);
}