package com.proyetofinalpoo.asistencias.entities;

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

/**
 *
 * @author victortinoco
 */
@Getter
@Setter
@Entity
public class Area extends Auditoria {

    @Id
    @Column(name = "ID_AREA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArea;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "ID_EMPRESA")
    private Long idEmpresa;

    // MAPEO DE FOREIGN KEYS
    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA", insertable = false, updatable = false)
    private Empresa empresa;

    public Area() {
    }

    public Area(Long idArea) {
        this.idArea = idArea;
    }

    public Area(String estado, Long idArea, String nombre) {
        super(estado);
        this.idArea = idArea;
        this.nombre = nombre;
    }
}
