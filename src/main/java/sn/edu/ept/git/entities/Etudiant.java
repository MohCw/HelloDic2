package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;
@SuperBuilder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

@Entity
@DiscriminatorValue(value = "ELEVE-INGENIEUR")
public class Etudiant extends Personne {
    @OneToOne(mappedBy = "etudiant")
    private Carte carte;

    @ManyToOne
    private Pays PaysDeNaissance;

    @ManyToMany
    private List<Pays> nationalites;

    @OneToOne
    private Etudiant voisin;

    private Integer numeroChambre;
    @Column(nullable = false)
    private String pavillon;
    //Since pavillon is marked as @Column(nullable = false) in Etudiant,
    // the database requires this field for ALL rows in the PERSONNE table, even for non-student entries
    //because you're using @Inheritance(strategy = InheritanceType.SINGLE_TABLE) with a discriminator,
    // which means all fields from both Personne and Etudiant are stored in a single table called PERSONNE
}
