package com.proyetofinalpoo.asistencias.views;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyetofinalpoo.asistencias.services.UsuarioService;
import com.proyetofinalpoo.asistencias.utils.Constantes;
import com.proyetofinalpoo.asistencias.utils.DatosSesion;
import com.proyetofinalpoo.asistencias.utils.StringUtils;

/**
 *
 * @author victortinoco
 */

@Component
public class IniciarSesionView extends BaseView {
    
    @Autowired
    private UsuarioService usuarioService;
    
    public IniciarSesionView() {
        initComponents();
        lblNombreUsuario.setVisible(false);
        lblContrasenia.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreUsuario = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        lblNombreUsuario = new javax.swing.JLabel();
        lblContrasenia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombreUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreUsuarioFocusGained(evt);
            }
        });

        txtContrasenia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContraseniaFocusGained(evt);
            }
        });
        txtContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseniaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre de usuario");

        jLabel2.setText("Contraseña");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel3.setText("Iniciar Sesión");

        btnIniciarSesion.setBackground(new java.awt.Color(0, 153, 255));
        btnIniciarSesion.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        lblNombreUsuario.setForeground(new java.awt.Color(255, 0, 0));
        lblNombreUsuario.setText("Este campo es requerido");
        lblNombreUsuario.setFocusable(false);

        lblContrasenia.setForeground(new java.awt.Color(255, 0, 0));
        lblContrasenia.setText("Este campo es requerido");
        lblContrasenia.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContrasenia)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(txtContrasenia)
                                .addComponent(txtNombreUsuario)
                                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(lblNombreUsuario))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel3)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblNombreUsuario)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblContrasenia)
                .addGap(18, 18, 18)
                .addComponent(btnIniciarSesion)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        final String nombreUsuario = txtNombreUsuario.getText().trim();
        final String contrasenia = String.valueOf(txtContrasenia.getPassword());
        
        if (StringUtils.isEmpty(nombreUsuario)) {
            txtNombreUsuario.setBorder(Constantes.ERROR_BORDER);
            lblNombreUsuario.setVisible(true);
            return;
        }
        
        if (StringUtils.isEmpty(contrasenia)) {
            txtContrasenia.setBorder(Constantes.ERROR_BORDER);
            lblContrasenia.setVisible(true);
            return;
        }
        
        var usuario = usuarioService.obtenerUsuarioPorCredenciales(nombreUsuario, contrasenia);
        
        if (usuario == null) {
            JOptionPane.showMessageDialog(rootPane, "Nombre de usuario ocontraseña incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (usuario.getEstado().equals(Constantes.ESTADO_INACTIVO)) {
            JOptionPane.showMessageDialog(rootPane, "El usuario se encuentra inactivo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DatosSesion.username = nombreUsuario;
        DatosSesion.idUsuario = usuario.getIdUsuario();
        DatosSesion.nombreCompletoUsuario = usuario.getNombre() + " " + usuario.getApellido();
        
        if (usuario.getSede() != null) {
            DatosSesion.idSede = usuario.getIdSede();
            DatosSesion.nombreSede = usuario.getSede().getNombre();
        }
        this.abrirFormulario(PrincipalView.class);
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void txtNombreUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreUsuarioFocusGained
        lblNombreUsuario.setVisible(false);
        txtNombreUsuario.setBorder(Constantes.DEFAULT_BORDER);
    }//GEN-LAST:event_txtNombreUsuarioFocusGained

    private void txtContraseniaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseniaFocusGained
        lblContrasenia.setVisible(false);
        txtContrasenia.setBorder(Constantes.DEFAULT_BORDER);
    }//GEN-LAST:event_txtContraseniaFocusGained

    private void txtContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseniaActionPerformed
        this.btnIniciarSesionActionPerformed(null);
    }//GEN-LAST:event_txtContraseniaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void limpiar() {
        
    }

    @Override
    public void iniciarVentana() {
    }
}