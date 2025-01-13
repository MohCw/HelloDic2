package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder //vous souhaitez construire un objet enfant (Etudiant) tout en spécifiant des attributs définis dans la classe parent (Personne).

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ROLE")
@DiscriminatorValue(value = "EMPLOYE")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(name = "DATE_NAISSANCE")
    private LocalDate dateNaissance;

    private String lieuNaissance;

    private String adresse;

}
