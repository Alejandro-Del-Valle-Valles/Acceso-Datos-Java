package com.alejandro.delvalle.valles.pracaticaexamen.core.repository;

import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Instituto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutoRepository extends JpaRepository<Instituto, Integer> {

    Instituto findByNombreAndUbicacion(String nombre, String ubicacion);
}
