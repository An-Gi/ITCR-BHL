package com.example.demo.Species;

import jakarta.persistence.*;
import java.io.Serializable;
import com.example.demo.Gender.Gender;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Species")
public class Species implements Serializable {
    //Atributos de la tabla "Species"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSpecies;

    private String name;

    @ManyToOne
    @JoinColumn(name = "Geneder", referencedColumnName = "idGender", foreignKey = @ForeignKey(name = "fk_genero"))
    private Gender gender;
}
