package com.example.demo.Gender;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Gender")
public class Gender {
    // Atributos de la tabla "Gender"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGender;
    private String name;
}

