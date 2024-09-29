package com.example.demo.Species;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

}