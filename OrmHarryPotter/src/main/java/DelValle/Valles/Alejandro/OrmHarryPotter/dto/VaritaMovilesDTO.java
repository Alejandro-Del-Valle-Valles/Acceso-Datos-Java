package DelValle.Valles.Alejandro.OrmHarryPotter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Objects;

public class VaritaMovilesDTO {

    @Positive
    @NotNull
    private Integer id;

    @NotBlank
    private String madera;

    @Positive
    private BigDecimal longitud;

    @NotBlank
    private String nucleo;

    @NotNull
    private boolean rota;

    private Integer idPersonaje;
    private String personaje;

    public VaritaMovilesDTO() {
    }

    public VaritaMovilesDTO(Integer id, String madera, String nucleo, BigDecimal longitud,
                            boolean rota, Integer idPersonaje, String personaje) {
        this.id = id;
        this.madera = madera;
        this.longitud = longitud;
        this.nucleo = nucleo;
        this.rota = rota;
        this.idPersonaje = idPersonaje;
        setPersonaje(personaje);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(Integer idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje == null || personaje.isBlank() ? "Sin Asignar" : personaje.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VaritaMovilesDTO that = (VaritaMovilesDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
