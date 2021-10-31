/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cruddesayunos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DavidRamosNavas
 */
public class Ventana extends javax.swing.JFrame {

    //Parámetros para las conexiones
    private final String url = "jdbc:mysql://localhost:3306/cruddesayunos?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final String user = "root";
    private final String password = "";
    
    //Consultas SQL
    private final String SELECT_ALL_CARTA = "SELECT * FROM carta";
    private final String SELECT_ALL_PEDIDOS = "SELECT * FROM pedidos";
    private final String INSERCION_PEDIDO = "INSERT INTO pedidos (producto_id, nombre, precio, fecha) VALUES (?, ?, ?, ?)";
    private final String BORRAR_PEDIDO = "DELETE FROM pedidos WHERE id = ?";
    private final String SELECT_ALL_HOY = "SELECT * FROM pedidos WHERE fecha = ? AND estado = 'SIN ENTREGAR'";
    
    //Atributos
    private int id;
    private String nombre;
    private double precio;
    
    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        refrescarTablaPedidos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seleccionLeer = new javax.swing.JDialog();
        btnLeerHoy = new javax.swing.JButton();
        btnLeerTodo = new javax.swing.JButton();
        carta = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_carta = new javax.swing.JTable();
        cartaSeleccion = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_carta_seleccion = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        nombreLabel = new javax.swing.JLabel();
        nombrePedido = new javax.swing.JTextField();
        seleccionLabel = new javax.swing.JLabel();
        btnPedido = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_pedidos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnCarta = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnLeer = new javax.swing.JButton();
        btnRecogido = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        seleccionLeer.setResizable(false);
        seleccionLeer.getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        btnLeerHoy.setText("Leer solo las de hoy");
        btnLeerHoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerHoyActionPerformed(evt);
            }
        });
        seleccionLeer.getContentPane().add(btnLeerHoy);

        btnLeerTodo.setText("Leer todas la comandas");
        btnLeerTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerTodoActionPerformed(evt);
            }
        });
        seleccionLeer.getContentPane().add(btnLeerTodo);

        tabla_carta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabla_carta);

        carta.getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        tabla_carta_seleccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla_carta_seleccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_carta_seleccionMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_carta_seleccion);

        cartaSeleccion.getContentPane().add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.BorderLayout());

        nombreLabel.setText("Nombre para el pedido:");
        jPanel3.add(nombreLabel, java.awt.BorderLayout.WEST);
        jPanel3.add(nombrePedido, java.awt.BorderLayout.CENTER);

        seleccionLabel.setText("Ha seleccionado: ");
        jPanel3.add(seleccionLabel, java.awt.BorderLayout.PAGE_START);

        btnPedido.setText("Hacer pedido");
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });
        jPanel3.add(btnPedido, java.awt.BorderLayout.PAGE_END);

        cartaSeleccion.getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        tabla_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Precio", "Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla_pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_pedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_pedidos);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        btnCarta.setText("Mostrar carta");
        btnCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartaActionPerformed(evt);
            }
        });
        jPanel2.add(btnCarta);

        btnCrear.setText("Crear comanda");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel2.add(btnCrear);

        btnLeer.setText("Leer comandas");
        btnLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerActionPerformed(evt);
            }
        });
        jPanel2.add(btnLeer);

        btnRecogido.setText("Marcar como recogido");
        jPanel2.add(btnRecogido);

        btnBorrar.setText("Borrar comanda");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refrescarTablaPedidos() {

        //Creo la conexión
        try(Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();) {
            
            //Guardo los resultados de la consulta en un resultset
            ResultSet resultado = st.executeQuery(SELECT_ALL_PEDIDOS);
            
            //Saco el modelo de la tabla y lo borro todo
            DefaultTableModel modelo = (DefaultTableModel) tabla_pedidos.getModel();
            modelo.setRowCount(0);

            //Por cada resultado añado los campos de la tabla de la base de datos
            //a un array de objetos
            while(resultado.next()) {
                Object[] fila = {
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getDouble("precio"),
                    resultado.getDate("fecha"),
                    resultado.getString("estado")
                };
                //Añado cada array al modelo de la tabla
                modelo.addRow(fila);
            }
            
            //Le asigno el modelo nuevo a la tabla
            tabla_pedidos.setModel(modelo);
            
        } catch (SQLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    private void refrescarTablaCarta() {
        //Creo la conexión
        try(Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();) {
            
            //Guardo los resultados de la consulta en un resultset
            ResultSet resultado = st.executeQuery(SELECT_ALL_CARTA);
            
            //Saco el modelo de la tabla y lo borro todo
            DefaultTableModel modelo = (DefaultTableModel) tabla_carta.getModel();
            modelo.setRowCount(0);

            //Por cada resultado añado los campos de la tabla de la base de datos
            //a un array de objetos
            while(resultado.next()) {
                Object[] fila = {
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getDouble("precio")
                };
                //Añado cada array al modelo de la tabla
                modelo.addRow(fila);
            }
            
            //Le asigno el modelo nuevo a la tabla
            tabla_carta.setModel(modelo);
            tabla_carta_seleccion.setModel(modelo);
            
        } catch (SQLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        
        refrescarTablaCarta();
        
        cartaSeleccion.setSize(500, 500);
        cartaSeleccion.setVisible(true);
        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerActionPerformed
        seleccionLeer.setSize(350, 88);
        seleccionLeer.setVisible(true);
    }//GEN-LAST:event_btnLeerActionPerformed

    private void btnCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartaActionPerformed
        
        refrescarTablaCarta();
        
        carta.setSize(500, 500);
        carta.setVisible(true);
        
    }//GEN-LAST:event_btnCartaActionPerformed

    private void tabla_carta_seleccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_carta_seleccionMouseClicked
        //Aquí asigno a los atributos de la clase los campos que se hayan seleccionado
        //en la tabla al clickar
        seleccionLabel.setText("Ha seleccionado: " + (String) ((DefaultTableModel) tabla_carta_seleccion.getModel()).getValueAt(tabla_carta_seleccion.getSelectedRow(), 1));
        id = (Integer) ((DefaultTableModel) tabla_carta_seleccion.getModel()).getValueAt(tabla_carta_seleccion.getSelectedRow(), 0);
        precio = (Double) ((DefaultTableModel) tabla_carta_seleccion.getModel()).getValueAt(tabla_carta_seleccion.getSelectedRow(), 2);
    }//GEN-LAST:event_tabla_carta_seleccionMouseClicked

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        
        try(PreparedStatement pst = DriverManager.getConnection(url,user,password).prepareStatement(INSERCION_PEDIDO);) {

            nombre = nombrePedido.getText();
            pst.setInt(1, id);
            pst.setString(2, nombre);
            pst.setDouble(3, precio);
            //Asigno la fecha actual al campo fecha
            java.util.Date ahora = new java.util.Date();
            java.sql.Date fecha = new java.sql.Date(ahora.getTime());
            pst.setDate(4, fecha);
            
            pst.executeUpdate();
            refrescarTablaPedidos();
            
            //Dejo los valores a 0 para que no se guarden
            id=0;
            nombre="";
            nombrePedido.setText("");
            precio=0;
            seleccionLabel.setText("Ha seleccionado: ");
            
            cartaSeleccion.setVisible(false);
            
        } catch (SQLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnPedidoActionPerformed

    private void tabla_pedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_pedidosMouseClicked

        id = (Integer) ((DefaultTableModel) tabla_pedidos.getModel()).getValueAt(tabla_pedidos.getSelectedRow(), 0);

    }//GEN-LAST:event_tabla_pedidosMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try(PreparedStatement pst = DriverManager.getConnection(url,user,password).prepareStatement(BORRAR_PEDIDO);) {
            
            //Cojo el valor del id seleccionado en la tabla y dejo el id a 0
            pst.setInt(1, id);
            pst.executeUpdate();
            id=0;
            
            refrescarTablaPedidos();
            
        } catch (SQLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnLeerTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerTodoActionPerformed
        
        refrescarTablaPedidos();
        seleccionLeer.setVisible(false);
        
    }//GEN-LAST:event_btnLeerTodoActionPerformed

    private void btnLeerHoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerHoyActionPerformed
        
        try(PreparedStatement pst = DriverManager.getConnection(url,user,password).prepareStatement(SELECT_ALL_HOY);) {
            
            //Guardo los resultados de la consulta en un resultset
            java.util.Date ahora = new java.util.Date();
            java.sql.Date fecha = new java.sql.Date(ahora.getTime());
            pst.setDate(1, fecha);
            ResultSet resultado = pst.executeQuery();
            
            //Saco el modelo de la tabla y lo borro todo
            DefaultTableModel modelo = (DefaultTableModel) tabla_pedidos.getModel();
            modelo.setRowCount(0);

            //Por cada resultado añado los campos de la tabla de la base de datos
            //a un array de objetos
            while(resultado.next()) {
                Object[] fila = {
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getDouble("precio"),
                    resultado.getDate("fecha"),
                    resultado.getString("estado")
                };
                //Añado cada array al modelo de la tabla
                modelo.addRow(fila);
            }
            
            //Le asigno el modelo nuevo a la tabla
            tabla_pedidos.setModel(modelo);
            
            seleccionLeer.setVisible(false);
            
        } catch (SQLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnLeerHoyActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCarta;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnLeer;
    private javax.swing.JButton btnLeerHoy;
    private javax.swing.JButton btnLeerTodo;
    private javax.swing.JButton btnPedido;
    private javax.swing.JButton btnRecogido;
    private javax.swing.JFrame carta;
    private javax.swing.JFrame cartaSeleccion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombrePedido;
    private javax.swing.JLabel seleccionLabel;
    private javax.swing.JDialog seleccionLeer;
    private javax.swing.JTable tabla_carta;
    private javax.swing.JTable tabla_carta_seleccion;
    private javax.swing.JTable tabla_pedidos;
    // End of variables declaration//GEN-END:variables
}
