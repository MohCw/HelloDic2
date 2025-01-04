package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
