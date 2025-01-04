package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "departement")
public class Departement implements Serializable {
    @Id
    private String code;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "departement")
    private List<Filiere> filieres;
}