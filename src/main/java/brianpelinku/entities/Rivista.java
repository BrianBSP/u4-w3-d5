package brianpelinku.entities;

import brianpelinku.enums.Periodicita;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "riviste")
public class Rivista extends Elemento {
    private Periodicita periodicita;

    // costruttori
    public Rivista() {
    }

    public Rivista(String titolo, int annoPubblicazione, int numPagine, Periodicita periodicita) {
        super(titolo, annoPubblicazione, numPagine);
        this.periodicita = periodicita;
    }

    // getter e setter
    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
