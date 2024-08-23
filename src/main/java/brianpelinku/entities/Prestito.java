package brianpelinku.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;
    @Column(name = "data_fine_prestito")
    private LocalDate dataFinePrestito;
    @Column(name = "data_restituzione")
    private LocalDate dataRestituzione;

    @ManyToMany
    @JoinTable(name = "prestiti_cataloghi", joinColumns = @JoinColumn(name = "prestito_id"), inverseJoinColumns = @JoinColumn(name = "elemento_id"))
    private List<Elemento> listaElementiPrestati;
}
