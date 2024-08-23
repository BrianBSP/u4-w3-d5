package brianpelinku.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_tessera", nullable = false, unique = true)
    private long nTessera;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cognome", nullable = false)
    private String cognome;
    @Column(name = "data_nascita", nullable = false)
    private LocalDate dataNascita;

    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti;

    // costruttori
    public Utente() {
    }

    public Utente(long nTessera, String nome, String cognome, LocalDate dataNascita) {
        this.nTessera = nTessera;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    // getter e setter
    public long getnTessera() {
        return nTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nTessera=" + nTessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }
}
