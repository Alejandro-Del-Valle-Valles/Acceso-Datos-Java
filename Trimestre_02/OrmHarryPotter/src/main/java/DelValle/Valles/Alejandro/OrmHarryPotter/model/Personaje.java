package DelValle.Valles.Alejandro.OrmHarryPotter.model;

import DelValle.Valles.Alejandro.OrmHarryPotter.enums.TipoSangre;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Past;

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
    @Past
    private LocalDate fechaNacimiento;

    @Column(nullable = false, length = 50, unique = true)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSangre sangre;

    @ManyToOne
    @JoinColumn(name = "casa_id")
    private @Valid Casa casa;

    @OneToOne(mappedBy = "personaje", cascade = CascadeType.ALL)
    private @Valid Varita varita;

    @ManyToMany
    @JoinTable(
            name = "personaje_hechizo",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "hechizo_id")
    )
    private List<@Valid Hechizo> hechizos;

    public Personaje() {
    }

    public Personaje(LocalDate fechaNacimiento, String nombre, TipoSangre sangre, Casa casa, Varita varita, List<Hechizo> hechizos) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.sangre = sangre;
        this.casa = casa;
        this.varita = varita;
        this.hechizos = hechizos;
    }

    public Personaje(Integer id, LocalDate fechaNacimiento, String nombre, TipoSangre sangre, Casa casa, Varita varita, List<Hechizo> hechizos) {
        this(fechaNacimiento, nombre, sangre, casa, varita, hechizos);
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

    public TipoSangre getSangre() {
        return sangre;
    }

    public void setSangre(TipoSangre sangre) {
        this.sangre = sangre;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Varita getVarita() {
        return varita;
    }

    public void setVarita(Varita varita) {
        this.varita = varita;
    }

    public void addVarita(Varita varita) {
        setVarita(varita);
        varita.setPersonaje(this);
    }

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
