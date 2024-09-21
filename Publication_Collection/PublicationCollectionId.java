package com.example.demo.Publication_Collection;

import java.io.Serializable;
import java.util.Objects;

public class PublicationCollectionId implements Serializable{
    private int publication;
    private int collection;

    public PublicationCollectionId() {}

    public PublicationCollectionId(int publication, int collection) {
        this.publication = publication;
        this.collection = collection;
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

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
