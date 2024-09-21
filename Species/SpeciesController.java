package com.example.demo.Species;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    private SpeciesService speciesService;

    @GetMapping
    public List<Species> getAllSpecies() {
        return speciesService.getAllSpecies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Species> getSpeciesById(@PathVariable Integer id) {
        Optional<Species> species = speciesService.getSpeciesById(id);
        return species.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Species createSpecies(@RequestBody Species species) {
        return speciesService.saveSpecies(species);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Species>> getSpeciesByName(@PathVariable String name) {
        List<Species> species = speciesService.findByName(name);
        return ResponseEntity.ok(species);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecies(@PathVariable Integer id) {
        speciesService.deleteSpeciesById(id);
        return ResponseEntity.noContent().build();
    }
}