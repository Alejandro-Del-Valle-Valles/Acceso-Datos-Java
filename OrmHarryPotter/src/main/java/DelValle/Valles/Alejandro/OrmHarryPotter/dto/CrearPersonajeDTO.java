package DelValle.Valles.Alejandro.OrmHarryPotter.dto;

import DelValle.Valles.Alejandro.OrmHarryPotter.enums.TipoSangre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class CrearPersonajeDTO {

    @NotBlank
    private String nombre;

    @NotNull
    @PastOrPresent
    private LocalDate fechaNacimiento;

    private TipoSangre sangre;

    @NotBlank
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
