package com.proyetofinalpoo.asistencias.views;

import com.proyetofinalpoo.asistencias.entities.Asistencia;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyetofinalpoo.asistencias.models.ListItem;
import com.proyetofinalpoo.asistencias.repository.AreaRepository;
import com.proyetofinalpoo.asistencias.repository.NominaRepository;
import com.proyetofinalpoo.asistencias.repository.TrabajadorRepository;
import com.proyetofinalpoo.asistencias.services.AsistenciaService;
import com.proyetofinalpoo.asistencias.services.EmpresaService;
import com.proyetofinalpoo.asistencias.services.SedeService;
import com.proyetofinalpoo.asistencias.utils.Constantes;
import com.proyetofinalpoo.asistencias.utils.DatosSesion;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author victortinoco
 */
@Component
public class RegistroAsistenciaView extends BaseView {

    private DefaultListModel<ListItem> trabajadoresListModel = new DefaultListModel<>();
    private Long idAsistencia = null;

    @Autowired
    private AsistenciaService asistenciaService;

    @Autowired
    private SedeService sedeService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private NominaRepository nominaRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    /**
     * Creates new form RegistroEmpresaView
     */
    public RegistroAsistenciaView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresar = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblErrorSede = new javax.swing.JLabel();
        lblErrorNomina = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        cbNomina = new javax.swing.JComboBox<>();
        cbSede = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lblErrorEmpresa = new javax.swing.JLabel();
        cbEmpresa = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lblErrorArea = new javax.swing.JLabel();
        cbArea = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtBuscarTrabajador = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTrabajadores = new javax.swing.JList<>();
        lblErrorTrabajador = new javax.swing.JLabel();
        txtFechaHora = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblId.setText("Nuevo registro");

        jLabel1.setText("Sede");

        jLabel2.setText("Nómina");

        lblErrorSede.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorSede.setText("Requerido");

