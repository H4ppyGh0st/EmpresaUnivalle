/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;

/**
 *
 * @author mavel
 */
public class ClienteIG extends javax.swing.JFrame {

    /**
     * Creates new form ClienteIG
     */
    public ClienteIG() {
        initComponents();
    }

    
    //Borra todas la filas del jTable
    private void limpiarListadoTabla(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtListado.getModel();
        for(int i=modelo.getRowCount()-1; i>=0 ; i--){
            modelo.removeRow(i);
        }
    }
    
    //Carga los datos de las comunas en el jTable
    public void cargarClientes(ArrayList<Cliente> listadoClientes){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtListado.getModel();        
        limpiarListadoTabla();
        for(int i= 0; i < listadoClientes.size(); i++){
              modelo.addRow(new Object[]{
              listadoClientes.get(i).getNombre(),
              listadoClientes.get(i).getId(),
              listadoClientes.get(i).getEdad(),
              listadoClientes.get(i).getDireccion(),
              listadoClientes.get(i).getCantidadPedido(),
              listadoClientes.get(i).getTipoPago()});
        }
    }
    
    public String getNombre(){
        return txtNombre.getText().trim();
    }
    
    public int getId(){
        return Integer.parseInt(txtId.getText());
    }
    
    public int getEdad(){
        return Integer.parseInt(txtEdad.getText());
    }
    
    public String getDireccion(){
        return txtDireccion.getText().trim();
    }
    
    

    public void addListenerBtnNuevo(ActionListener listenPrograma){
        btnNuevo.addActionListener(listenPrograma);       
    }
    
    public void addListenerBtnModificar(ActionListener listenPrograma){
        btnCerrar.addActionListener(listenPrograma);        
    }
    
    public void addListenerBtnBorrar(ActionListener listenPrograma){
        btnBorrar.addActionListener(listenPrograma);        
    }
    
    public void addListenerBtnCerrar(ActionListener listenPrograma){
        btnModificar.addActionListener(listenPrograma);        
    }    
             
    public void gestionMensajes(String mensaje, String titulo, int icono){
         JOptionPane.showMessageDialog(this,mensaje, titulo, icono);
    }
       
     public void activarControles(boolean estado){
        txtId.setEnabled(estado);
        txtNombre.setEnabled(estado);
        txtId.setEnabled(estado);
        txtEdad.setEnabled(estado);
        txtDireccion.setEnabled(estado);
        btnBorrar.setEnabled(!estado);
        btnCerrar.setEnabled(!estado);
        jtListado.setEnabled(!estado);
    }
    public void modificarAction(){
        if(btnModificar.getText().equals("Modificar")){
            if(jtListado.getSelectedRow() == -1){
               if(jtListado.getRowCount() == 0){
                   JOptionPane.showMessageDialog(this,"No hay registros");
               }
               else{
                   JOptionPane.showMessageDialog(this,"Seleccione una fila");
               }
            }else{ 
                activarControles(true); 
                txtId.setEnabled(false);
                btnNuevo.setText("Actualizar");
                btnNuevo.setActionCommand("Actualizar");            
                btnModificar.setText("Cancelar");
                btnModificar.setActionCommand("Cancelar");
                btnNuevo.setIcon(new ImageIcon(getClass().
                    getResource("/imgs/save-program.png"))); // NOI18N
                btnModificar.setIcon(new ImageIcon(getClass().
                    getResource("/imgs/cancel.png"))); // NOI18N
                txtNombre.requestFocusInWindow();
            }
        }else{
            activarControles(false);            
            btnNuevo.setText("Nuevo");
            btnNuevo.setActionCommand("Nuevo");
            btnModificar.setText("Modificar");
            btnModificar.setActionCommand("Modificar");
            btnNuevo.setIcon(new ImageIcon(getClass().
                    getResource("/imgs/new-program.png"))); // NOI18N
            btnModificar.setIcon(new ImageIcon(getClass().
                    getResource("/imgs/update-program.png"))); // NOI18N
            btnNuevo.requestFocusInWindow();
        }
    }
    
    public void nuevoAction(){          
        if(btnNuevo.getText().equals("Nuevo")){  
            txtId.setText("");
            txtNombre.setText("");
             txtEdad.setText("");   
            txtDireccion.setText("");   
            activarControles(true); 
            btnNuevo.setText("Grabar");
            btnNuevo.setActionCommand("Grabar");            
            btnModificar.setText("Cancelar");
            btnModificar.setActionCommand("Cancelar");
            btnNuevo.setIcon(new ImageIcon(getClass().
                    getResource("/imgs/save-program.png"))); // NOI18N
            btnModificar.setIcon(new ImageIcon(getClass().
                    getResource("/imgs/cancel.png"))); // NOI18N
            txtId.requestFocusInWindow();
        }
        else{
            activarControles(false);            
            btnNuevo.setText("Nuevo");
            btnNuevo.setActionCommand("Nuevo");
            btnModificar.setText("Modificar");
            btnModificar.setActionCommand("Modificar");
            btnNuevo.setIcon(new ImageIcon(getClass().
                    getResource("/imgs/new-program.png"))); // NOI18N
            btnModificar.setIcon(new ImageIcon(getClass().
                    getResource("/imgs/update-program.png"))); // NOI18N
            btnNuevo.requestFocusInWindow();
        }
    }       
           
    public void cancelarAction(){
        txtNombre.setEnabled(false);
        txtEdad.setEnabled(false);
        txtDireccion.setEnabled(false);        
        btnBorrar.setEnabled(true);
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        btnCerrar.setEnabled(false);
        jtListado.setEnabled(true);
    }
    
    public void cerrarAction(){
        dispose();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");

        btnBorrar.setText("Borrar");

        btnCerrar.setText("Salir");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnNuevo)
                .addGap(9, 9, 9)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Programa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel1.setText("Id:");

        txtId.setEnabled(false);
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdFocusGained(evt);
            }
        });

        jLabel3.setText("Nombre: ");

        txtNombre.setEnabled(false);
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
        });

        jLabel2.setText("Edad:");

        jLabel4.setText("Dirección:");

        txtDireccion.setEnabled(false);

        txtEdad.setEnabled(false);
        txtEdad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEdadFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(145, 145, 145))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(8, 8, 8))
        );

        jtListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Edad", "Dirección"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListado.getTableHeader().setReorderingAllowed(false);
        jtListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusGained
        // TODO add your handling code here:
        txtId.selectAll();
    }//GEN-LAST:event_txtIdFocusGained

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        // TODO add your handling code here:
        txtNombre.selectAll();
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtEdadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdadFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadFocusGained

    private void jtListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoMouseClicked
        // TODO add your handling code here:
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtListado.getModel();

        if(jtListado.getSelectedRow()==-1){
            if(jtListado.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"No hay registros");
            }
            else{
                JOptionPane.showMessageDialog(this,"Seleccione una fila");
            }
        }else {
            txtId.setText(modelo.getValueAt(
                jtListado.getSelectedRow(), 0).toString());
        txtNombre.setText(modelo.getValueAt(
            jtListado.getSelectedRow(), 1).toString());
    txtEdad.setText(modelo.getValueAt(
        jtListado.getSelectedRow(), 2).toString());
        txtDireccion.setText(modelo.getValueAt(
            jtListado.getSelectedRow(), 3).toString());
    }
    }//GEN-LAST:event_jtListadoMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed


    
   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtListado;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
  
}
