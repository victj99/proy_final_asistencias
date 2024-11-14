package com.proyetofinalpoo.asistencias.models;

/**
 *
 * @author victortinoco
 */

@FunctionalInterface
public interface ClickEnBoton<T> {

    void ejecutar(T valor);
}
