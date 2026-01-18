package com.alejandro.delvalle.valles.pracaticaexamen.core.repository;

import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Instituto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitutoRepository extends JpaRepository<Instituto, Integer> {

    Instituto findByNombreIgnoreCaseAndUbicacionIgnoreCase(String nombre, String ubicacion);
    List<Instituto> findByUbicacionContainingIgnoreCase(String ubicacion);

}
