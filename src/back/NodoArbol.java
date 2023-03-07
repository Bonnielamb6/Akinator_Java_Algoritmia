/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

/**
 *
 * @author PC
 */
public class NodoArbol {
    NodoArbol hijoDerecho;
    NodoArbol hijoIzquierdo;
    String texto;
    int profundidad;
    
    public NodoArbol(String texto){
        this.texto = texto;
        this.profundidad=0;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
    
    public NodoArbol(String caracteristica,NodoArbol hijoDerecho){
        this.texto = caracteristica;
        this.profundidad=0;
        this.hijoIzquierdo = null;
        this.hijoDerecho = hijoDerecho;
    }

    public NodoArbol getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoArbol hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public NodoArbol getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoArbol hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }
    
    public NodoArbol avanzarDerecha(NodoArbol temporal){
        temporal = temporal.hijoDerecho;
        return temporal;
    }
    
    public NodoArbol avanzarIzquierda(NodoArbol temporal){
        temporal = temporal.hijoIzquierdo;
        return temporal;
    }
    
}