package biblioteca;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmUsurios extends javax.swing.JFrame {
//FORMULARIO PARA USUARIOS DEFAULT EN EL CUAL PUEDEN VER LOS LIBROS QUE HAY EN LA BIBLIOTECA
    String[] encabezado = {"Titulo", "Autor","Categoria", "Fecha de pubicacion"};
    ArrayList<Libro> libroRecibido;
    DefaultTableModel modelo = new DefaultTableModel();
    Biblioteca biblioteca;

    public FrmUsurios() {
        initComponents();
        this.biblioteca = new Biblioteca();
        this.libroRecibido = biblioteca.obtenerLibros();
        mostrarInfo();
    }
//LOGICA PARA FILTRAR LOS LIBROS Y FACICLITAR SU BUSQUEDA
     private void buscarLibroPorTitulo() {
        String textoBuscado = TxtBuscarTitulo1.getText().trim().toLowerCase();
        ArrayList<Libro> librosFiltrados = new ArrayList<>();
        ArrayList<Libro> todosLosLibros = new ArrayList<>(biblioteca.obtenerLibros());

        for (int i = 0; i < todosLosLibros.size(); i++) {
            Libro libro = todosLosLibros.get(i);
            String titulo = libro.getTitulo().toLowerCase();
            String autor = libro.getAutor().toLowerCase();

            if (titulo.contains(textoBuscado) || autor.contains(textoBuscado)) {
                librosFiltrados.add(libro);
            }
        }

        try {
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return column == 4;
                }

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return (columnIndex == 4) ? Boolean.class : super.getColumnClass(columnIndex);
                }
            };

            modelo.setColumnIdentifiers(encabezado);
            for (Libro libro : librosFiltrados) {
                modelo.addRow(new Object[]{
                    libro.getId(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getFechaPublicacion(),
                    false
                });
            }

            TableInfo.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar libros: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//MOSTRAR INFORMACION DE LOS LIBROS EXISTENTES
    public void mostrarInfo() {
        this.libroRecibido = biblioteca.obtenerLibros();
        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(encabezado);
            for (int i = 0; i < libroRecibido.size(); i++) {
                modelo.addRow(new Object[]{
                    libroRecibido.get(i).getTitulo(),
                    libroRecibido.get(i).getAutor(),
                    libroRecibido.get(i).getCategoria(),
                    libroRecibido.get(i).getFechaPublicacion(),
                });

            }

            TableInfo.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo guardar nada" + e, "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TxtBuscarTitulo1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BtnBuscar = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableInfo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TxtBuscarTitulo1.setBackground(new java.awt.Color(51, 51, 51));
        TxtBuscarTitulo1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar por Titulo o Autor");

        BtnBuscar.setBackground(new java.awt.Color(0, 204, 255));
        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        BtnSalir.setBackground(new java.awt.Color(255, 0, 51));
        BtnSalir.setText("SALIR");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        TableInfo.setBackground(new java.awt.Color(255, 255, 255));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TxtBuscarTitulo1)
                        .addGap(18, 18, 18)
                        .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtBuscarTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
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

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        buscarLibroPorTitulo();
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(FrmUsurios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsurios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsurios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsurios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUsurios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JTable TableInfo;
    private javax.swing.JTextField TxtBuscarTitulo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
