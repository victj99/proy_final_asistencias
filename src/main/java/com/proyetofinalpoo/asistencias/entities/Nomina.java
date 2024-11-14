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
public class Nomina extends Auditoria {
    @Id
    @Column(name = "ID_NOMINA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNomina;

    @Column(name = "NOMBRE")
    private String nombre;

    public Nomina() {
    }

    public Nomina(Long idNomina, String nombre, String estado) {
        super(estado);
        this.idNomina = idNomina;
        this.nombre = nombre;
    }

    public Nomina(Long idNomina) {
        this.idNomina = idNomina;
    }

}
