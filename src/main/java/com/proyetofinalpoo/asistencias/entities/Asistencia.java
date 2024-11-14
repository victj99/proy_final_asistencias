package com.proyetofinalpoo.asistencias.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Asistencia extends Auditoria {

    @Id
    @Column(name = "ID_ASISTENCIA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsistencia;

    @Column(name = "ID_SEDE")
    private Long idSede;

    @Column(name = "ID_TRABAJADOR")
    private Long idTrabajador;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "HORA_ENTRADA")
    private LocalTime horaEntrada;

    @Column(name = "HORA_SALIDA")
    private LocalTime horaSalida;

    @Column(name = "COMENTARIO")
    private String comentario;

    // MAPEO DE FOREIGN KEYS
    @ManyToOne
    @JoinColumn(name = "ID_SEDE", referencedColumnName = "ID_SEDE", insertable = false, updatable = false)
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "ID_TRABAJADOR", referencedColumnName = "ID_TRABAJADOR", insertable = false, updatable = false)
    private Trabajador trabajador;

    public Asistencia() {
    }

    public Asistencia(Long idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Asistencia(String estado, Long idAsistencia, Long idSede, Long idTrabajador, LocalDate fecha,
            LocalTime horaEntrada, LocalTime horaSalida, String comentario) {
        super(estado);
        this.idAsistencia = idAsistencia;
        this.idSede = idSede;
        this.idTrabajador = idTrabajador;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.comentario = comentario;
    }

    public String getNombresTrabajador() {
        if (trabajador == null) {
            return "";
        }

        return trabajador.getNombre() + " " + trabajador.getApellido();
    }

    public Float obtenerHorasTrabajadas() {
        var duration = Duration.between(horaEntrada, horaSalida);
        return Float.valueOf(duration.toHoursPart() + "." + duration.toMinutesPart());
    }
}
