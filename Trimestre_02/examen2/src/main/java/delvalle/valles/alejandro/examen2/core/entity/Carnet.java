package delvalle.valles.alejandro.examen2.core.entity;

import delvalle.valles.alejandro.examen2.core.enums.TipoSuscripcion;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Entity
public class Carnet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoSuscripcion suscripcion;

    @NotNull
    @OneToOne
    @JoinColumn(name = "cliente_id", unique = true, nullable = false)
    private @Valid Cliente cliente;

    public Carnet() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoSuscripcion getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(TipoSuscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
