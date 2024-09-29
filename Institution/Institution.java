package com.example.demo.Institution;
import jakarta.persistence.*;
@Entity
@Table(name = "institution")
public class Institution {
    //Atributos de la tabla "Institution"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Institution")
    private Integer ID_Institution;

    @Column(name = "Name", nullable = false)
    private String name;

    public Integer getIdInstitution() {
        return ID_Institution;
    }

    public void setIdInstitution(Integer ID_Institution) {
        this.ID_Institution = ID_Institution;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}