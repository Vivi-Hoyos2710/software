/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;
import java.io.Serializable;
public class Actividad implements Serializable {
    private String nombre;
    private int importancia;
    private boolean estado;
    private int puntuacion;

    public String getNombre(){
        return this.nombre;
    }
    public void setEstado(boolean e){
        this.estado=e;
    }
    public void setNombre(String n){
        this.nombre=n;
    }
    public void setImportancia(int i){
        this.importancia=i;
    }
    public boolean getEstado(){
        return this.estado;
    }
    public Actividad(){}
    public Actividad(String n,int i){
        this.nombre=n;
        this.importancia=i;
        this.puntuacion= i*5;
        this.setEstado(false);
    }
    public Actividad(String n){
        this.nombre=n;
    }
    public int getPuntuacion(){
        return this.puntuacion;
    }
    public int getImportancia(){
        return this.importancia;
    }

}
