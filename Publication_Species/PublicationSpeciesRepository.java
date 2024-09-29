package com.example.demo.Publication_Species;

import com.example.demo.Species.Species;
import com.example.demo.Publication.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PublicationSpeciesRepository extends JpaRepository<PublicationSpecies, Integer> {
    /* Método para encontrar por especie, recibe un
    objeto de tipo "Species" y devuelve una lista de
     objetos de tipo "PublicationSpecies". */
    @Query("SELECT PS FROM PublicationSpecies PS WHERE PS.species = :species")
    List<PublicationSpecies> findBySpecies(@Param("species") Species species);

    /* Método para encontrar por publicación, recibe un
    objeto de tipo "Publication" y devuelve una lista de
     objetos de tipo "PublicationCollection". */
    @Query("SELECT PS FROM PublicationSpecies PS WHERE PS.publication = :publications")
    List<PublicationSpecies> findByPublications(@Param("publications") Publication publication);

    /* Método para eliminar por publicación, recibe
   un objeto de tipo "Publication" y no devuelve nada. */
    void deleteByPublication(Publication publication);
}

