package DelValle.Valles.Alejandro.OrmHarryPotter.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Varita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal longitud;

    @Column(nullable = false, length = 150)
    private String madera;

    @Column(nullable = false, length = 150)
    private String nucleo;

    @Column(nullable = false)
    private boolean rota;

    @OneToOne
    @JoinColumn(name = "personaje_id", nullable = true)
    private @Valid Personaje personaje;

    public Varita() {
    }

    public Varita(BigDecimal longitud, String madera, String nucleo, boolean rota, Personaje personaje) {
        this.longitud = longitud;
        this.madera = madera;
        this.nucleo = nucleo;
        this.rota = rota;
        this.personaje = personaje;
    }

    public Varita(int id, BigDecimal longitud, String madera, String nucleo, boolean rota, Personaje personaje) {
        this(longitud, madera, nucleo, rota, personaje);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public String getMadera() {
        return madera;
    }

    public void setMadera(String madera) {
        this.madera = madera;
    }

    public String getNucleo() {
        return nucleo;
    }

    public void setNucleo(String nucleo) {
        this.nucleo = nucleo;
    }

    public boolean isRota() {
        return rota;
    }

    public void setRota(boolean rota) {
        this.rota = rota;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Varita varita = (Varita) o;
        return getId() == varita.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
