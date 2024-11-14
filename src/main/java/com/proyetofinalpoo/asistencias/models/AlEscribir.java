/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyetofinalpoo.asistencias.models;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author victortinoco
 */
public class AlEscribir implements DocumentListener {

    private final EscribirLambda lambda;
    
    public AlEscribir(EscribirLambda lambda) {
        this.lambda = lambda;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        lambda.ejecutar(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        lambda.ejecutar(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
    
    @FunctionalInterface
    public static interface EscribirLambda {
        public abstract void ejecutar(DocumentEvent e);
    }
}