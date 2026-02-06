package com.alejandro.delvalle.valles.pracaticaexamen.core.entity;

import com.alejandro.delvalle.valles.pracaticaexamen.core.enums.Colores;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Carnet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El color no puede ser nulo.")
    private Colores color;

    @OneToOne
    @JoinColumn(name = "alumno_id", unique = true, nullable = false)
    private Alumno alumno;

    public Carnet() {}

    public Carnet(Colores color, Alumno alumno) {}

    public Carnet(UUID id, Colores color, Alumno alumno) {
        this(color, alumno);
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Carnet carnet = (Carnet) o;
        return Objects.equals(id, carnet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
