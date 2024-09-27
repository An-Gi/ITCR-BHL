package com.example.demo.Publication_Species;

import com.example.demo.Publication.Publication;
import com.example.demo.Species.Species;
import jakarta.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Publication_Species")
@IdClass(PublicationSpeciesId.class)
public class PublicationSpecies implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_Publication", referencedColumnName = "idPost")
    private Publication publication;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_Species", referencedColumnName = "idSpecies")
    private Species species;

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
