package brianpelinku.entities;

import brianpelinku.enums.GenereLibro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "libri")
public class Libro extends Elemento {
    private String autore;
    @Column(name = "genere_libro")
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
