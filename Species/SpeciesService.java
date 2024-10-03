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
        return speciesRepository.findByNameLikeIgnoreCase(name);
    }

    /* Método para obtener una especie por su id, recibe como
    parámetro un int que representa su id y devuelve un objeto
    de tipo "Species" */
    public Species getByID(int id){ return speciesRepository.findById(id).get(); }

    /* Método para obtener todas las especie, no recibe nada
     como entrada y devuelve una Lista de objetos de tipo
     "Species" */
    public List<Species> getAllSpecies(){return speciesRepository.findAll();}

}