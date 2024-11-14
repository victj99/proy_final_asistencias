package com.proyetofinalpoo.asistencias.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class FiltroBase {
    private Long id;
    private TipoOrder tipoOrder;

    public FiltroBase() {
    }
}
