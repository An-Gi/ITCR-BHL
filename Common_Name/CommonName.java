package com.example.demo.Common_Name;

import com.example.demo.Species.Species;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CommonName")
public class CommonName implements Serializable {

    //Atributos de la tabla "CommonName"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCommonName;

    private String name;

    @ManyToOne
    @JoinColumn(name = "ID_Species", referencedColumnName = "idSpecies", foreignKey = @ForeignKey(name = "fk_especie"))
    private Species species;

    public Integer getIdCommonName() {
        return idCommonName;
    }

    public void setIdCommonName(Integer idCommonName) {
        this.idCommonName = idCommonName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}