package DelValle.Valles.Alejandro.OrmHarryPotter.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(length = 50, nullable = true)
    private String escudo_imagen;

    @Column(nullable = false, length = 85)
    private String fundador;

    @Column(nullable = false, unique = true, length = 85)
    private String nombre;

    @OneToMany(mappedBy = "casa")
    private List<Personaje> personajes;

    public Casa() {
    }

    public Casa(int id, String escudo_imagen, String fundador, String nombre, List<Personaje> personajes) {
        this.id = id;
        this.escudo_imagen = escudo_imagen;
        this.fundador = fundador;
        this.nombre = nombre;
        this.personajes = personajes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEscudo_imagen() {
        return escudo_imagen;
    }

    public void setEscudo_imagen(String escudo_imagen) {
        this.escudo_imagen = escudo_imagen;
    }

    public String getFundador() {
        return fundador;
    }

    public void setFundador(String fundador) {
        this.fundador = fundador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Casa casa = (Casa) o;
        return getId() == casa.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
