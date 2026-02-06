package delvalle.valles.alejandro.examen2.core.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 30)
    private String nombre;

    @NotNull
    @Past
    private LocalDate fechaNacimiento;

    @NotNull
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private @Valid Carnet carnet;

    @ManyToMany
    @JoinTable(
            name = "clientes_clases",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "clase_id")
    )
    private List<@Valid Clase> clase;

    public Cliente() {}

    public Cliente(String nombre, LocalDate fechaNacimiento, Carnet carnet, List<Clase> clase) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.carnet = carnet;
        this.clase = clase;
    }

    public Cliente(UUID id, String nombre, LocalDate fechaNacimiento, Carnet carnet, List<Clase> clase) {
        this(nombre, fechaNacimiento, carnet, clase);
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }

    public List<Clase> getClases() {
        return clase;
    }

    public void setClases(List<Clase> clases) {
        this.clase = clases;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
