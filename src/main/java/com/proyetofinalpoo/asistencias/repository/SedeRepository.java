package com.proyetofinalpoo.asistencias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyetofinalpoo.asistencias.entities.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Long> {
    // Cuando se hacen consultas SQL con JPA lo que se usan son los nombres de las clases y las variable mapeadas en estas
    // El uso de alias es obligatorio en este tipo de consultas

    @Query(value = "SELECT t FROM Sede t WHERE t.nombre LIKE '%' || ?1 || '%'")
    public List<Sede> listarSedesPorNombre(String nombre);

}
