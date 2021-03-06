/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacion;

import static Aplicacion.Principal.data;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import static Visualizacion.MenuPrincipal.correoUsuario;

/**
 *
 * @author almah
 */
public class Dia extends javax.swing.JFrame {

    /**
     * Creates new form Dia
     */

    JInternalFrame frame = new JInternalFrame("Dia");
    private int mes;
    private int dia;
    public Dia(int mes, int dia) {
        this.mes = mes;
        this.dia = dia;
        initComponents();
        String[] cabecera = new String[3];
        cabecera[0] = "Hora";
        cabecera[1] = "Actividad";
        cabecera[2] = "Importancia";
        String[][] actividades = new String[24][3];
        for (int i = 0; i < actividades.length; i++) {
            if (data.getUsuarios().get(MenuPrincipal.correoUsuario).getHorarioUsuario().temporalidad[mes][dia][i] != null) {
                actividades[i][0] = i + "";
                actividades[i][1] = data.getUsuarios().get(MenuPrincipal.correoUsuario).getHorarioUsuario().temporalidad[mes][dia][i].getNombre() + "";
                actividades[i][2] = data.getUsuarios().get(MenuPrincipal.correoUsuario).getHorarioUsuario().temporalidad[mes][dia][i].getImportancia() + "";
            }

        }
        Tabla tabla = new Tabla(cabecera, actividades, frame, 90, "actividad", this);
        this.jPanel1.add(frame);
        frame.setContentPane(tabla);
        frame.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) frame.getUI()).setNorthPane(null);
        frame.pack();
        try {
            frame.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Dia.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.setVisible(true);
    }
    
    public int getMes(){
        return this.mes;
    }
    public int getDia(){
        return this.dia;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
