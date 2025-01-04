package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carte")
public class Carte implements Serializable {
    @Id
    private String code;
    private Date dateCreation;
    private Date dateModification;
    private Date dateDebut;
    private Date dateFin;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Etudiant etudiant;

    @PrePersist
    @PreUpdate
    public void beforeCreate(){
        this.dateCreation = new Date();
        this.dateModification = new Date();
    }
}