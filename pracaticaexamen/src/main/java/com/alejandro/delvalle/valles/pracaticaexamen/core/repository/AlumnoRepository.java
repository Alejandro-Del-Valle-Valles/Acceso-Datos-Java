package com.alejandro.delvalle.valles.pracaticaexamen.core.repository;

import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {
}
