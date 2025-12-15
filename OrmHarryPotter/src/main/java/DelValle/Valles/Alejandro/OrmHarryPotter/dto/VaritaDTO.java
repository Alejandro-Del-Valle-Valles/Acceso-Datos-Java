package DelValle.Valles.Alejandro.OrmHarryPotter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Objects;

public class VaritaDTO {
    @NotBlank
    private String madera;

    @Positive
    private BigDecimal longitud;

    @NotBlank
    private String nucleo;

    @NotNull
    private boolean rota;

    private int idPersonaje;
    private String personaje;

    public VaritaDTO() {
    }

    public VaritaDTO(String madera, BigDecimal longitud, String nucleo, boolean rota, int idPersonaje, String personaje) {
        this.madera = madera;
        this.longitud = longitud;
        this.nucleo = nucleo;
        this.rota = rota;
        this.idPersonaje = idPersonaje;
        setPersonaje(personaje);
    }

    public String getMadera() {
        return madera;
    }

    public void setMadera(String madera) {
        this.madera = madera;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public String getNucleo() {
        return nucleo;
    }

    public void setNucleo(String nucleo) {
        this.nucleo = nucleo;
    }

    public boolean isRota() {
        return rota;
    }

    public void setRota(boolean rota) {
        this.rota = rota;
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje.isBlank() ? "Sin Asignar" : personaje.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VaritaDTO varitaDTO = (VaritaDTO) o;
        return rota == varitaDTO.rota && idPersonaje == varitaDTO.idPersonaje && Objects.equals(madera, varitaDTO.madera) && Objects.equals(longitud, varitaDTO.longitud) && Objects.equals(nucleo, varitaDTO.nucleo) && Objects.equals(personaje, varitaDTO.personaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(madera, longitud, nucleo, rota, idPersonaje, personaje);
    }
}
