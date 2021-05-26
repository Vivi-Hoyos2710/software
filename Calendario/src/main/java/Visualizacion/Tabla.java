/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacion;

/**
 *
 * @author
 */
import static Visualizacion.MenuPrincipal.correoUsuario;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.function.Function;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Tabla extends JPanel {

    private boolean DEBUG = false;
    String titulo;
    JInternalFrame ventanaContenedor;
    String ventanaObjetivo;
    JTable tabla;
    Function nextView;
    Object cosa;

    public Tabla(String[] cabecera, Object[][] datos, JInternalFrame contenedor, int alto, String ventanaObjetivo, Object cosa) {
        super(new GridLayout(1, 0));
        this.nextView = nextView;
        ventanaContenedor = contenedor;
        this.ventanaObjetivo = ventanaObjetivo;
        tabla = new JTable(datos, cabecera);
        this.cosa = cosa;

        //permitiendo multiples lineas en celda
        tabla.setDefaultRenderer(Object.class, new MultipleLine());

        tabla.getTableHeader().setReorderingAllowed(false);
        //Sobreescritura del modelo de la tabla para poder modificar sus valores.
        DefaultTableModel tableModel = new DefaultTableModel(datos, cabecera) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla.setModel(tableModel);
        tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tabla.setFillsViewportHeight(true);
        tabla.setRowHeight(alto); //Estableciendo alto de las filas.
        setListener();

        if (DEBUG) {
            tabla.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    printDebugData(tabla);
                }
            });
        }

        //Create the scroll pane and add the tabla to it.
        JScrollPane scrollPane = new JScrollPane(tabla);

        //Add the scroll pane to this panel.
        add(scrollPane);

    }

    public void setListener() {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tabla.getSelectedRow();
                int column = tabla.getSelectedColumn();
                int mes, diaInicial, diaDeseado;

                switch (ventanaObjetivo) {
                    case "dia":
                        mes = ((MenuPrincipal) cosa).getMes();
                        diaInicial = getDiaInicial(mes);
                        diaDeseado = (column + (row * 7)) - diaInicial;
                        new Dia(mes, diaDeseado).setVisible(true);
                        break;
                    case "actividad":
                        mes = ((Dia) cosa).getMes();
                        diaDeseado = ((Dia) cosa).getDia();
                        if (tabla.getValueAt(row, column) != null) {
                            new EditarActividad(mes, diaDeseado, row).setVisible(true);
                        }
                        else{
                            new AsignarActividad(correoUsuario, mes, diaDeseado, row).setVisible(true);
                        }
                        

                }
            }
        });
    }

    public int getDiaInicial(int mes) {
        int diaInicial = 0;
        switch (mes) {
            case 0:
                diaInicial = 5;
                break;
            case 1:
                diaInicial = 1;
                break;
            case 2:
                diaInicial = 1;
                break;
            case 3:
                diaInicial = 4;
                break;
            case 4:
                diaInicial = 6;
                break;
            case 5:
                diaInicial = 2;
                break;
            case 6:
                diaInicial = 4;
                break;
            case 7:
                diaInicial = 0;
                break;
            case 8:
                diaInicial = 3;
                break;
            case 9:
                diaInicial = 5;
                break;
            case 10:
                diaInicial = 1;
                break;
            case 11:
                diaInicial = 3;
                break;

        }
        return diaInicial;
    }

    public void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i = 0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j = 0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

}

class MultipleLine extends JTextArea implements TableCellRenderer {

    private ArrayList<ArrayList<Integer>> rowColHeight = new ArrayList<>();

    public MultipleLine() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        setEditable(false);
        return this;
    }

}
