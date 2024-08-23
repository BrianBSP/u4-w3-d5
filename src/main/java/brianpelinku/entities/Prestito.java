package brianpelinku.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "prestiti")
@NamedQuery(name = "ricerca_elementi_in_prestito_utente", query = "SELECT p FROM Prestito p WHERE p.utente.nTessera=:nTessera AND p.dataRestituzione IS NULL")
@NamedQuery(name = "ricerca_prestiti_scaduti", query = "SELECT p FROM Prestito P WHERE p.dataFinePrestito < :oggi AND p.restituzione IS NULL")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;
    @Column(name = "data_fine_prestito")
    private LocalDate dataFinePrestito;
    @Column(name = "data_restituzione")
    private LocalDate dataRestituzione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToMany
    @JoinTable(name = "prestiti_elementi",
            joinColumns = @JoinColumn(name = "prestito_id"),
            inverseJoinColumns = @JoinColumn(name = "elemento_id"))
    private List<Elemento> listaElementiPrestati;

    // costruttori
    public Prestito() {
    }

    public Prestito(LocalDate dataInizioPrestito, LocalDate dataFinePrestito, LocalDate dataRestituzione, Utente utente) {
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataFinePrestito = dataFinePrestito;
        this.dataRestituzione = dataRestituzione;
        this.utente = utente;

    }

    // getter e setter
    public long getId() {
        return id;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataFinePrestito() {
        return dataFinePrestito;
    }

    public void setDataFinePrestito(LocalDate dataFinePrestito) {
        this.dataFinePrestito = dataFinePrestito;
    }

    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<Elemento> getListaElementiPrestati() {
        return listaElementiPrestati;
    }

    public void setListaElementiPrestati(List<Elemento> listaElementiPrestati) {
        this.listaElementiPrestati = listaElementiPrestati;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataFinePrestito=" + dataFinePrestito +
                ", dataRestituzione=" + dataRestituzione +
                ", utente=" + utente +
                ", listaElementiPrestati=" + listaElementiPrestati +
                '}';
    }
}
