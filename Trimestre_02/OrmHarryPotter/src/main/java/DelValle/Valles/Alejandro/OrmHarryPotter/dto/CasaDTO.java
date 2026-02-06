package DelValle.Valles.Alejandro.OrmHarryPotter.dto;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CasaDTO {

    @NotBlank
    @NotNull
    private String nombre;

    @NotBlank
    @NotNull
    private String fundador;

    @NotBlank
    private String escudo_imagen;

    @NotNull
    private List<String> personajes;

    public CasaDTO() {}

    public CasaDTO(String nombre, String fundador, String escudo_imagen, List<String> personajes) {
        this.nombre = nombre;
        this.fundador = fundador;
        this.escudo_imagen = escudo_imagen;
        this.personajes = personajes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFundador() {
        return fundador;
    }

    public void setFundador(String fundador) {
        this.fundador = fundador;
    }

    public String getEscudo_imagen() {
        return escudo_imagen;
    }

    public void setEscudo_imagen(String escudo_imagen) {
        this.escudo_imagen = escudo_imagen;
    }

    public List<String> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<String> personajes) {
        this.personajes = personajes;
    }

    public void addPersonaje(Personaje personaje) {
        this.personajes.add(personaje.getNombre());
    }

    public void addPersonaje(String nombre) {
        this.personajes.add(nombre);
    }
}
