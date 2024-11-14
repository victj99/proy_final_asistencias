package com.proyetofinalpoo.asistencias.utils;

import com.proyetofinalpoo.asistencias.models.ClickEnBoton;
import com.proyetofinalpoo.asistencias.models.LlenarFila;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victortinoco
 */
public class TablaConBotones<T> extends JTable {

    private List<T> listaDatos;

    // Declaracion de las funciones lambda
    private LlenarFila<T> llenarFilaTabla = null;

    public void asignarDatos(List<T> listaDatos) {
        if (llenarFilaTabla == null) {
            return; // No hacer nada
        }
        this.listaDatos = listaDatos;

        // obtenemos los datos de la tabla
        final var model = (DefaultTableModel) this.getModel();
        model.setRowCount(0); // Eliminamos todos los datos

        listaDatos.forEach((item) -> model.addRow(llenarFilaTabla.llenar(item) /* añadimos la fila */));

        // Si no quires usar streams puedes hacer un for normal
        /*for (T item : listaDatos) {
            String[] fila = llenarFilaTabla.llenar(item);
            model.addRow(fila);
        }*/
    }

    public void agregarDato(T dato) {
        if (llenarFilaTabla == null) {
            return; // No hacer nada
        }

        listaDatos.add(dato);
        // obtenemos el modelo de la tabla
        final var model = (DefaultTableModel) this.getModel();
        String[] fila = llenarFilaTabla.llenar(dato);
        model.addRow(fila);
    }

    public void ejecutarAlCrearFila(LlenarFila<T> llenarFilaTabla) {
        this.llenarFilaTabla = llenarFilaTabla;
    }

    /**
     * Agrega un botón en la columna especificada en el parámetro {@code pos}. Al hacer clic en el botón, se ejecuta la
     * función en el parámetro {@code alHacerClick}.
     *
     * @param alHacerClick función que se ejecutará. Devuelve los datos de la fila en la que se encuentra el botón.
     * @param pos la posición de la columna donde se añadirá el botón de eliminar.
     * @param texto El texto o ruta del ícono que se verá en el botón.
     */
    public void agregarBoton(ClickEnBoton<T> alHacerClick, int pos, String texto) {
        // Creamos el botón
        var botonTabla = new BotonTabla((row) -> {
            alHacerClick.ejecutar(listaDatos.get(row));
        }, texto);

        // añadimos el botón
        this.getColumnModel().getColumn(pos).setCellRenderer(new BotonTabla.Render(texto));
        this.getColumnModel().getColumn(pos).setCellEditor(botonTabla);

        if (texto.toLowerCase().endsWith("png")) {
            this.getColumnModel().getColumn(pos).setMaxWidth(40);
            this.getColumnModel().getColumn(pos).setMinWidth(40);
        }

    }
}
