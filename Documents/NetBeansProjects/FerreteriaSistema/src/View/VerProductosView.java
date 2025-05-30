/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Producto;
import Model.ProductoDAO;
import Model.SesionActual;
import controller.ProductoController;
import java.awt.ScrollPane;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUIS FANDIÑO
 */
public class VerProductosView extends javax.swing.JFrame {
    
    private int id_Sede;
    private String cargo;
    
    /**
     * Creates new form VerProductosView
     */
    public VerProductosView(int id_Sede, String cargo) {
        this.id_Sede=id_Sede;
       this.cargo=cargo;
        initComponents();
        cargarProductos(id_Sede, cargo);
        
        
        switch (cargo) {
    
    case "Vendedor":
        switch (id_Sede) {
            case 1:
                btnActualizar.setVisible(false);
                btnEliminar.setVisible(false);
                btnRegistrar.setVisible(false);
                break;
            case 2:
                btnActualizar.setVisible(false);
                btnEliminar.setVisible(false);
                btnRegistrar.setVisible(false);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Sede no válida");
                dispose();
                break;
        }
        break;
    }
    }
private void cargarProductosPorNombre() {
    String nombre = txtBuscarProducto.getText().trim();
    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre para buscar");
        return;
    }
   
    ProductoController productoController = new ProductoController();
    List<Producto> producto = productoController.obtenerProductos(nombre);
    
    // Limpiar la tabla antes de cargar los datos
    DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
    modelo.setRowCount(0);

    for (Producto p : producto) {
        modelo.addRow(new Object[]{
            p.getId_Producto(),
            p.getNombre(),
            p.getPrecio(),
            p.getStock(),
            p.getId_Sede()});
    }
}
 
  
    
   private void cargarProductos(int id_Sede, String cargo) {
    ProductoDAO productoDAO = new ProductoDAO();
    List<Producto> producto;

    if ("admin".equalsIgnoreCase(cargo)) {
        // Si el rol es admin, cargar todos los productos sin filtrar por sede
        producto = productoDAO.obtenerTodosLosProductos();
    } else {
        // Si es empleado, cargar solo los productos de su sede
        producto = productoDAO.obtenerProductosPorSede(id_Sede);
    }

    // Limpiar la tabla antes de agregar datos nuevos
    DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
    modelo.setRowCount(0);

    // Llenar la tabla con los datos obtenidos de la base de datos
    for (Producto p : producto) {
        modelo.addRow(new Object[]{
            p.getId_Producto(), 
            p.getNombre(),  
            p.getPrecio(),  
            p.getStock(), 
            p.getId_Sede()});
    }
}
    
  

    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_Producto", "Nombre", "Precio", "Stock", "sede"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductos);
        if (tblProductos.getColumnModel().getColumnCount() > 0) {
            tblProductos.getColumnModel().getColumn(0).setResizable(false);
            tblProductos.getColumnModel().getColumn(1).setResizable(false);
            tblProductos.getColumnModel().getColumn(2).setResizable(false);
            tblProductos.getColumnModel().getColumn(3).setResizable(false);
            tblProductos.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 640, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        btnRegistrar.setText("Registrar");
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, -1, -1));

        btnEliminar.setText("Eliminar");
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        btnMostrar.setText("Mostrar");
        btnMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMostrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMostrarMouseEntered(evt);
            }
        });
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jLabel1.setText("busca un producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 100, 30));

        txtBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 122, 230, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseClicked
        cargarProductos(id_Sede, cargo);
    }//GEN-LAST:event_btnMostrarMouseClicked

    
    private void txtBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProductoActionPerformed
        // TODO add your handling code here:
                cargarProductosPorNombre();

    }//GEN-LAST:event_txtBuscarProductoActionPerformed

    private void btnMostrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarMouseEntered

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
            java.util.logging.Logger.getLogger(VerProductosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerProductosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerProductosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerProductosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                  // Pasa la sede al constructor de VerProductosView

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscarProducto;
    // End of variables declaration//GEN-END:variables
}
