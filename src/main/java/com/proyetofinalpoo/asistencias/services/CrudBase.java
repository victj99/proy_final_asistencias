package com.proyetofinalpoo.asistencias.services;

import java.util.List;

public interface CrudBase<T> {

    public List<T> listarTodosDatos();

    public void registrarDatos(T entity);

    public void actualizarDatos(T entity);

    public T obtenerPorId(Long id);
}
