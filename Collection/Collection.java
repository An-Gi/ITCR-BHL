package com.example.demo.Collection;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "collection")
public class Collection {
    //Atributos de la tabla "Collection"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCollection;
    private String name;
    private String description;
}

