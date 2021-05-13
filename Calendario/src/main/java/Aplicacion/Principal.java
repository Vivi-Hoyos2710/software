/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;
import Persistencia.*;
import Visualizacion.Login;
public class Principal {
    public static Datos data; 
    public static void main(String[] args){
        //Traer los datos del archivo de la persistencia.
        data= GestorDatos.leerDatos();
        //Si el archivo no se creo hacer uno por default.
        if(data==null){
            data = new Datos();
            GestorDatos.guardarDatos(data);
        }
        //Se inicializa la interfaz
        new Login().setVisible(true);
        
    }
}
