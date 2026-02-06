package DelValle.Valles.Alejandro.OrmHarryPotter.dto;

import DelValle.Valles.Alejandro.OrmHarryPotter.enums.TipoSangre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.Objects;

public class PersonajeDTO {

    @Positive
    private Integer id;

    @NotBlank
    private String nombre;

    @NotNull
    @PastOrPresent
    private LocalDate fechaNacimiento;

    @NotNull
    private TipoSangre sangre;

    @NotBlank
    private String nombreCasa;

    public PersonajeDTO() {}

    public PersonajeDTO(Integer id, String nombre, LocalDate fechaNacimiento, TipoSangre sangre, String nombreCasa) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sangre = sangre;
        this.nombreCasa = nombreCasa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonajeDTO that = (PersonajeDTO) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
