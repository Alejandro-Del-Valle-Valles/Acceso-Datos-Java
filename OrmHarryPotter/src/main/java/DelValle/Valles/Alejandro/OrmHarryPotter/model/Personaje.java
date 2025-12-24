package DelValle.Valles.Alejandro.OrmHarryPotter.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(nullable = false, length = 50, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String sangre;

    @ManyToOne
    @JoinColumn(name = "casa_id")
    private Casa casa;

    @OneToMany(mappedBy = "personaje")
    private List<Varita> varitas;

    @ManyToMany
    @JoinTable(
            name = "personaje_hechizo",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "hechizo_id")
    )
    private List<Hechizo> hechizos;

    public Personaje() {
    }

    public Personaje(LocalDate fechaNacimiento, String nombre, String sangre, Casa casa, List<Varita> varitas, List<Hechizo> hechizos) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.sangre = sangre;
        this.casa = casa;
        this.varitas = varitas;
        this.hechizos = hechizos;
    }

    public Personaje(Integer id, LocalDate fechaNacimiento, String nombre, String sangre, Casa casa, List<Varita> varitas, List<Hechizo> hechizos) {
        this(fechaNacimiento, nombre, sangre, casa, varitas, hechizos);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSangre() {
        return sangre;
    }

    public void setSangre(String sangre) {
        this.sangre = sangre;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public List<Varita> getVaritas() {
        return varitas;
    }

    public void setVaritas(List<Varita> varitas) {
        this.varitas = varitas;
    }

    public void addVarita(Varita varita) {
        this.varitas.add(varita);
        varita.setPersonaje(this);
    }
    public void deleteVarita(Varita varita) {this.varitas.remove(varita); }

    public List<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Personaje personaje = (Personaje) o;
        return getId().equals(personaje.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