        lblErrorNomina.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorNomina.setText("Requerido");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        cbNomina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNominaItemStateChanged(evt);
            }
        });

        jLabel3.setText("Empresa");

        lblErrorEmpresa.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorEmpresa.setText("Requerido");

        cbEmpresa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEmpresaItemStateChanged(evt);
            }
        });

        jLabel4.setText("Área");

        lblErrorArea.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorArea.setText("Requerido");

        cbArea.setEnabled(false);
        cbArea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAreaItemStateChanged(evt);
            }
        });

        jLabel5.setText("Trabajador");

        txtBuscarTrabajador.setEnabled(false);
        txtBuscarTrabajador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarTrabajadorKeyReleased(evt);
            }
        });

        listTrabajadores.setModel(trabajadoresListModel);
        listTrabajadores.setEnabled(false);
        jScrollPane1.setViewportView(listTrabajadores);

        lblErrorTrabajador.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorTrabajador.setText("Requerido");

        txtFechaHora.setFont(new java.awt.Font("Helvetica Neue", 2, 14)); // NOI18N
        txtFechaHora.setForeground(new java.awt.Color(0, 153, 255));
        txtFechaHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtFechaHora.setText("fechaHora");

        jLabel6.setText("Comentario (opcional)");

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        jScrollPane2.setViewportView(txtComentario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblErrorSede)
                            .addComponent(lblId)
                            .addComponent(cbSede, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblErrorNomina)
                                    .addGap(176, 176, 176))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(cbNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addContainerGap()))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEmpresa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblErrorEmpresa)
                                        .addGap(170, 170, 170)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErrorTrabajador)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(lblErrorArea)
                                            .addGap(170, 170, 170))
                                        .addComponent(cbArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRegistrar)
                                        .addGap(87, 87, 87)
                                        .addComponent(btnRegresar))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(txtBuscarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtFechaHora))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblErrorSede)
                    .addComponent(lblErrorNomina))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorEmpresa)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorArea)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorTrabajador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnRegresar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.abrirFormulario(BandejaAsistenciasView.class);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // ocultamos los textos de error
        this.ocultarTextosError();

        ListItem sedeSeleccionada = (ListItem) cbSede.getSelectedItem();
        ListItem nominaSeleccionada = (ListItem) cbNomina.getSelectedItem();
        ListItem empresaSeleccionada = (ListItem) cbEmpresa.getSelectedItem();
        ListItem areaSeleccionada = (ListItem) cbArea.getSelectedItem();
        ListItem trabajadorSeleccionado = (ListItem) listTrabajadores.getSelectedValue();

        if (sedeSeleccionada == null) {
            lblErrorSede.setVisible(true);
            cbSede.setBorder(Constantes.ERROR_BORDER);
            return;
        }
        if (nominaSeleccionada == null) {
            lblErrorNomina.setVisible(true);
            cbNomina.setBorder(Constantes.ERROR_BORDER);
            return;
        }
        if (empresaSeleccionada == null) {
            lblErrorEmpresa.setVisible(true);
            cbEmpresa.setBorder(Constantes.ERROR_BORDER);
            return;
        }
        if (areaSeleccionada == null) {
            lblErrorArea.setVisible(true);
            cbArea.setBorder(Constantes.ERROR_BORDER);
            return;
        }
        if (trabajadorSeleccionado == null) {
            lblErrorTrabajador.setVisible(true);
            return;
        }

        int resp = JOptionPane.showConfirmDialog(rootPane, "¿Desea registrar la asistencia?", "Registrar", JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.YES_OPTION) {
            var asistencia = new Asistencia();
            asistencia.setIdSede(sedeSeleccionada.getValor());
            asistencia.setIdTrabajador(trabajadorSeleccionado.getValor());
            asistencia.setComentario(txtComentario.getText());
            
            asistenciaService.registrarDatos(asistencia);
            
            JOptionPane.showMessageDialog(rootPane, "Registro completado", "Completado", JOptionPane.INFORMATION_MESSAGE);
            this.abrirFormulario(BandejaAsistenciasView.class);   
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cbEmpresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEmpresaItemStateChanged
        var modelArea = (DefaultComboBoxModel) cbArea.getModel();
        modelArea.removeAllElements();

        ListItem empresa = (ListItem) cbEmpresa.getSelectedItem();

        modelArea.addAll(areaRepository.listarAreasPorEmpresa(empresa.getValor()).stream().map(item -> {
            return new ListItem(item.getIdArea(), item.getNombre());
        }).toList());

        cbArea.setEnabled(true);

        txtBuscarTrabajador.setEnabled(false);
        listTrabajadores.setEnabled(false);
        trabajadoresListModel.clear();
    }//GEN-LAST:event_cbEmpresaItemStateChanged

    private void cbAreaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAreaItemStateChanged
        ListItem nominaSeleccionada = (ListItem) cbNomina.getSelectedItem();
        ListItem areaSeleccionada = (ListItem) cbArea.getSelectedItem();

        if (nominaSeleccionada != null && areaSeleccionada != null) {
            txtBuscarTrabajador.setEnabled(true);
            listTrabajadores.setEnabled(true);
        } else {
            txtBuscarTrabajador.setEnabled(false);
            listTrabajadores.setEnabled(false);
        }
        trabajadoresListModel.clear();
    }//GEN-LAST:event_cbAreaItemStateChanged

    private void txtBuscarTrabajadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarTrabajadorKeyReleased
        trabajadoresListModel.clear();

        ListItem nomina = (ListItem) cbNomina.getSelectedItem();
        ListItem area = (ListItem) cbArea.getSelectedItem();

        var trabajadoresList = trabajadorRepository.listarTrabajadoresPorNominaAreaNombres(
                nomina.getValor(),
                area.getValor(),
                txtBuscarTrabajador.getText()
        );

        // agregamos los trabajadores buscados
        trabajadoresListModel.addAll(trabajadoresList.stream().map(item -> {
            return new ListItem(item.getIdTrabajador(), item.getNombre() + " " + item.getApellido());
        }).toList());
    }//GEN-LAST:event_txtBuscarTrabajadorKeyReleased

    private void cbNominaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNominaItemStateChanged
        ListItem nominaSeleccionada = (ListItem) cbNomina.getSelectedItem();
        ListItem areaSeleccionada = (ListItem) cbArea.getSelectedItem();

        if (nominaSeleccionada != null && areaSeleccionada != null) {
            txtBuscarTrabajador.setEnabled(true);
            listTrabajadores.setEnabled(true);
        } else {
            txtBuscarTrabajador.setEnabled(false);
            listTrabajadores.setEnabled(false);
        }
        trabajadoresListModel.clear();
    }//GEN-LAST:event_cbNominaItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<ListItem> cbArea;
    private javax.swing.JComboBox<ListItem> cbEmpresa;
    private javax.swing.JComboBox<ListItem> cbNomina;
    private javax.swing.JComboBox<ListItem> cbSede;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblErrorArea;
    private javax.swing.JLabel lblErrorEmpresa;
    private javax.swing.JLabel lblErrorNomina;
    private javax.swing.JLabel lblErrorSede;
    private javax.swing.JLabel lblErrorTrabajador;
    private javax.swing.JLabel lblId;
    private javax.swing.JList<ListItem> listTrabajadores;
    private javax.swing.JTextField txtBuscarTrabajador;
    private javax.swing.JTextArea txtComentario;
    private javax.swing.JLabel txtFechaHora;
    // End of variables declaration//GEN-END:variables

    private void ocultarTextosError() {
        lblErrorArea.setVisible(false);
        lblErrorEmpresa.setVisible(false);
        lblErrorNomina.setVisible(false);
        lblErrorSede.setVisible(false);
        lblErrorTrabajador.setVisible(false);

        cbSede.setBorder(Constantes.DEFAULT_BORDER);
        cbNomina.setBorder(Constantes.DEFAULT_BORDER);
        cbArea.setBorder(Constantes.DEFAULT_BORDER);
        cbEmpresa.setBorder(Constantes.DEFAULT_BORDER);
    }

    @Override
    protected void limpiar() {
        // ocultamos los textos de error
        this.ocultarTextosError();
        idAsistencia = null;
        lblId.setText("Nuevo registro");
        txtBuscarTrabajador.setText("");

        cbSede.removeAllItems();
        cbNomina.removeAllItems();
        cbEmpresa.removeAllItems();
        cbArea.removeAllItems();
        cbArea.setEnabled(false);
        txtBuscarTrabajador.setEnabled(false);
        listTrabajadores.setEnabled(false);

        trabajadoresListModel.clear();
    }

    @Override
    public void iniciarVentana() {
        limpiar();
        txtFechaHora.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

        var modelSedes = (DefaultComboBoxModel) cbSede.getModel();
        var modelNomina = (DefaultComboBoxModel) cbNomina.getModel();
        var modelEmpresa = (DefaultComboBoxModel) cbEmpresa.getModel();

        var listaSedes = sedeService.listarListItemSede("");
        modelSedes.addAll(listaSedes);
        cbSede.setSelectedItem(new ListItem(DatosSesion.idSede, DatosSesion.nombreSede));

        modelNomina.addAll(nominaRepository.findAll().stream().map(item -> {
            return new ListItem(item.getIdNomina(), item.getNombre());
        }).toList());

        modelEmpresa.addAll(empresaService.listarListItemEmpresa(""));
    }
}