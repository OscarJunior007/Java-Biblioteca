/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package biblioteca;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmBiblioteca extends javax.swing.JFrame {
    
    FrmVentanaDeshabilitar v2;
    
    
    String id,titulo,autor,fecha;
    int stock;
    
    String[] encabezado = {"Id","Titulo","Autor","Feca de pubicacion"};
    
 
    ArrayList<Libro> libroRecibido;
    
    private Biblioteca biblioteca;
    private Libro libro;

    public void setV2(FrmVentanaDeshabilitar v2){
        this.v2 = v2;
    }
    
    public FrmBiblioteca() {
        initComponents();
        TxtAutorLibro.setText("");
        TxtFechaPublicacion.setText("");
        TxtFechaPublicacion.setText("");
        TxtTituloLibro.setText("");
        this.biblioteca = new Biblioteca();
        this.libro =  new Libro();
        this.libroRecibido = biblioteca.obtenerLibros();
        mostrarInfo();
        
       
        
//         if (this.biblioteca == null) {
//        System.out.println("biblioteca es NULL ");
//    } else {
//        System.out.println("biblioteca se ha inicializado correctamente ");
//    }

    }
    
    
    
    public void mostrarInfo(){
        this.libroRecibido = biblioteca.obtenerLibros();
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
    
    public void guardarLibro(){
       
        titulo = TxtTituloLibro.getText();
        autor = TxtAutorLibro.getText();
        fecha = TxtFechaPublicacion.getText();
        stock = Integer.parseInt(TxtStock.getText());
        
        if(titulo.isEmpty() && autor.isEmpty() && fecha.isEmpty()){
             JOptionPane.showMessageDialog(this, "Debes ingresar los datos." , "Error"   ,  JOptionPane.INFORMATION_MESSAGE);
            return;
       
        }
        
         if(stock < 0 ){
              JOptionPane.showMessageDialog(this, "el stock no puede ser igual o inferior a 0" , "Error"   ,  JOptionPane.INFORMATION_MESSAGE);
              return;
        }
         
        try{
//           for(int i =0; i< libros.size(); i++){
//               System.out.println("libros extraidos"+ libros.get(i));
//           }
           
//        id = TxtId.getText();
        Libro nuevoLibro = new Libro(titulo, autor, fecha,stock,true,false,false,false);
        
        biblioteca.guardarLibro(nuevoLibro);
        
        JOptionPane.showMessageDialog(this, "Libro guardado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
       
         
    }catch(Exception e){
        JOptionPane.showMessageDialog(this, "No se pudo guardar nada"+ e , "Error"   ,  JOptionPane.INFORMATION_MESSAGE);
    }
       
    }
    
    public void deshabilitarHabilitarLibro(){
        
    }
    
//    public void eliminarLibro(){
//        try{
//            id = TxtId.getText();
//            
//            
//           
//            
//            if(!libroEliminado){
//             JOptionPane.showMessageDialog(this, "Libro no encontrado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
//             return;
//        }
//        JOptionPane.showMessageDialog(this, "Libro eliminado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
//            
//        }catch (Exception e){
//            JOptionPane.showMessageDialog(this, "No se pudo eliminar nada"+ e , "Error"   ,  JOptionPane.INFORMATION_MESSAGE);
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableInfo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        TxtAutorLibro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtTituloLibro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtFechaPublicacion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TxtStock = new javax.swing.JTextField();
        BtnGuardar = new javax.swing.JButton();
        BtnDeshabilitar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TableInfo.setBackground(new java.awt.Color(102, 102, 102));
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

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Autor");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Titulo");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha publicacion");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Stock");

        BtnGuardar.setBackground(new java.awt.Color(0, 153, 255));
        BtnGuardar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BtnGuardar.setText("guardar libro");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnDeshabilitar.setBackground(new java.awt.Color(255, 0, 51));
        BtnDeshabilitar.setText("Deshabilitar libros --->");
        BtnDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeshabilitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnDeshabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addGap(275, 275, 275)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2)
                                .addGap(279, 279, 279)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(204, 204, 204)
                                .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtTituloLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtAutorLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtFechaPublicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(TxtStock))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxtTituloLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFechaPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtAutorLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnDeshabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
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

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        guardarLibro();
        mostrarInfo();
       
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeshabilitarActionPerformed
        FrmVentanaDeshabilitar v2 = new FrmVentanaDeshabilitar();
        v2.setV1(this);
        v2.setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(FrmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDeshabilitar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JTable TableInfo;
    private javax.swing.JTextField TxtAutorLibro;
    private javax.swing.JTextField TxtFechaPublicacion;
    private javax.swing.JTextField TxtStock;
    private javax.swing.JTextField TxtTituloLibro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
