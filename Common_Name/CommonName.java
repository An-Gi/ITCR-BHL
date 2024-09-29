package com.example.demo.Common_Name;

import com.example.demo.Species.Species;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Getter
@Setter
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
}