package sn.edu.ept.git.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "carte")
public class Carte implements Serializable {
    @Id
    private String id;
    private Date dateCreation;
    private Date dateModification;
    private Date dateDebut;
    private Date dateFin;

    @OneToOne
    private Etudiant etudiant;
}