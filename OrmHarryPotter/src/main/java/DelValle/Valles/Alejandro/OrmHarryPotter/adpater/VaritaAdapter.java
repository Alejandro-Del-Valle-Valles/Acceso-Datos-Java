package DelValle.Valles.Alejandro.OrmHarryPotter.adpater;

import DelValle.Valles.Alejandro.OrmHarryPotter.dto.VaritaDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.dto.VaritaMovilesDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.dto.VaritaResumenDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Varita;

import java.util.List;

public class VaritaAdapter {

    public static VaritaDTO toDTO(Varita varita) {
        Personaje personaje = varita.getPersonaje();
        return new VaritaDTO(varita.getMadera(), varita.getNucleo(), varita.getLongitud(),
                varita.isRota(), personaje == null ? null : personaje.getId(),
                personaje == null ? null : personaje.getNombre());
    }

    public static List<VaritaDTO> toDTO(List<Varita> varitas) {
        return varitas.stream()
                .map(VaritaAdapter::toDTO)
                .toList();
    }

    public static VaritaMovilesDTO toMovilesDTO(Varita varita) {
        Personaje personaje = varita.getPersonaje();
        return new VaritaMovilesDTO(varita.getId(), varita.getMadera(), varita.getNucleo(), varita.getLongitud(),
                varita.isRota(), personaje == null ? null : personaje.getId(),
                personaje == null ? null : personaje.getNombre());
    }

    public static List<VaritaMovilesDTO> toMovilesDTO(List<Varita> varitas) {
        return varitas.stream()
                .map(VaritaAdapter::toMovilesDTO)
                .toList();
    }

    public static VaritaResumenDTO toResumenDTO(Varita varita) {
        Personaje personaje = varita.getPersonaje();
        return new VaritaResumenDTO(
                varita.getId(), String.format("%s. %s", varita.getMadera(), varita.getNucleo()),
                varita.getLongitud(), varita.isRota(),
                personaje == null ? null : personaje.getNombre()
        );
    }

    public static List<VaritaResumenDTO> toResumenDTO(List<Varita> varitas) {
        return varitas.stream()
                .map(VaritaAdapter::toResumenDTO)
                .toList();
    }
}
