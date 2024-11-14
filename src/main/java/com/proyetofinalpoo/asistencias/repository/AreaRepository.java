package com.proyetofinalpoo.asistencias.repository;

import com.proyetofinalpoo.asistencias.entities.Area;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    
    @Query(value = "SELECT t FROM Area t WHERE t.idEmpresa = ?1")
    public List<Area> listarAreasPorEmpresa(Long idEmpresa);
}
