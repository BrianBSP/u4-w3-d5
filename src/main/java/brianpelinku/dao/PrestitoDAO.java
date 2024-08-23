package brianpelinku.dao;

import brianpelinku.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PrestitoDAO {
    private EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    // salva prestito
    public void save(Prestito prestito) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(prestito);
            t.commit();
            System.out.println("Prestito salvato correttamente!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ricercaElementiInPrestitoUtente
    public List<Prestito> ricercaElementiInPrestitoUtente(long nTessera) {
        TypedQuery<Prestito> query = em.createNamedQuery("ricerca_elementi_in_prestito_utente", Prestito.class);
        query.setParameter("nTessera", nTessera);
        return query.getResultList();
    }

    // ricercaPrestitiScaduti
    public List<Prestito> ricercaPrestitiScaduti() {
        return em.createNamedQuery("ricerca_prestiti_scaduti", Prestito.class).getResultList();
    }
}
