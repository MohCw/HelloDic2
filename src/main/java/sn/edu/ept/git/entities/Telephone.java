package sn.edu.ept.git.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity

public class Telephone {
    @Id
    private int id;
    private String number;
    private String operateur;

    @ManyToOne
    private Personne proprietaire;
}
