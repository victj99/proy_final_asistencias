package com.proyetofinalpoo.asistencias.entities;

import com.proyetofinalpoo.asistencias.utils.Constantes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Usuario extends Persona {
    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;

    @Column(name = "CONTRASENIA")
    private String contrasenia;

    // Foraneos
    @Column(name = "ID_SEDE")
    private Long idSede;

    // MAPEO DE FOREIGN KEYS (Solo para que haga los JOIN automaticamente)
    @ManyToOne
    @JoinColumn(name = "ID_SEDE", referencedColumnName = "ID_SEDE", insertable = false, updatable = false)
    private Sede sede;

    public Usuario() {
    }

    public Usuario(Long idUsuario) {
        super("", "", Constantes.ESTADO_ACTIVO);
        this.idUsuario = idUsuario;
    }

    public Usuario(String nombreUsuario, String contrasenia, String nombre, String apellido, String estado, Long idSede) {
        super(nombre, apellido, estado);
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.idSede = idSede;
    }

    public void setContrasenia(String contrasenia) {
        if (contrasenia != null) {
            this.contrasenia = contrasenia;
        }
    }
}
