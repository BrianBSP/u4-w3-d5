package brianpelinku.dao;

import brianpelinku.entities.Elemento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ElementoDAO {
    private EntityManager em;

    public ElementoDAO(EntityManager em) {
        this.em = em;
    }

    // save
    public void save(Elemento elemento) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(elemento);
            transaction.commit();
            System.out.println("Elemento " + elemento.getTitolo() + " salvato nel catalogo!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
