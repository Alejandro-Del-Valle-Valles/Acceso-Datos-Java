package delvalle.valles.alejandro.examen2.core.dto;

import java.time.LocalDate;

public class ClienteDTO {

    private String nombre;
    private LocalDate fechaNacimiento;
    private Integer idCarnet;

    public ClienteDTO(String nombre, LocalDate fechaNacimiento, Integer idCarnet) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.idCarnet = idCarnet;
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

    public Integer getIdCarnet() {
        return idCarnet;
    }

    public void setIdCarnet(Integer idCarnet) {
        this.idCarnet = idCarnet;
    }
}
