package brianpelinku.entities;

import brianpelinku.enums.GenereLibro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "libri")
@NamedQuery(name = "get_by_author", query = "SELECT l FROM Libro l WHERE l.autore=:autore")
@NamedQuery(name = "get_by_title", query = "SELECT l FROM Libro l WHERE l.titolo=:titolo")
public class Libro extends Elemento {
    @Column(name = "autore", nullable = false)
    private String autore;
    @Column(name = "genere_libro", nullable = false)
    private GenereLibro genereLibro;

    // costruttori
    public Libro() {
    }

    public Libro(String titolo, int annoPubblicazione, int numPagine, String autore, GenereLibro genereLibro) {
        super(titolo, annoPubblicazione, numPagine);
        this.autore = autore;
        this.genereLibro = genereLibro;
    }

    // getter e setter
    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public GenereLibro getGenereLibro() {
        return genereLibro;
    }

    public void setGenereLibro(GenereLibro genereLibro) {
        this.genereLibro = genereLibro;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genereLibro=" + genereLibro +
                ", codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numPagine=" + numPagine +
                '}';
    }

}
