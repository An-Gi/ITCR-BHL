package com.example.demo.Collection;
import jakarta.persistence.*;

@Entity
@Table(name = "collection")
public class Collection {
    //Atributos de la tabla "Collection"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCollection;

    private String name;

    private String description;


    public int getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(int idCollection) {
        this.idCollection = idCollection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

