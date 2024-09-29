package com.example.demo.Publication_Author;

import com.example.demo.Author.Author;
import com.example.demo.Publication.Publication;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Getter
@Setter
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
}