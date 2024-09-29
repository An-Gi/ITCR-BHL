package com.example.demo.Publication_Collection;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class PublicationCollectionId implements Serializable{
    private int publication;
    private int collection;

    public PublicationCollectionId() {}

    //constructor del id de "publication_collection"
    public PublicationCollectionId(int publication, int collection) {
        this.publication = publication;
        this.collection = collection;
    }

    // método para verificar que el id sea único
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicationCollectionId that = (PublicationCollectionId) o;
        return Objects.equals(publication, that.publication) &&
                Objects.equals(collection, that.collection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publication, collection);
    }
}
