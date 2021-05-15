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
    final JInternalFrame ventanaContenedor;
    String ventanaObjetivo;
    JTable tabla;
    Function nextView;
    public Tabla() {
        super(new GridLayout(1,0));
        ventanaContenedor=new JInternalFrame();
        String[] columnNames = {"First Name",
                                "Last Name",
                                "Sport",
                                "# of Years",
                                "Vegetarian"};

        Object[][] data = {
	    {"Kathy", "Smith",
	     "Snowboarding", new Integer(5), new Boolean(false)},
	    {"John", "Doe",
	     "Rowing", new Integer(3), new Boolean(true)},
	    {"Sue", "Black",
	     "Knitting", new Integer(2), new Boolean(false)},
	    {"Jane", "White",
	     "Speed reading", new Integer(20), new Boolean(true)},
	    {"Joe", "Brown",
	     "Pool", new Integer(10), new Boolean(false)}
        };

        final JTable table = new JTable(data, columnNames);
        table.setEnabled(false);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
        
    }

    public Tabla(String[] cabecera, Object[][] datos, JInternalFrame contenedor,int alto,String ventanaObjetivo) {
        super(new GridLayout(1, 0));
        this.nextView= nextView;
        ventanaContenedor = contenedor;
        this.ventanaObjetivo=ventanaObjetivo;
        tabla = new JTable(datos, cabecera);
        
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
    
    public void setListener(){
            tabla.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    int row = tabla.getSelectedRow();
                    int column = tabla.getSelectedColumn();
                    System.out.println(row);
                    System.out.println(column);
                    switch(ventanaObjetivo){
                        case "dia":
                            new Dia().setVisible(true);
                        
                    }
                    
                }
            });
    }
    
    public void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
    public void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setTitle(titulo);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Create and set up the content pane.
        Tabla newContentPane = new Tabla();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(this);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
    }
}
class MultipleLine extends JTextArea implements TableCellRenderer {
    private ArrayList<ArrayList<Integer>> rowColHeight = new ArrayList<>();
    public MultipleLine(){
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

