/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.*;
import java.util.*;

public abstract class GestorDatos {
    //Generar el archivo en la misma posicion donde se está ejecutando la aplicacion
    private static File archivo = new File("data");
    //Leyendo y llamando la info de los archivos como objetos.
    public static Datos leerDatos() {
        Datos data = null;//Se guarda la info de los objetos
        //(Buffers)
        FileInputStream fr = null; //Inicializa la clase para empezar a leer los archivos. 
        ObjectInputStream or = null;//Clase para cambiar lo leido a objetos.

        try { 
            fr = new FileInputStream(archivo); //inicia la lectura del archivo
            or = new ObjectInputStream(fr);//Pasa lo leido a objetos
            try {
                data = (Datos) or.readObject();//Los objetos leidos los castea a clase Datos
            } catch (ClassNotFoundException e) {//Hubo un error al cargar la clase datos
                System.out.println("Error");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());//Error en la lectura
        } finally {
            try {//Cierra los buffers
                if (or != null) {
                    or.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.toString());//Error al cerrar los datos.
            }
        }

        return data;
    }

    public static void guardarDatos(Datos data) {
        FileOutputStream fw = null;
        ObjectOutputStream ow = null;

        try {
            fw = new FileOutputStream(archivo);//Llevar el archivo de RAM a disco.
            ow = new ObjectOutputStream(fw);//Convertir lo llevado en objetos.
            ow.writeObject(data);//Toma el objeto de clase datos y lo pone en el archivo.
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());//manejo de errores 
        } finally {
            try {
                if (ow != null) {
                    ow.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.toString());
            }
        }
    }

}
