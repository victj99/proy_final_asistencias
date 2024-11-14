package com.proyetofinalpoo.asistencias.entities;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Movimiento {

    @Id
    @Column(name = "ID_MOVIMIENTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimiento;

    @Column(name = "HORA")
    private LocalTime hora;

    @Column(name = "ID_ASISTENCIA")
    private Long idAsistencia;
    
    public Movimiento() {
    }
    
    public Movimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Movimiento(LocalTime hora, Long idAsistencia) {
        this.hora = hora;
        this.idAsistencia = idAsistencia;
    }

}
