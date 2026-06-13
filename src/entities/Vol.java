package entities;

import javax.persistence.*;

@Entity
@Table(name = "vol")
public class Vol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numero_vol")
    private String numeroVol;

    @Column(name = "destination")
    private String destination;

    @Column(name = "compagnie")
    private String compagnie;

    @Column(name = "type_vol")
    private String typeVol;

    @Column(name = "places_disponibles")
    private int placesDisponibles;

    @Column(name = "statut")
    private boolean statut;

    // Constructeurs
    public Vol() {}

    public Vol(String numeroVol, String destination, String compagnie, 
               String typeVol, int placesDisponibles, boolean statut) {
        this.numeroVol = numeroVol;
        this.destination = destination;
        this.compagnie = compagnie;
        this.typeVol = typeVol;
        this.placesDisponibles = placesDisponibles;
        this.statut = statut;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNumeroVol() { return numeroVol; }
    public void setNumeroVol(String numeroVol) { this.numeroVol = numeroVol; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getCompagnie() { return compagnie; }
    public void setCompagnie(String compagnie) { this.compagnie = compagnie; }

    public String getTypeVol() { return typeVol; }
    public void setTypeVol(String typeVol) { this.typeVol = typeVol; }

    public int getPlacesDisponibles() { return placesDisponibles; }
    public void setPlacesDisponibles(int placesDisponibles) { this.placesDisponibles = placesDisponibles; }

    public boolean isStatut() { return statut; }
    public void setStatut(boolean statut) { this.statut = statut; }
}