/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package biblioteca;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oscar
 */
public class FrmVentanaDeshabilitar extends javax.swing.JFrame {

    private FrmBiblioteca v1;
    private Biblioteca biblioteca;
    ArrayList<Libro> libroRecibido;
    String[] encabezado = {"Id","Titulo","Autor","Fecha de publicacion"};
    
    public void setV1(FrmBiblioteca v1){
        this.v1 = v1;
    }
    
    public FrmVentanaDeshabilitar() {
      
        initComponents();
        TxtId.setText("");
        this.biblioteca =  new Biblioteca();
       // this.libroRecibido = biblioteca.obtenerLibrosDeshabilitados();
       // mostrarInfo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableInfo = new javax.swing.JTable();
        BtnVentanaBiblioteca = new javax.swing.JButton();
        BtnHabilitar = new javax.swing.JButton();
        BtnDeshabilitar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Ingresa el ID del libro que quieres deshabilitar o habilitar");

        TableInfo.setBackground(new java.awt.Color(102, 102, 102));
        TableInfo.setForeground(new java.awt.Color(0, 0, 0));
        TableInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TableInfo);

        BtnVentanaBiblioteca.setBackground(new java.awt.Color(0, 153, 255));
        BtnVentanaBiblioteca.setText("<-- Regrar a la biblioteca");
        BtnVentanaBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVentanaBibliotecaActionPerformed(evt);
            }
        });

        BtnHabilitar.setBackground(new java.awt.Color(51, 204, 0));
        BtnHabilitar.setForeground(new java.awt.Color(255, 255, 255));
        BtnHabilitar.setText("Habilitar");
        BtnHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHabilitarActionPerformed(evt);
            }
        });

        BtnDeshabilitar.setBackground(new java.awt.Color(255, 0, 51));
        BtnDeshabilitar.setText("Deshablitar");
        BtnDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeshabilitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnVentanaBiblioteca)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(BtnHabilitar)
                        .addGap(38, 38, 38)
                        .addComponent(BtnDeshabilitar)))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnHabilitar)
                    .addComponent(BtnDeshabilitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnVentanaBiblioteca)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
   /* public void mostrarInfo(){
        this.libroRecibido = biblioteca.obtenerLibrosDeshabilitados();
    
        try{
           
         
             DefaultTableModel modelo =  new DefaultTableModel();
             modelo.setColumnIdentifiers(encabezado);
                for(int i=0; i<libroRecibido.size();i++){
                    modelo.addRow(new Object[]{
                        libroRecibido.get(i).getId(),
                        libroRecibido.get(i).getTitulo(),
                        libroRecibido.get(i).getAutor(),
                        libroRecibido.get(i).getfechaPublicacion()     
                    });
                     
                }
            
        TableInfo.setModel(modelo);
       }catch(Exception e){
           JOptionPane.showMessageDialog(this, "No se pudo guardar nada"+ e , "Error"   ,  JOptionPane.INFORMATION_MESSAGE);
       }
      
    }
    public boolean datos(int ID){
        for(int i = 0; i<libroRecibido.size();i++){
            if(libroRecibido.get(i).getId() == ID){
                if(libroRecibido.get(i).isdeshabilitado()){
                     return true;
                }
                else if(!libroRecibido.get(i).isdeshabilitado()){
                    return false;
                }
            }
            
        }
        return false;
    }*/
    
    private void BtnVentanaBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVentanaBibliotecaActionPerformed
        FrmBiblioteca v1 = new FrmBiblioteca();
        v1.setV2(this);
        v1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BtnVentanaBibliotecaActionPerformed

    private void BtnHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHabilitarActionPerformed
       /* String id = TxtId.getText();
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingresa algun ID" , "Error"   ,  JOptionPane.INFORMATION_MESSAGE);
        }
        try{
            int idParse = Integer.parseInt(id);
            if(!datos(idParse)){
                JOptionPane.showMessageDialog(this, "Libro con ese ya esta habilitado" , "Error"   ,  JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            boolean response = biblioteca.actualizarEstadoDeshabilitadoFalse(idParse);
             if(!response){
                 JOptionPane.showMessageDialog(this, "Libro con ese Id no existe" , "Error"   ,  JOptionPane.INFORMATION_MESSAGE);
                 return;
             }
             JOptionPane.showMessageDialog(this, "Libro habilitado con exito!" , "Exito"   ,  JOptionPane.INFORMATION_MESSAGE);
             mostrarInfo();
        }catch(Exception e ){
              JOptionPane.showMessageDialog(this, "No se pudo habilitar el libro el libro"+e , "Error"   ,  JOptionPane.INFORMATION_MESSAGE);
        }*/
        
    }//GEN-LAST:event_BtnHabilitarActionPerformed

    private void BtnDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeshabilitarActionPerformed
        /*String id = TxtId.getText();
        if(id == ""){
            JOptionPane.showMessageDialog(this, "Ingresa algun ID" , "Error"   ,  JOptionPane.INFORMATION_MESSAGE);
        }
        
        try{
            int idParse = Integer.parseInt(id);
            
            if(datos(idParse)){
                JOptionPane.showMessageDialog(this, "Libro ya se encuentra deshabilitado" , "Error"   ,  JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            boolean response = biblioteca.actualizarEstadoDeshabilitado(idParse);
             if(!response){
                 JOptionPane.showMessageDialog(this, "Libro con ese Id no existe" , "Error"   ,  JOptionPane.INFORMATION_MESSAGE);
                 return;
             }
             JOptionPane.showMessageDialog(this, "Libro deshabilitado con exito!" , "Exito"   ,  JOptionPane.INFORMATION_MESSAGE);
             mostrarInfo();
        }catch(Exception e ){
              JOptionPane.showMessageDialog(this, "No se pudo deshabilitar el libro"+e , "Error"   ,  JOptionPane.INFORMATION_MESSAGE);
        }*/
    }//GEN-LAST:event_BtnDeshabilitarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmVentanaDeshabilitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVentanaDeshabilitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVentanaDeshabilitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVentanaDeshabilitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVentanaDeshabilitar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDeshabilitar;
    private javax.swing.JButton BtnHabilitar;
    private javax.swing.JButton BtnVentanaBiblioteca;
    private javax.swing.JTable TableInfo;
    private javax.swing.JTextField TxtId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
