package DelValle.Valles.Alejandro.OrmHarryPotter.dto;

import jakarta.validation.constraints.NotBlank;

public class HechizoDTO {

    @NotBlank
    private String descripcion;

    @NotBlank
    private String nombre;

    @NotBlank
    private String tipo;

    public HechizoDTO() {
    }

    public HechizoDTO(String nombre, String descripcion, String tipo) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.tipo = tipo;
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
}
