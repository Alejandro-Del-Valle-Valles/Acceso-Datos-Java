package DelValle.Valles.Alejandro.OrmHarryPotter.dto;

import DelValle.Valles.Alejandro.OrmHarryPotter.enums.TipoHechizo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CrearHechizoDTO {

    @NotBlank
    @NotNull
    private String nombre;

    @NotBlank
    @NotNull
    private String descripcion;

    @NotNull
    private TipoHechizo tipo;

    public CrearHechizoDTO() {}

    public CrearHechizoDTO(String nombre, String descripcion, TipoHechizo tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoHechizo getTipo() {
        return tipo;
    }

    public void setTipo(TipoHechizo tipo) {
        this.tipo = tipo;
    }
}
