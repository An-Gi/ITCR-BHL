package com.example.demo.Publication_Collection;

import com.example.demo.publication.Publication;
import com.example.demo.Collection.Collection;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Publication_Collection")
@IdClass(PublicationCollectionId.class)
public class PublicationCollection implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_Publication", referencedColumnName = "idPost")
    private Publication publication;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_Collection", referencedColumnName = "idCollection")
    private Collection collection;

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}