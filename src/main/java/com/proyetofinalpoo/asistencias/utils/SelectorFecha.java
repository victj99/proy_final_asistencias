package com.proyetofinalpoo.asistencias.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author victortinoco
 */
public class SelectorFecha extends JXDatePicker{
    final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    public SelectorFecha() {
        super();
        this.setFormats(df);
    }
    
    public LocalDate getLocalDate() {
        final var fecha = this.getDate();
        return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    public void setLocalDate(LocalDate fecha) {
        var zonedId = fecha.atStartOfDay(ZoneId.systemDefault());
        
        this.setDate(Date.from(zonedId.toInstant()) /* Convertimos el localDate a Date */);
    }
}
