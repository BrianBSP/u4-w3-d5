package brianpelinku.dao;

import brianpelinku.entities.Elemento;
import brianpelinku.entities.Libro;
import brianpelinku.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ElementoDAO {
    private EntityManager em;

    public ElementoDAO(EntityManager em) {
        this.em = em;
    }

    // salva elemento
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

    // elimina elemento
    public void delete(long id) {
        try {
            EntityTransaction transaction = em.getTransaction();
            Elemento found = em.find(Elemento.class, id);
            if (found != null) {
                transaction.begin();
                em.remove(id);
                transaction.commit();
                System.out.println("Elemento eliminato dal catalogo!");
            } else {
                System.out.println("Elemento non presente nel catalogo!");
            }
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // ricerca per isbn
    public Elemento getByISBN(long id) {
        return em.find(Elemento.class, id);
    }

    // ricerca per autore
    public List<Libro> getByAuthor(String autore) {
        TypedQuery<Libro> query = em.createNamedQuery("get_by_author", Libro.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

}
