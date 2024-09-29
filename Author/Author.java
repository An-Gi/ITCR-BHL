package com.example.demo.Author;
import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author {
    //atributos de la tabla "Author"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuthor;

    private int idCard;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private int phoneNumber;
    private String email;
    private String countryOfHabitation;
    private String address;
}

