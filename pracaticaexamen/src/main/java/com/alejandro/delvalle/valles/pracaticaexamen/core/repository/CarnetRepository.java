package com.alejandro.delvalle.valles.pracaticaexamen.core.repository;

import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Carnet;
import com.alejandro.delvalle.valles.pracaticaexamen.core.enums.Colores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarnetRepository extends JpaRepository<Carnet, UUID> {

    List<Carnet> findByColor(Colores color);
    Carnet findByAlumnoId(int id);
}
