package DelValle.Valles.Alejandro.OrmHarryPotter.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Hechizo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String descripcion;

    @Column(unique = true, length = 35, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tipo;

    @ManyToMany(mappedBy = "hechizos")
    private List<Personaje> personajes;

    public Hechizo() {
    }

    public Hechizo(long id, String descripcion, String nombre, String tipo, List<Personaje> personajes) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.tipo = tipo;
        this.personajes = personajes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        Hechizo hechizo = (Hechizo) o;
        return getId() == hechizo.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
