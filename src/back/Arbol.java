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
    
    public NodoArbol insertarNodoIzquierda(NodoArbol nuevo, NodoArbol activo){
        
        NodoArbol nuevoPadre = activo;
        if(activo.hijoIzquierdo==null){
            activo.hijoIzquierdo = nuevo;
        }else{
            NodoArbol temporal = activo.hijoIzquierdo;
            activo.hijoIzquierdo = nuevo;
            nuevo.hijoIzquierdo = temporal;
            if(obtenerProfundidad(activo.hijoIzquierdo)-obtenerProfundidad(activo.hijoDerecho)==2){
                if(activo.hijoIzquierdo==null){
                    nuevoPadre = rotacionIzquierda(activo);
                }else{
                    nuevoPadre = rotacionDobleIzquierda(activo);
                }
            }
        }
        if(activo.hijoIzquierdo==null && activo.hijoDerecho!= null){
            activo.profundidad = activo.hijoDerecho.profundidad+1;
        }else if(activo.hijoDerecho==null && activo.hijoIzquierdo!=null){
            activo.profundidad = activo.hijoIzquierdo.profundidad+1;
        }else {
            activo.profundidad = Math.max(obtenerProfundidad(activo.hijoIzquierdo), obtenerProfundidad(activo.hijoDerecho)+1);
        }
        return nuevoPadre;
    }
    
    public NodoArbol insertarNodoDerecha(NodoArbol nuevo, NodoArbol activo){
        NodoArbol nuevoPadre = activo;
        if(activo.hijoDerecho==null){
            activo.hijoDerecho = nuevo;
        }else{
           NodoArbol temporal = activo.hijoDerecho;
            activo.hijoDerecho = nuevo;
            nuevo.hijoDerecho = temporal;
            if(obtenerProfundidad(activo.hijoIzquierdo)-obtenerProfundidad(activo.hijoDerecho)==2){
                if(activo.hijoDerecho==null){
                    nuevoPadre = rotacionIzquierda(activo);
                }else{
                    nuevoPadre = rotacionDobleIzquierda(activo);
                }
            }
        }
        if(activo.hijoIzquierdo==null && activo.hijoDerecho!= null){
            activo.profundidad = activo.hijoDerecho.profundidad+1;
        }else if(activo.hijoDerecho==null && activo.hijoIzquierdo!=null){
            activo.profundidad = activo.hijoIzquierdo.profundidad+1;
        }else {
            activo.profundidad = Math.max(obtenerProfundidad(activo.hijoIzquierdo), obtenerProfundidad(activo.hijoDerecho)+1);
        }
        return nuevoPadre;
    }
    
    /*
    public NodoArbol insertarAvl(NodoArbol nuevo, NodoArbol subArbol){
        NodoArbol nuevoPadre = subArbol;
        if(nuevo.texto<subArbol.texto){
            if(subArbol.hijoIzquierdo==null){
                subArbol.hijoIzquierdo = nuevo;
            }else{
                subArbol.hijoIzquierdo = insertarAvl(nuevo, subArbol.hijoIzquierdo);
                if(obtenerProfundidad(subArbol.hijoIzquierdo)-obtenerProfundidad(subArbol.hijoDerecho)==2){
                    if(nuevo.texto<subArbol.hijoIzquierdo.texto){
                        
                        nuevoPadre = rotacionIzquierda(subArbol);
                    }else{
                        nuevoPadre = rotacionDobleIzquierda(subArbol);
                    }
                }
            }
            
        }else if(nuevo.texto>subArbol.texto){
            if(subArbol.hijoDerecho==null){
                subArbol.hijoDerecho = nuevo;
            }else{
                subArbol.hijoDerecho = insertarAvl(nuevo, subArbol.hijoDerecho)
                if(obtenerProfundidad(subArbol.hijoDerecho)-obtenerProfundidad(subArbol.hijoIzquierdo)==2){
                    if(nuevo.texto>subArbol.hijoDerecho.texto){
                        nuevoPadre = rotacionDerecha(subArbol);
                    }else{
                        nuevoPadre = rotacionDobleDerecha(subArbol);
                    }
                }
            }
            
        }
        
        if(subArbol.hijoIzquierdo==null && subArbol.hijoDerecho!= null){
            subArbol.profundidad = subArbol.hijoDerecho.profundidad+1;
        }else if(subArbol.hijoDerecho==null && subArbol.hijoIzquierdo!=null){
            subArbol.profundidad = subArbol.hijoIzquierdo.profundidad+1;
        }else {
            subArbol.profundidad = Math.max(obtenerProfundidad(subArbol.hijoIzquierdo), obtenerProfundidad(subArbol.hijoDerecho)+1);
        }
        return nuevoPadre;
    }
    */
    
    public void calcularProfundidad(NodoArbol nuevo, NodoArbol subArbol){
        if(subArbol.hijoIzquierdo==null && subArbol.hijoDerecho!= null){
            subArbol.profundidad = subArbol.hijoDerecho.profundidad+1;
        }else if(subArbol.hijoDerecho==null && subArbol.hijoIzquierdo!=null){
            subArbol.profundidad = subArbol.hijoIzquierdo.profundidad+1;
        }else {
            subArbol.profundidad = Math.max(obtenerProfundidad(subArbol.hijoIzquierdo), obtenerProfundidad(subArbol.hijoDerecho)+1);
        }    
    }
    
    public void insertarRaiz (NodoArbol raiz, NodoArbol hijoDerecho){
        this.raiz = raiz;
        raiz.hijoDerecho = hijoDerecho;
    }
    
    public NodoArbol getRaiz(){
        return raiz;
    }
    
    
}   
