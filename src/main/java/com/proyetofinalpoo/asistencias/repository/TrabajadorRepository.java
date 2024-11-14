package com.proyetofinalpoo.asistencias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyetofinalpoo.asistencias.entities.Trabajador;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    // Cuando se hacen consultas SQL con JPA lo que se usan son los nombres de las clases y las variable mapeadas en estas
    // El uso de alias es obligatorio en este tipo de consultas

    @Query(value = "SELECT t FROM Trabajador t WHERE t.idNomina = ?1 "
            + "AND t.idArea = ?2 "
            + "AND (t.nombre LIKE '%' || ?3 || '%' OR t.apellido LIKE '%' || ?3 || '%' OR t.codigoInterno LIKE '%' || ?3 || '%')")
    public List<Trabajador> listarTrabajadoresPorNominaAreaNombres(Long idNomima, Long idArea, String nombre);

}
