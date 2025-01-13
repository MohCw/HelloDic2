package sn.edu.ept.git.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
                .build();//Autres champs non obligatoires(nom, adresse, ...)

        Carte carte =  Carte.builder()
                .code("1234")
                .etudiant(etudiant)
                .dateDebut(new GregorianCalendar(2025, Calendar.MARCH, 3).getTime())
                .dateFin(new GregorianCalendar(2025, Calendar.JANUARY, 12).getTime())
                .build();

        Carte carte1 = new Carte();
        carte1.setCode("1234");
        carte1.setEtudiant(etudiant);

        //etudiant.setCarte(carte);

        em.getTransaction().begin();
        em.persist(etudiant);
        em.persist(carte);
        em.getTransaction().commit();

        //Affichage etudiant et carte
        //Carte carte1 = em.find(Carte.class, "1234");
        //Etudiant etudiant1 = carte1.getEtudiant();

        Etudiant etudiant2 = em.find(Etudiant.class, 1);
        Carte carte2 = etudiant2.getCarte();

//        System.out.println(carte1+"/n"+etudiant1);
        System.out.println(carte2+"/n"+etudiant2);



        em.close();
        emf.close();
    }
}
