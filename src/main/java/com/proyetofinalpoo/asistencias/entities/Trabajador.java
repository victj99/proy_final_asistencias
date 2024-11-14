package com.proyetofinalpoo.asistencias.entities;

import com.proyetofinalpoo.asistencias.utils.LocalDateConverter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author victortinoco
 */
@Getter
@Setter
@Entity
public class Trabajador extends Persona {

    @Id
    @Column(name = "ID_TRABAJADOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrabajador;

    @Column(name = "CODIGO_INTERNO")
    private String codigoInterno;

    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;

    @Column(name = "SEXO")
    private String sexo;

    @Column(name = "FECHA_NACIMIENTO")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate fechaNacimiento;

    // Foraneos
    @Column(name = "ID_AREA")
    private Long idArea;

    @Column(name = "ID_NOMINA")
    private Long idNomina;

    // MAPEO DE FOREIGN KEYS
    @ManyToOne
    @JoinColumn(name = "ID_AREA", referencedColumnName = "ID_AREA", insertable = false, updatable = false)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "ID_NOMINA", referencedColumnName = "ID_NOMINA", insertable = false, updatable = false)
    private Nomina nomina;

    public Trabajador() {
    }

    public Trabajador(String codigoInterno, String nombre, String apellido, String numeroDocumento, String estado) {
        super(nombre, apellido, estado);
        this.codigoInterno = codigoInterno;
        this.numeroDocumento = numeroDocumento;
    }

    public Long obtenerEdad() {
        return ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
    }
}
