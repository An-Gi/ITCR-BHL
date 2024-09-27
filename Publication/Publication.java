package com.example.demo.Publication;

import com.example.demo.Institution.Institution;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "publication")
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;

    @Setter
    @Getter
    private String title;

    private LocalDate postdate;

    private String publisherMagazine;

    private String doi;

    private String isbn;

    private String publicationcountry;

    @ManyToOne
    @JoinColumn(name = "ID_Institution", referencedColumnName = "ID_Institution", foreignKey = @ForeignKey(name = "fk_institution"))
    private Institution institution;

    public Publication(String title, String postdate, String publisherMagazine,String doi,String isbn, String publicationcountry, Institution ID_Institution) {
        this.title = title;
        this.postdate = LocalDate.parse(postdate);
        this.publisherMagazine = publisherMagazine;
        this.isbn =isbn;
        this.doi = doi;
        this.publicationcountry = publicationcountry;
        this.institution = ID_Institution;
    }

    public Publication() {
    }

}
