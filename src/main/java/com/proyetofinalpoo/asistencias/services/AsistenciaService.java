package com.proyetofinalpoo.asistencias.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyetofinalpoo.asistencias.entities.Asistencia;
import com.proyetofinalpoo.asistencias.entities.Movimiento;
import com.proyetofinalpoo.asistencias.repository.AsistenciaRepository;
import com.proyetofinalpoo.asistencias.repository.MovimientoRepository;
import com.proyetofinalpoo.asistencias.utils.Constantes;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
@Transactional(rollbackFor = Exception.class)
public class AsistenciaService implements CrudBase<Asistencia> {

    @Autowired
    private AsistenciaRepository asistenciaRepository;
    
    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public List<Asistencia> listarTodosDatos() {
        return asistenciaRepository.findAll();
    }

    @Override
    public void registrarDatos(Asistencia entity) {
        entity.setFecha(LocalDate.now());
        entity.setHoraEntrada(LocalTime.now());
        entity.setFechaCreacion(LocalDateTime.now());
        entity.setEstado(Constantes.ESTADO_ACTIVO);
        
        entity = asistenciaRepository.save(entity);
        
        var movimiento = new Movimiento(entity.getHoraEntrada(), entity.getIdAsistencia());
        movimientoRepository.save(movimiento);
    }

    @Override
    public void actualizarDatos(Asistencia entity) {
        Asistencia asistenciaExistente = asistenciaRepository.findById(entity.getIdAsistencia()).get();

        asistenciaExistente.setFechaModificacion(LocalDateTime.now());

        asistenciaRepository.save(asistenciaExistente);
    }

    @Override
    public Asistencia obtenerPorId(Long id) {
        return asistenciaRepository.findById(id).get();
    }
}
