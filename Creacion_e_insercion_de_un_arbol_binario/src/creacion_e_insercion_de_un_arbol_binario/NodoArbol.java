/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creacion_e_insercion_de_un_arbol_binario;

/**
 *
 * @author Edwin O. Restrepo
 */
public class NodoArbol {

    int dato;
    String nombre;
    NodoArbol hijoIzquierdo, hijoDerecho;

    public NodoArbol(int dato, String nombre) {
        this.dato = dato;
        this.nombre = nombre;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public String toString() {
        return nombre + " Su dato es: " + dato;
    }
}
