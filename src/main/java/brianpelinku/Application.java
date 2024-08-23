package brianpelinku;

import brianpelinku.dao.ElementoDAO;
import brianpelinku.dao.PrestitoDAO;
import brianpelinku.dao.UtenteDAO;
import brianpelinku.entities.Libro;
import brianpelinku.entities.Rivista;
import brianpelinku.entities.Utente;
import brianpelinku.enums.GenereLibro;
import brianpelinku.enums.Periodicita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4_w3_d5");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        ElementoDAO ed = new ElementoDAO(em);
        PrestitoDAO pd = new PrestitoDAO(em);
        UtenteDAO ud = new UtenteDAO(em);

        Utente utente1 = new Utente("aldo", "baglio", LocalDate.of(2000, 8, 9));
        Utente utente2 = new Utente("giovanni", "storti", LocalDate.of(2001, 4, 5));
        Utente utente3 = new Utente("giacomo", "poretti", LocalDate.of(2000, 2, 20));

        // inseriti utenti

        /*ud.save(utente1);
        ud.save(utente2);
        ud.save(utente3);*/

        Libro libro1 = new Libro("Il Signore degli Anelli", 2002, 290, "Pinco J.Pallino", GenereLibro.THRILLER);
        Libro libro2 = new Libro("Harry Potter", 2001, 100, "Pinco J.Pallino", GenereLibro.GIALLO);
        Libro libro3 = new Libro("L'avvocato", 2000, 500, "Pinco J.Pallino", GenereLibro.THRILLER);
        Libro libro4 = new Libro("La ragazza del treno", 2010, 340, "Pinco J.Pallino", GenereLibro.ROMANZO);
        Libro libro5 = new Libro("Superman", 2002, 200, "Pinco J.Pallino", GenereLibro.ROMANZO);
        Rivista rivista1 = new Rivista("chi", 2020, 10, Periodicita.MENSILE);
        Rivista rivista2 = new Rivista("sorrisi e canzoni", 2020, 10, Periodicita.MENSILE);
        Rivista rivista3 = new Rivista("forbes", 2020, 10, Periodicita.MENSILE);
        Rivista rivista4 = new Rivista("tv2000", 2020, 10, Periodicita.MENSILE);

        // inseriti elementi

        /*ed.save(libro1);
        ed.save(libro2);
        ed.save(libro3);
        ed.save(libro4);
        ed.save(libro5);
        ed.save(rivista1);
        ed.save(rivista2);
        ed.save(rivista3);
        ed.save(rivista4);*/


        System.out.println("Hello World!");

        em.close();
        emf.close();
    }
}
