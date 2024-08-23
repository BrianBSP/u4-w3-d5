package brianpelinku.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "elemento")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Elemento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codice_isbn")
    protected long codiceISBN;
    protected String titolo;
    @Column(name = "anno_pubblicazione")
    protected int annoPubblicazione;
    @Column(name = "numero_pagine")
    protected int numPagine;


    // costruttori
    public Elemento() {
    }

    public Elemento(String titolo, int annoPubblicazione, int numPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numPagine = numPagine;
    }

    // getter e setter

    public long getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumPagine() {
        return numPagine;
    }

    public void setNumPagine(int numPagine) {
        this.numPagine = numPagine;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                '}';
    }
}
