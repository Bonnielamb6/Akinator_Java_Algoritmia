
package back;

public class Arbol {
    private NodoArbol raiz;
  
    public void insertarNuevoPersonaje(String caracteristica, String personaje, String imagen ,NodoArbol activo){
        String personajeActual = (String) activo.getTexto();
        String imagenActual = (String) activo.getImg();
        NodoArbol nodoIzq = new NodoArbol(personajeActual); // Personaje actual
        NodoArbol nodoDer = new NodoArbol(personaje); // Nuevo Personaje
        activo.setTexto(caracteristica); // Caracteristica del personaje

        activo.setHijoIzquierdo(nodoIzq);
        nodoIzq.setImg(imagenActual);
        activo.setHijoDerecho(nodoDer);
        nodoDer.setImg(imagen);
    }
    
    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    
    public NodoArbol equilibrarArbol(NodoArbol activo){
        if (activo == null){
            return null;
        }else{

            int factorBalance = calcularFactorBalance(activo);

            if (factorBalance > 1){

                if (calcularFactorBalance(activo.getHijoIzquierdo()) < 0){
                    activo.hijoIzquierdo = rotarIzquierda(activo.hijoIzquierdo);
                }
                activo = rotarDerecha(activo);

            } else if (factorBalance < -1){

                if (calcularFactorBalance(activo.hijoDerecho) > 0){
                    activo.hijoDerecho = rotarDerecha(activo.hijoDerecho);
                }
                activo = rotarIzquierda(activo);

            }

            activo.hijoIzquierdo = equilibrarArbol(activo.hijoIzquierdo);
            activo.hijoDerecho = equilibrarArbol(activo.hijoDerecho);

            return activo;
        }
    }

    private int calcularAltura(NodoArbol activo){
        if (activo == null){
            return 0;
        }else{
            return  Math.max(calcularAltura(activo.hijoIzquierdo), calcularAltura(activo.hijoDerecho))+1 ;
        }
        
    }

    private int calcularFactorBalance(NodoArbol activo){
        if (activo == null){
            return 0;
        }

        return calcularAltura(activo.hijoIzquierdo) - calcularAltura(activo.hijoDerecho);
    }

    private NodoArbol rotarIzquierda(NodoArbol activo){
        NodoArbol nuevoNodoArbolActual = activo.hijoDerecho;
        activo.hijoDerecho = nuevoNodoArbolActual.hijoIzquierdo;
        nuevoNodoArbolActual.hijoIzquierdo = activo;
        return nuevoNodoArbolActual;
    }

    private NodoArbol rotarDerecha(NodoArbol activo) {
        NodoArbol nuevoNodoArbolActual = activo.hijoIzquierdo;
        activo.hijoIzquierdo = nuevoNodoArbolActual.hijoDerecho;
        nuevoNodoArbolActual.hijoDerecho = activo;
        return nuevoNodoArbolActual;
    }
    
    
}   
