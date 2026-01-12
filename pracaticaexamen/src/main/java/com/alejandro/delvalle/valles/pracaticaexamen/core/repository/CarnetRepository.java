package com.alejandro.delvalle.valles.pracaticaexamen.core.repository;

import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarnetRepository extends JpaRepository<Asignatura, UUID> {
}
