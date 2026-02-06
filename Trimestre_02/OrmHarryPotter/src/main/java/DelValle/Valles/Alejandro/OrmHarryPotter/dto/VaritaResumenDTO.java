package DelValle.Valles.Alejandro.OrmHarryPotter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Objects;

public class VaritaResumenDTO {

    @Positive
    private Integer id;

    @NotBlank
    private String materiales;

    @Positive
    private BigDecimal longitud;

    @NotNull
    private boolean rota;

    private String personaje;

    public VaritaResumenDTO() {
    }

    public VaritaResumenDTO(Integer id, String materiales, BigDecimal longitud, boolean rota, String personaje) {
        this.id = id;
        this.materiales = materiales;
        this.longitud = longitud;
        this.rota = rota;
        this.personaje = personaje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public boolean isRota() {
        return rota;
    }

    public void setRota(boolean rota) {
        this.rota = rota;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VaritaResumenDTO that = (VaritaResumenDTO) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
