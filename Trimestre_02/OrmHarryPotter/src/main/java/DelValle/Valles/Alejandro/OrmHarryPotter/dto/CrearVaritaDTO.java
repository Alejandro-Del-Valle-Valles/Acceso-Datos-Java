package DelValle.Valles.Alejandro.OrmHarryPotter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class CrearVaritaDTO {

    @NotBlank
    @Size(min = 5, max = 150, message = "La informacion de la madera debe estar entre 5 y 150.")
    @NotNull
    private String madera;

    @NotBlank
    @Size(min = 5, max = 150, message = "La información del nucleo debe estar entre 5 y 150.")
    @NotNull
    private String nucleo;

    @Positive(message = "La longitud de la varita debe ser positiva")
    private BigDecimal longitud;

    public CrearVaritaDTO() {
    }

    public CrearVaritaDTO(String madera, String nucleo, BigDecimal longitud) {
        this.madera = madera;
        this.nucleo = nucleo;
        this.longitud = longitud;
    }

    public String getMadera() {
        return madera;
    }

    public void setMadera(String madera) {
        this.madera = madera;
    }

    public String getNucleo() {
        return nucleo;
    }

    public void setNucleo(String nucleo) {
        this.nucleo = nucleo;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }
}
