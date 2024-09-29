package com.example.demo.Institution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;
    /* Método para obtener una institución por id, recibe
    un int que representa el id y devuelve un objeto de tipo
    "Institution" si es que se encuentra.*/
    public Optional<Institution> getByID(int id){
        return institutionRepository.findById(id);
    }
}

