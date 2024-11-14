package com.proyetofinalpoo.asistencias.utils;

import com.proyetofinalpoo.asistencias.models.ClickEnBoton;
import java.awt.Component;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.springframework.util.ResourceUtils;

/**
 *
 * @author victortinoco
 */
public class BotonTabla extends DefaultCellEditor {

    private final ClickEnBoton<Integer> alHacerClick;
    private final String textOrIcon;

    public BotonTabla(ClickEnBoton<Integer> alHacerClick, String textOrIcon) {
        super(new JCheckBox());
        this.alHacerClick = alHacerClick;
        this.textOrIcon = textOrIcon;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        var boton = crearBoton(textOrIcon);
        boton.setBackground(table.getSelectionBackground());
        boton.addActionListener((evt) -> alHacerClick.ejecutar(row));
        return boton;
    }
    
    public static class Render extends DefaultTableCellRenderer {

        final String textOrIcon;

        public Render(String textOrIcon) {
            this.textOrIcon = textOrIcon;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            var boton = crearBoton(textOrIcon);

            return boton;
        }
    }
    
    static JButton crearBoton(String textOrIcon) {
        var boton = new JButton();
        if (textOrIcon.toLowerCase().endsWith("png")) {
            try {
                var file = ResourceUtils.getFile("classpath:imagenes/" + textOrIcon);
                var img = ImageIO.read(file);
                boton.setIcon(new ImageIcon(img));
            } catch (IOException ignored) {
                boton.setText(textOrIcon);
            }
        } else {
            boton.setText(textOrIcon);
        }

        return boton;
    }


}
