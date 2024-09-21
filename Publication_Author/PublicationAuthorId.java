package com.example.demo.Publication_Author;

import java.io.Serializable;
import java.util.Objects;

public class PublicationAuthorId implements Serializable {
    private int publication;
    private int author;

    public PublicationAuthorId() {}

    public PublicationAuthorId(int publication, int author) {
        this.publication = publication;
        this.author = author;
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicationAuthorId that = (PublicationAuthorId) o;
        return Objects.equals(publication, that.publication) &&
                Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publication, author);
    }
}