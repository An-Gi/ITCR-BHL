package com.example.demo.Publication_Species;

import com.example.demo.Collection.Collection;
import com.example.demo.Publication_Collection.PublicationCollection;
import com.example.demo.Species.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationSpeciesRepository extends JpaRepository<PublicationSpecies, Integer> {
    /*@Query("SELECT PS FROM PublicationSpecies PS WHERE PS.species.name=?1")
    Optional<Species>findBySpecies(String name);*/

    @Query("SELECT PS FROM PublicationSpecies PS WHERE PS.species = :species")
    List<PublicationSpecies> findBySpecies(@Param("species") Species species);
}
