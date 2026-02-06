package DelValle.Valles.Alejandro.OrmHarryPotter.dto;

import DelValle.Valles.Alejandro.OrmHarryPotter.enums.TipoSangre;
import jakarta.validation.Valid;

import java.time.LocalDate;

public class CrearPersonajeVaritaDTO extends CrearPersonajeDTO {

    private CrearVaritaDTO crearVaritaDTO;

    public CrearPersonajeVaritaDTO() {}

    public CrearPersonajeVaritaDTO(CrearVaritaDTO crearVaritaDTO) {
        this.crearVaritaDTO = crearVaritaDTO;
    }

    public CrearPersonajeVaritaDTO(String nombre, LocalDate fechaNacimiento, TipoSangre sangre, String nombreCasa,
                                   CrearVaritaDTO crearVaritaDTO) {
        super(nombre, fechaNacimiento, sangre, nombreCasa);
        this.crearVaritaDTO = crearVaritaDTO;
    }

    public CrearVaritaDTO getCrearVaritaDTO() {
        return crearVaritaDTO;
    }

    public void setCrearVaritaDTO(CrearVaritaDTO crearVaritaDTO) {
        this.crearVaritaDTO = crearVaritaDTO;
    }
}
