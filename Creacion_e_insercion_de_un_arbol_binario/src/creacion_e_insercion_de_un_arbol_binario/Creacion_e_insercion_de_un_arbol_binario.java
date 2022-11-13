/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creacion_e_insercion_de_un_arbol_binario;

import javax.swing.JOptionPane;

/**
 *
 * @author Edwin O. Restrepo
 */
public class Creacion_e_insercion_de_un_arbol_binario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ArbolBinario arbol = new ArbolBinario();
            while (true) {
                int option = Integer.parseInt(JOptionPane.showInputDialog(null, "Opciones: "
                        + "\n1.Insertar un nuevo nodo"
                        + "\n2.Recorrido inOrden"
                        + "\n3.Recorrido preOrden"
                        + "\n4.Recorrido posOrden"
                        + "\n5.Buscar nodo en el arbol"
                        + "\n6.Eliminar nodo en el arbol"
                        + "\n7.Salir"
                        + "\nOpcion:", "Árbol Binario", JOptionPane.QUESTION_MESSAGE));
                switch (option) {
                    case 1:
                        int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el valor del nodo", "Insertando Nodo", JOptionPane.INFORMATION_MESSAGE));
                        String nombre = JOptionPane.showInputDialog(null, "Digite el nombre del nodo", "Insertando Nodo", JOptionPane.INFORMATION_MESSAGE);
                        arbol.insertarNodo(dato, nombre);
                        break;
                    case 2:
                        if (!arbol.estaVacio()) {
                            arbol.inOrdenRecursivo(arbol.raiz);
                            System.out.print("\n\n");
                        } else {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 3:
                        if (!arbol.estaVacio()) {
                            arbol.preOrdenRecursivo(arbol.raiz);
                            System.out.print("\n\n");
                        } else {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 4:
                        if (!arbol.estaVacio()) {
                            arbol.posOrdenRecursivo(arbol.raiz);
                            System.out.print("\n\n");
                        } else {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 5:
                        if (!arbol.estaVacio()) {
                            dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el valor del nodo a buscar", "Buscando Nodo", JOptionPane.INFORMATION_MESSAGE));
                            if (arbol.busquedaNodo(dato) == null) {
                                JOptionPane.showMessageDialog(null, "El nodo no se encontró", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "El nodo con valor " + arbol.busquedaNodo(dato).dato + " se encontró y se llama " + arbol.busquedaNodo(dato).nombre, "Nodo Encontrado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 6:
                        if (!arbol.estaVacio()) {
                            dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el valor del nodo a eliminar", "Eliminar Nodo", JOptionPane.INFORMATION_MESSAGE));
                            if (arbol.eliminarNodo(dato) == false) {
                                JOptionPane.showMessageDialog(null, "El nodo no se encontró", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "El nodo ha sido eliminado del árbol", "Nodo Eliminado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Aplicación finalizada", "Fin", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                        return;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }

}
