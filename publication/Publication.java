package com.example.demo.publication;

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

    private String title;

    private LocalDate postdate;

    private String publisherMagazine;

    private String doi;

    private String isbn;

    private String publicationcountry;

    @ManyToOne
    @JoinColumn(name = "ID_Institution", referencedColumnName = "ID_Institution", foreignKey = @ForeignKey(name = "fk_institution"))
    private Institution institution;
}
