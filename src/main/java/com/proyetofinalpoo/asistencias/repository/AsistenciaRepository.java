package com.proyetofinalpoo.asistencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyetofinalpoo.asistencias.entities.Asistencia;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
}
