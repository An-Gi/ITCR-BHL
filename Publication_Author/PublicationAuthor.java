package com.example.demo.Publication_Author;

import com.example.demo.Author.Author;
import com.example.demo.Publication.Publication;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Publication_Author")
@IdClass(PublicationAuthorId.class)
public class PublicationAuthor implements Serializable {
    //Atributos de la tabla "Publicaction_Author"
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_Publication", referencedColumnName = "idPost")
    private Publication publication;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_Author", referencedColumnName = "idAuthor")
    private Author author;

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}