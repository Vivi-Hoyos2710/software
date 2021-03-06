/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import java.util.ArrayList;
import java.io.Serializable;
public class Usuario implements Serializable{
    private String nombre;
    private String genero;
    private int edad;
    private ArrayList<String> gustos = new ArrayList<String>();
    private String email;
    private int ranking;
    private int puntaje_total;
    private String nivel_academico;
    private Horario horarioUsuario;

    public Usuario() {
    }

    public Usuario(int e, String n, String m, String a, String g) {
        this.edad = e;
        this.nombre = n;
        this.email = m;
        this.nivel_academico = a;
        this.genero = g;
        this.horarioUsuario= new Horario();
    }

    // setters//
    public void setNombre(String n) {
        this.nombre = n;
    }
    public void setEmail(String e){
        this.email=e;
    }

    public void setNivelAcademico(String n) {
        this.nivel_academico = n;
    }

    public void setRanking(int r) {
        this.ranking = r;
    }

    public void setPuntajeTotal(int n) {
        this.puntaje_total = n;
    }

    public void setEdad(int n) {
        this.edad = n;
    }
     public void setGustos(ArrayList<String> gustos) {
        this.gustos = gustos;
    }


    // getters//
    public String getNombre() {
        return this.nombre;
    }

    public String getNivelAcademico() {
        return this.nivel_academico;
    }

    public int getRanking() {
        return this.ranking;
    }

    public int getPuntajeTotal() {
        return this.puntaje_total;
    }

    public int getEdad() {
        return this.edad;
    }

    public String getEmail() {
        return this.email;
    }
    public Horario getHorarioUsuario(){
        return this.horarioUsuario;
    }
    
    public ArrayList<String> getGustos(){
        return this.gustos;
    }

    // Metodos//
    public void addGustos(String g) {
        gustos.add(g);
    }

    public void asignarActividad(String nombre, int importancia,int mes, int dia, int hora) {
        
        Actividad a = new Actividad(nombre, importancia);

        if (horarioUsuario.temporalidad[mes][dia][hora]==null) {
            horarioUsuario.temporalidad[mes][dia][hora] = a;
        }
    }


    public String revisarInformacion() {
        String info = "Nombre: " + this.nombre + "\n" + "Edad: " + this.edad + "\n" + "G??nero: " + this.genero + "\n"
                + "E-mail: " + this.email + "\n" + "Nivel Academico: " + this.nivel_academico + "\n" + "Puntaje Total: "
                + this.puntaje_total + "\n" + "Ranking: " + this.ranking + "\n" + "Gustos: ";
        for (int i = 0; i < this.gustos.size(); i++) {
            info += this.gustos.get(i) + " ";
        }
        return info;
    }

}
