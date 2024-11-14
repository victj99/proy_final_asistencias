package com.proyetofinalpoo.asistencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyetofinalpoo.asistencias.entities.Movimiento;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
}
