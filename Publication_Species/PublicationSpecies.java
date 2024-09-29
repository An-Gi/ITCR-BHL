package com.example.demo.Publication_Species;

import com.example.demo.Publication.Publication;
import com.example.demo.Species.Species;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "Publication_Species")
@IdClass(PublicationSpeciesId.class)
public class PublicationSpecies implements Serializable {
//Atributos de la tabla "Publication_Species"
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_Publication", referencedColumnName = "idPost")
    private Publication publication;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_Species", referencedColumnName = "idSpecies")
    private Species species;
}
