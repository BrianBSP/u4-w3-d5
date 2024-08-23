package brianpelinku.dao;

import brianpelinku.entities.Utente;
import brianpelinku.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {
    private EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    // salva utente
    public void save(Utente utente) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(utente);
            t.commit();
            System.out.println("Utente " + utente.getCognome() + " salvato correttamente!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // elimina utente
    public void delete(long nTessera) {
        try {
            EntityTransaction t = em.getTransaction();
            Utente found = em.find(Utente.class, nTessera);
            if (found != null) {
                t.begin();
                em.remove(nTessera);
                t.commit();
                System.out.println("Utente Eliminato!");
            } else {
                System.out.println("Utente non trovato");
            }

        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


}
