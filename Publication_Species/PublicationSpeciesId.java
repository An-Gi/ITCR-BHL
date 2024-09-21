package com.example.demo.Publication_Species;

import java.io.Serializable;
import java.util.Objects;

public class PublicationSpeciesId implements Serializable {
    private int publication;
    private int species;

    public PublicationSpeciesId() {}

    public PublicationSpeciesId(int publication, int species) {
        this.publication = publication;
        this.species = species;
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public int getSpecies() {
        return species;
    }

    public void setSpecies(int species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicationSpeciesId that = (PublicationSpeciesId) o;
        return Objects.equals(publication, that.publication) &&
                Objects.equals(species, that.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publication, species);
    }

}
