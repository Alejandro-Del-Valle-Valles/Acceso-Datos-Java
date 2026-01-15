package DelValle.Valles.Alejandro.OrmHarryPotter.dto;

import DelValle.Valles.Alejandro.OrmHarryPotter.enums.TipoSangre;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class CrearPersonajeDTO {

    @NotBlank
    @Size(min = 5, max = 50, message = "El nombre debe tener entre 5 y 50 caracteres.")
    @NotNull
    private String nombre;

    @NotNull
    @Past
    private LocalDate fechaNacimiento;

    @NotNull
    private TipoSangre sangre;

    @NotBlank
    @NotNull
    private String nombreCasa;

    public CrearPersonajeDTO() {}

    public CrearPersonajeDTO(String nombre, LocalDate fechaNacimiento, TipoSangre sangre, String nombreCasa) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sangre = sangre;
        this.nombreCasa = nombreCasa;
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

    public TipoSangre getSangre() {
        return sangre;
    }

    public void setSangre(TipoSangre sangre) {
        this.sangre = sangre;
    }

    public String getNombreCasa() {
        return nombreCasa;
    }

    public void setNombreCasa(String nombreCasa) {
        this.nombreCasa = nombreCasa;
    }
}
