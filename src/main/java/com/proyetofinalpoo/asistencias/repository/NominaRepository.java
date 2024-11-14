package com.proyetofinalpoo.asistencias.repository;

import com.proyetofinalpoo.asistencias.entities.Nomina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NominaRepository extends JpaRepository<Nomina, Long> {
}
