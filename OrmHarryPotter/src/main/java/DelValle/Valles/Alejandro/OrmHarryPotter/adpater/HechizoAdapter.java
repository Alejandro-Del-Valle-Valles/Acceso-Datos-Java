package DelValle.Valles.Alejandro.OrmHarryPotter.adpater;

import DelValle.Valles.Alejandro.OrmHarryPotter.dto.HechizoDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Hechizo;

public class HechizoAdapter {

    public static HechizoDTO toDTO(Hechizo hechizo) {
        return new HechizoDTO(hechizo.getNombre(), hechizo.getDescripcion(), hechizo.getTipo());
    }
}
