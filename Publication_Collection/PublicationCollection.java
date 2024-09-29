package com.example.demo.Publication_Collection;

import com.example.demo.Publication.Publication;
import com.example.demo.Collection.Collection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "Publication_Collection")
@IdClass(PublicationCollectionId.class)
public class PublicationCollection implements Serializable {
    //Atributos de la tabla "Publication_Collection"
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_Publication", referencedColumnName = "idPost")
    private Publication publication;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_Collection", referencedColumnName = "idCollection")
    private Collection collection;
}