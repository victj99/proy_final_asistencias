package com.proyetofinalpoo.asistencias.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiltroUsuario extends FiltroBase {
    private String nombreApellido;
    private String nombreUsuario;
    private String nombreSede;
    private String estado;

    public FiltroUsuario() {
    }
}
