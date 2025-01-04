package sn.edu.ept.git.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Etudiant implements Serializable {
    @Id
    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;

    @OneToOne(mappedBy = "etudiant")
    private Carte carte;

    @ManyToOne
    private Pays PaysDeNaissance;

    @ManyToMany
    private List<Pays> nationalites;
}
