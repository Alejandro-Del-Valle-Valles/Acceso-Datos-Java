package com.alejandro.delvalle.valles.pracaticaexamen.core.repository;

import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Instituto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutoRepsoitory extends JpaRepository<Instituto, Integer> {
}
