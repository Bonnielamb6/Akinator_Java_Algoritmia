/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

/**
 *
 * @author PC
 */
public class Arbol {
    private NodoArbol raiz;
    
    public Arbol(){
        raiz = null;
    }
    
    //Obtener profundidad
    public int obtenerProfundidad(NodoArbol x){
        if(x==null){
            return -1;
        }else{
             return x.profundidad;
        }
    }
    
    public NodoArbol rotacionIzquierda(NodoArbol x){
        NodoArbol auxiliar = x.hijoIzquierdo;
        x.hijoIzquierdo = auxiliar.hijoDerecho;
        auxiliar.hijoDerecho = x;
        x.profundidad = Math.max(obtenerProfundidad(x.hijoIzquierdo),obtenerProfundidad(x.hijoDerecho)+1 );
        auxiliar.profundidad = Math.max(obtenerProfundidad(auxiliar.hijoIzquierdo),obtenerProfundidad(auxiliar.hijoDerecho)+1 );
        return auxiliar;
    }
    
    public NodoArbol rotacionDerecha(NodoArbol x){
        NodoArbol auxiliar = x.hijoDerecho;
        x.hijoDerecho = auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo = x;
        x.profundidad = Math.max(obtenerProfundidad(x.hijoIzquierdo),obtenerProfundidad(x.hijoDerecho)+1 );
        auxiliar.profundidad = Math.max(obtenerProfundidad(auxiliar.hijoIzquierdo),obtenerProfundidad(auxiliar.hijoDerecho)+1 );
        return auxiliar;
    }
    
    public NodoArbol rotacionDobleIzquierda(NodoArbol x){
        NodoArbol temporal;
        x.hijoIzquierdo = rotacionDerecha(x.hijoIzquierdo);
        temporal = rotacionIzquierda(x);
        return temporal;
    }
    
    public NodoArbol rotacionDobleDerecha(NodoArbol x){
        NodoArbol temporal;
        x.hijoDerecho = rotacionIzquierda(x.hijoDerecho);
        temporal = rotacionDerecha(x);
        return temporal;
    }
    
    public void insertarNuevoPersonaje(String caracteristica, String personaje,NodoArbol activo){
        String personajeActual = (String) activo.getTexto();
        NodoArbol nodoIzq = new NodoArbol(personajeActual); // Personaje actual
        NodoArbol nodoDer = new NodoArbol(personaje); // Nuevo Personaje
        activo.setTexto(caracteristica); // Caracteristica del personaje

        activo.setHijoIzquierdo(nodoDer);
        activo.setHijoDerecho(nodoIzq);
    }
    
    
    public void calcularProfundidad(NodoArbol nuevo, NodoArbol subArbol){
        if(subArbol.hijoIzquierdo==null && subArbol.hijoDerecho!= null){
            subArbol.profundidad = subArbol.hijoDerecho.profundidad+1;
        }else if(subArbol.hijoDerecho==null && subArbol.hijoIzquierdo!=null){
            subArbol.profundidad = subArbol.hijoIzquierdo.profundidad+1;
        }else {
            subArbol.profundidad = Math.max(obtenerProfundidad(subArbol.hijoIzquierdo), obtenerProfundidad(subArbol.hijoDerecho)+1);
        }    
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    public NodoArbol getRaiz(){
        return raiz;
    }
    
    
}   
