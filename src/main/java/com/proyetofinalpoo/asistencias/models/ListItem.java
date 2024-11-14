package com.proyetofinalpoo.asistencias.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ListItem {
    Long valor;
    String texto;

    // sobreescribimos el toString porque el jCombobox y el jList llaman al toString por debajo
    @Override
    public String toString() {
        return texto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ListItem listItem) {
            return listItem.getValor().equals(valor);
        }
        
        return super.equals(obj);
    }
    
    
}
