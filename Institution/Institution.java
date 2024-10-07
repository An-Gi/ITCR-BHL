package com.example.demo.Institution;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "institution")
public class Institution {
    //Atributos de la tabla "Institution"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Institution")
    private Integer ID_Institution;

    @Column(name = "Name", nullable = false)
    private String name;
}
