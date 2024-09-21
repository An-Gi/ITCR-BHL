package com.example.demo.Publication_Species;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationSpeciesRepository extends JpaRepository<PublicationSpecies, Integer> {
}
