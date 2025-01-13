package sn.edu.ept.git.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestInterceptor {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence
                .createEntityManagerFactory("dic2Pu");
        EntityManager em = emf.createEntityManager();

        Etudiant etudiant =  Etudiant.builder()
                .nom("Mohamed")
                .adresse("Lazaret")
                .prenom("Camara")
                .pavillon("H4")
                .numeroChambre(2)
                .build();//Autres champs non obligatoires(nom, adresse, ...)

        Carte carte =  Carte.builder()
                .code("1234")
                .etudiant(etudiant)
                .dateDebut(new GregorianCalendar(2025, Calendar.MARCH, 3).getTime())
                .dateFin(new GregorianCalendar(2025, Calendar.JANUARY, 12).getTime())
                .build();

//        Carte carte1 = new Carte();
//        carte1.setCode("1234");
//        carte1.setEtudiant(etudiant);

        //etudiant.setCarte(carte);

        em.getTransaction().begin();
        //em.persist(etudiant);
        em.persist(carte);

        //Affichage etudiant et carte
        Carte carte1 = em.find(Carte.class, "1234");
        Etudiant etudiant1 = carte1.getEtudiant();

//        Etudiant etudiant2 = em.find(Etudiant.class, 1);
//        Carte carte2 = etudiant2.getCarte();

        System.out.println(carte1+"/n"+etudiant1);
//        System.out.println(carte2+"/n"+etudiant2);
        Personne Moh = Personne.builder()
                        .nom("Mouhamed")
                                .adresse("Dkr")
                                        .prenom("Faye")
                                                .dateNaissance(LocalDate.of(2003, 12, 4)).build();
        em.persist(Moh);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
