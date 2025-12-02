package delvalle.valles.alejandro.AlumnosApiRest.model;

import java.time.LocalDate;
import java.util.Objects;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public class AlumnoDTO {

    @NotNull(message = "El nia no puede estar vacío")
    @Positive(message = "El nia debe ser mayor que 0")
    private int nia;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String surname;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    @PastOrPresent(message = "La fecha no puede ser superior a hoy.")
    private LocalDate bornDate;

    public AlumnoDTO() {}

    public AlumnoDTO(int nia, String name, String surname, LocalDate bornDate) {
        this.nia = nia;
        this.name = name;
        this.surname = surname;
        this.bornDate = bornDate;
    }

    public int getNia() {
        return nia;
    }

    public void setNia(int nia) {
        this.nia = nia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoDTO alumnoDTO = (AlumnoDTO) o;
        return getNia() == alumnoDTO.getNia();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNia());
    }
}
