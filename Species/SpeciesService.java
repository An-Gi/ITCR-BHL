package com.example.demo.Species;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepository;

    /* Método para obtener una especie por medio de su nombre,
    recibe un String que representa el nombre y devuelve una
    lista de objetos de tipo "Species". */
    public List<Species> findByName(String name) {
        return speciesRepository.findByNameIgnoreCase(name);
    }
    public Species saveSpecies(Species species) {
        return speciesRepository.save(species);
    }

    public void deleteSpeciesById(Integer id) {
        speciesRepository.deleteById(id);
    }

}