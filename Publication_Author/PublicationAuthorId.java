package com.example.demo.Publication_Author;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class PublicationAuthorId implements Serializable {
    private int publication;
    private int author;

//constructor del id de "publication_author"
    public PublicationAuthorId(int publication, int author) {
        this.publication = publication;
        this.author = author;
    }
    public PublicationAuthorId(){
    }
    // método para verificar que el id sea único
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