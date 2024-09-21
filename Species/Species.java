package com.example.demo.Species;

import jakarta.persistence.*;
import java.io.Serializable;
import com.example.demo.Gender.Gender;

@Entity
@Table(name = "Species")
public class Species implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSpecies;

    private String name;

    @ManyToOne
    @JoinColumn(name = "Geneder", referencedColumnName = "idGender", foreignKey = @ForeignKey(name = "fk_genero"))
    private Gender gender;

    public Integer getIdSpecies() {
        return idSpecies;
    }


    public void setIdSpecies(Integer idSpecies) {
        this.idSpecies = idSpecies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
