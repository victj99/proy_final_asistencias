package com.proyetofinalpoo.asistencias.models;

/**
 *
 * @author victortinoco
 */

@FunctionalInterface
public interface LlenarFila<T> {

    String[] llenar(T valor);
}
