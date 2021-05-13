/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Aplicacion.Usuario;
import java.io.Serializable;
import java.util.HashMap;

public class Datos implements Serializable {

    private HashMap<String, Usuario> usuariosRegistrados = new HashMap<String, Usuario>();

    public HashMap<String, Usuario> getUsuarios() {
        return usuariosRegistrados;
    }
    // Método para agregar un usuario al hashmap (recibe como parámetro el usuario que quiere agregar)
    public void addUsuario(Usuario usuario) {
        usuariosRegistrados.put(usuario.getEmail(), usuario);
    }
    // Método para borrar un usuario (recibe como parámetro su correo)
    public void borrarUsuario(String correo) {
        usuariosRegistrados.remove(correo);
    }
}
