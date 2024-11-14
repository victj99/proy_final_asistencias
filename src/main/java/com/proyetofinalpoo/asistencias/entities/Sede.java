package com.proyetofinalpoo.asistencias.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author victortinoco
 */

@Getter
@Setter
@Entity
public class Sede extends Auditoria {

    @Id
    @Column(name = "ID_SEDE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSede;

    @Column(name = "NOMBRE")
    private String nombre;

    public Sede() {
    }
    
    public Sede(Long idSede) {
        this.idSede = idSede;
    }

    public Sede(String estado, Long idSede, String nombre) {
        super(estado);
        this.idSede = idSede;
        this.nombre = nombre;
    }
}
