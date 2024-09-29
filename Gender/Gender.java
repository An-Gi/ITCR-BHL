package com.example.demo.Gender;

import jakarta.persistence.*;

@Entity
@Table(name = "Gender")
public class Gender {
    // Atributos de la tabla "Gender"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGender;
    private String name;

    // Constructors
    public Gender() {
    }

    public Gender(String name) {
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return idGender;
    }

    public void setId(int id) {
        this.idGender = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString method (optional)
    @Override
    public String toString() {
        return "Gender [id=" + idGender + ", name=" + name + "]";
    }
}

