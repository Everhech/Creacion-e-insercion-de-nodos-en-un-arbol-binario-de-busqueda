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
public class ArbolBinario {

    NodoArbol raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    //Método para insertar un nuevo nodo en el arbol
    public void insertarNodo(int dato, String nombre) {
        NodoArbol aux = new NodoArbol(dato, nombre);
        if (raiz == null) {
            raiz = aux;
        } else {
            NodoArbol nuevo = raiz;
            NodoArbol padre;
            while (true) {
                padre = nuevo;
                if (dato < nuevo.dato) {
                    nuevo = nuevo.hijoIzquierdo;
                    if (nuevo == null) {
                        padre.hijoIzquierdo = aux;
                        return;
                    }
                } else {
                    nuevo = nuevo.hijoDerecho;
                    if (nuevo == null) {
                        padre.hijoDerecho = aux;
                        return;
                    }
                }
            }
        }
    }

    //Método para saber si el arbol está vacío
    public boolean estaVacio() {
        return raiz == null;
    }

    //Método de recorrido inOrden
    public void inOrdenRecursivo(NodoArbol raiz) {
        if (raiz != null) {
            inOrdenRecursivo(raiz.hijoIzquierdo);
            System.out.print(raiz.dato + " ");
            inOrdenRecursivo(raiz.hijoDerecho);
        }
    }

    //Método de recorrido PreOrden
    public void preOrdenRecursivo(NodoArbol raiz) {
        if (raiz != null) {
            System.out.print(raiz.dato + " ");
            preOrdenRecursivo(raiz.hijoIzquierdo);
            preOrdenRecursivo(raiz.hijoDerecho);
        }
    }

    //Método de recorrido PosOrden
    public void posOrdenRecursivo(NodoArbol raiz) {
        if (raiz != null) {
            posOrdenRecursivo(raiz.hijoIzquierdo);
            posOrdenRecursivo(raiz.hijoDerecho);
            System.out.print(raiz.dato + " ");
        }
    }

    //Método de busqueda de un nodo en el árbol
    public NodoArbol busquedaNodo(int dato) {
        NodoArbol auxiliar = raiz;
        while (auxiliar.dato != dato) {
            if (dato < auxiliar.dato) {
                auxiliar = auxiliar.hijoIzquierdo;
            } else {
                auxiliar = auxiliar.hijoDerecho;
            }
            if (auxiliar == null) {
                return null;
            }
        }
        return auxiliar;
    }

    //Método de eliminación de un nodo
    public boolean eliminarNodo(int dato) {
        NodoArbol aux = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzq = true;
        while (aux.dato != dato) {
            padre = aux;
            if (dato < aux.dato) {
                esHijoIzq = true;
                aux = aux.hijoIzquierdo;
            } else {
                esHijoIzq = false;
                aux = aux.hijoDerecho;
            }
            if (aux == null) {
                return false;
            }
        } //Fin del While
        if (aux.hijoIzquierdo == null && aux.hijoDerecho == null) {
            if (aux == raiz) {
                raiz = null;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = null;
            } else {
                padre.hijoDerecho = null;
            }
        } else if (aux.hijoDerecho == null) {
            if (aux == raiz) {
                raiz = aux.hijoIzquierdo;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = aux.hijoIzquierdo;
            } else {
                padre.hijoDerecho = aux.hijoIzquierdo;
            }
        } else if (aux.hijoIzquierdo == null) {
            if (aux == raiz) {
                raiz = aux.hijoDerecho;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = aux.hijoDerecho;
            } else {
                padre.hijoDerecho = aux.hijoDerecho;
            }
        } else {
            NodoArbol reemplazo = obtenerNodoReemplazo(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = reemplazo;
            } else {
                padre.hijoDerecho = reemplazo;
            }
            reemplazo.hijoIzquierdo = aux.hijoIzquierdo;
        }
        return true;
    }

    //Método para devolver el Nodo para reemplazar
    public NodoArbol obtenerNodoReemplazo(NodoArbol nodoRemplazo) {
        NodoArbol reemplazarPadre = nodoRemplazo;
        NodoArbol reemplazo = nodoRemplazo;
        NodoArbol auxiliar = nodoRemplazo.hijoDerecho;
        while (auxiliar != null) {
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.hijoIzquierdo;
        }
        if (reemplazo != nodoRemplazo.hijoDerecho) {
            reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = nodoRemplazo.hijoDerecho;
        }
        System.out.println("\nEl nodo reemplazo es: " + reemplazo);
        return reemplazo;
    }
}
