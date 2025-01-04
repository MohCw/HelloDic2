package sn.edu.ept.git.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

@Entity
public class Etudiant implements Serializable {
    @Id
    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;

    @OneToOne(mappedBy = "etudiant")
    private Carte carte;
}
