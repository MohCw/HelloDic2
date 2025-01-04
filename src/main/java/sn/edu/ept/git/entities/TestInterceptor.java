package sn.edu.ept.git.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestInterceptor {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence
                .createEntityManagerFactory("dic2Pu");
        EntityManager em = emf.createEntityManager();

        Etudiant etudiant =  Etudiant.builder()
                .nom("Mohamed")
                .adresse("Lazaret").build();//Autres champs non obligatoires(nom, adresse, ...)

        Carte carte =  Carte.builder()
                .code("1234")
                .etudiant(etudiant)
                .dateDebut(new GregorianCalendar(2025, Calendar.MARCH, 3).getTime())
                .dateFin(new GregorianCalendar(2025, Calendar.JANUARY, 12).getTime())
                .build();

        em.getTransaction().begin();
        em.persist(etudiant);
        em.persist(carte);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
