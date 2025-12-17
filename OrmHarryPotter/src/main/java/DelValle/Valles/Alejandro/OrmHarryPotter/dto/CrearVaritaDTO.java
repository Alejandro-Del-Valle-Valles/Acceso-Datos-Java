package DelValle.Valles.Alejandro.OrmHarryPotter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public class CrearVaritaDTO {

    @NotBlank
    @Length(min = 5)
    private String madera;

    @NotBlank
    @Length(min = 5)
    private String nucleo;

    @Positive
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
