package com.proyetofinalpoo.asistencias.models;

/**
 * Representa un parámetro el cual es un valor que se transferirá entre formularios.
 */
public interface Params {
    public Object getValue();

    public String getClassName();

    public class IdParam implements Params {
        private Long id;
        
        public IdParam(Long id) {
            this.id = id;
        }
        
        @Override
        public Long getValue() {
            return id;
        }

        @Override
        public String getClassName() {
            return getClass().getName();
        }
    }

}
