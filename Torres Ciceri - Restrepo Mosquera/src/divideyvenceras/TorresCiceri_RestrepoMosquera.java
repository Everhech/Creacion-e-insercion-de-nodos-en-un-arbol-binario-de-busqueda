package divideyvenceras;

//Hecho por: Edwin Orlando Restrepo M. y Andres Torres Ciceri.
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//Ordenamiento QuickSort y MergeSort
//1) El programa debe permitir escoger cuál de los dos algoritmos utilizar para hacer el
//   ordenamiento
//2) El tamaño de entrada del vector como máximo es de 30 números.
//3) Los datos a ordenar en los dos algoritmos son digitados por el usuario
//4) El trabajo es de dos estudiantes (Realizan una sola entrega por grupo)
//5) Subir al classroom el proyecto JAVA utilizando la opción de importar proyecto. El
//nombre del archivo enviado debe tener los dos apellidos de los integrantes. De igual
//forma en los archivos fuente del programa deben poner los nombres completos de cada
//integrante. Envió que no cumpla con este item no será tenido en cuenta.
public class TorresCiceri_RestrepoMosquera {

    public static void main(String[] args) {
        ArrayList<Integer> listaNum = new ArrayList(); //Se crean Los arrays para poder guardar la lista
        ArrayList<Integer> showListBefore; //Array para guardar la lista antes de realizar la operación
        boolean salir = false; //Variable para poder salir de la aplicación.
        do { //Procedimiento para repetir las opciones del menú.
            try { // Prueba el código para que no ocurran errores. Si ocurre, devuelve el error generado.
                int option = Integer.parseInt(JOptionPane.showInputDialog(null, //Opciones de menú
                        "1. Operación QuickSort\n"
                        + "2. Operacion MergeSort\n"
                        + "3. Salir\n"
                        + "Seleccione una opcion", "Menu", JOptionPane.INFORMATION_MESSAGE));
                switch (option) { //Visualiza la opción seleccionada y ejecuta los métodos que hay en el interior de ella.
                    case 1:
                        listaNum = asignarTamanio(listaNum); //Método para asignar un tamaño al array
                        showListBefore = listaNum; //Se guarda en el array para poder mostrarlo antes de modificarlo
                        if (!listaNum.isEmpty()) { //Condición para saber si la lista no está vacía, o no cumple con las restricciones
                            listaNum = QuickSort(listaNum, 0); //Método para aplicar QuickSort, involucra el array y la posición del pivote.
                            mostrar(listaNum, showListBefore); //Método para mostrar el array antes y después.
                            listaNum.clear(); //Limpia el array para poder ingresar nuevos items al array.
                        }
                        break;
                    case 2:
                        listaNum = asignarTamanio(listaNum); //Asigna tamaño al array
                        showListBefore = listaNum; //Se guarda en el array para mostrar antes
                        if (!listaNum.isEmpty()) { //Condición para saber si cumple las restricciones
                            listaNum = MergeSort(listaNum); //Método para aplicar el MergeSort
                            mostrar(listaNum, showListBefore); //Muestra el antes y después del array
                            listaNum.clear(); //Limpia el array.
                        }
                        break;
                    case 3:
                        salir = true; //Condición para la opción de salir.
                        break;
                    default:
                        break;
                }
            } catch (HeadlessException | NumberFormatException e) { //Obtiene la excepción generada por medio del error y la devuelve sin mostrar detalles.
                e.getStackTrace();
            }
        } while (salir != true); //Condición para repetir el procedimiento.
    }

    public static ArrayList asignarTamanio(ArrayList listaNum) { //Asigna el tamaño al array
        int tamanio = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el tamaño de la lista")); //Pide el tamaño
        if (tamanio > 30) { //Condición para saber si no sobrepasa de 30 items.
            JOptionPane.showMessageDialog(null, "Tamaño de la lista muy grande / Fuera de rango.", "Información", JOptionPane.ERROR_MESSAGE);
        } else if (tamanio <= 0) { //Condición para saber si el tamaño no es cero o negativo
            JOptionPane.showMessageDialog(null, "Sin tamaño de arreglo asignado / Fuera de rango.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (int i = 0; i < tamanio; i++) { //For para guardar los datos digitados por el usuario
                int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el #" + (i + 1) + " numero:")); //Se piden los números a guardar.
                listaNum.add(i, num); //Se guardan en la lista los datos registrados por el usuario.
            }
        }
        return listaNum; //Retorna la lista para empezar a utilizarla.
    }

    public static ArrayList QuickSort(ArrayList<Integer> Lista, int posicion) { //Método QuickSort
        ArrayList<Integer> izquierda = new ArrayList<>(); //Se define un array de izquierda y derecha para más facilidad.
        ArrayList<Integer> derecha = new ArrayList<>();
        int pivote; //Se asigna un pivote en el cual empezar en el array.
        if (posicion >= Lista.size()) { //Condición base para que la posición no sobrepase el tamaño del array y se repita infinitas veces la recursividad. 
            return Lista; //Retorna la lista con los datos, ya sean de izquierda o derecha.
        } else {
            pivote = Lista.get(posicion); //Se asigna el pivote para poder empezar a trabajar en el array, por medio de la variable posición, la cual aumenta en uno en cada llamado.
        }
        if (Lista.size() < 1) { //Caso base en el cual, el tamaño de la lista se reduce y devuelve el array para izquierda y derecha.
            return Lista;
        } else {
            for (int i = 0; i < Lista.size(); i++) { //For para recorrer toda la lista.
                if (Lista.get(i) < pivote) { //Condición para saber si el item en la lista es menor al pivote, guardandolo la izquierda.
                    izquierda.add(Lista.get(i));
                } else if (Lista.get(i) >= pivote) { //Condición para saber si el item es mayor al pivote, guardandolo a la derecha.
                    derecha.add(Lista.get(i));
                }
            }
        }
        Lista = devolver(izquierda, derecha, pivote); //Método para concatenar los dos arrays en un solo array y aplicar el QuickSort de nuevo.
        return QuickSort(Lista, posicion += 1); //Método recursivo para seguir con el QuickSort, donde el pivote aumentará en uno, cada posición.
    }

    public static ArrayList devolver(ArrayList<Integer> izquierda, ArrayList<Integer> derecha, int pivote) { //Devuelve el array concatenado
        ArrayList<Integer> devolver = new ArrayList<>(); //Array para concatenar los arrays de la izquierda y derecha.
        for (int i = 0; i < izquierda.size(); i++) { //Se recorre la izquierda y se guarda en el nuevo array.
            devolver.add(izquierda.get(i));
        }
        for (int i = 0; i < derecha.size(); i++) { //Se recorre el array derecho y se guarda en el array nuevo.
            devolver.add(derecha.get(i));
        }
        return devolver; // Devuelve el array ya concatenado con todos los items modificados.
    }

    public static ArrayList MergeSort(ArrayList<Integer> lista) { //Método MergeSort
        int TamanioIzquierda = lista.size() / 2; //Se define un tamaño a utilizar, se parte a la mitad el array y se guarda en la variable.
        ArrayList<Integer> izquierda = new ArrayList<>(); //Se crean los arrays para poder trabajar de izquierda a derecha, generando así un resultado.
        ArrayList<Integer> result;
        ArrayList<Integer> derecha = new ArrayList<>();
        if (lista.size() < 2) { //Caso base para no repetir infinitas veces el método recursivo.
            return lista;
        } //Se guardan en izquierda y derecha, las cuales se tratan como particiones del array original.
        for (int i = 0; i < TamanioIzquierda; i++) { //Se recorre el array hasta la mitad y se guarda a la izquierda. No se toma el valor en la mitad.
            izquierda.add(i, lista.get(i));
        }
        for (int i = TamanioIzquierda; i < lista.size(); i++) { //Se recorre el array hasta el tamaño de la lista, empezando desde la mitad. Se toma el valor en la mitad.
            derecha.add(i - TamanioIzquierda, lista.get(i)); //Se guarda en el array derecha, para trabajar con particiones.
        }
        izquierda = MergeSort(izquierda); //Se aplica de nuevo el MergeSort, para obtener los casos bases. Es decir, se divide todo el sector izquierdo hasta llegar a dos items.
        derecha = MergeSort(derecha); //Se aplica el MergeSort, dividiendo todo el sector derecho, hasta llegar a dos items.
        result = merge(izquierda, derecha); // Método para aplicar el MergeSort, es decir, agregar en un nuevo array, los items ya organizados.
        return result; //Devuelve el array para poder mostrarlo.
    }

    public static ArrayList merge(ArrayList<Integer> izquierda, ArrayList<Integer> derecha) { //Método para organizar los datos.
        int puntoIzq = 0, puntoDer = 0, puntoResult = 0; //Se asignan unos puntos de inicio, para los arreglos a utilizar.
        ArrayList<Integer> result = new ArrayList<>(); //Se crea el array donde se guardarán los datos ya organizados.
        while (puntoIzq < izquierda.size() || puntoDer < derecha.size()) { //Condición para que se guarden correctamente los datos, de menor a mayor.
            if (puntoIzq < izquierda.size() && puntoDer < derecha.size()) { //Comprobación, en la cual, se estará observando si un punto no sobrepase la capacidad del arreglo.
                if (izquierda.get(puntoIzq) < derecha.get(puntoDer)) { //Comparación del sector izquierdo con el sector derecho, para saber si es menor.
                    result.add(puntoResult++, izquierda.get(puntoIzq++)); //Si es menor, se agrega en el nuevo array, aumentando así los puntos de inicio, para que no se repita infinitas veces.
                } else {
                    result.add(puntoResult++, derecha.get(puntoDer++)); //Si es mayor, se agrega y se aumenta los puntos de inicio, para que no se repita.
                }
            } else if (puntoIzq < izquierda.size()) { //Condición en la cual, guardará en la izquierda, si a la derecha ha sobrepasado su límite.
                result.add(puntoResult++, izquierda.get(puntoIzq++));
            } else if (puntoDer < derecha.size()) { //Condición que guardará a la derecha, si a la izquierda se sobrepasó el límite.
                result.add(puntoResult++, derecha.get(puntoDer++));
            }
        }
        return result; //Devuelve el arreglo con los datos ya organizados.
    }

    public static void mostrar(ArrayList<Integer> lista, ArrayList<Integer> showListBefore) { //Método mostrar.
        String mensajeAntes = "", mensajeDespues = ""; //Se asignan dos Strings, los cuales mostrarán el antes y después del array.
        for (int i = 0; i < showListBefore.size(); i++) { //For para mostrar el array antes de aplicar la operación seleccionada.
            mensajeAntes += showListBefore.get(i) + " "; //Se concatena los números, para generar una cadena.
        }
        JOptionPane.showMessageDialog(null, "Lista antes de aplicar la operacion: " + mensajeAntes, "QuickSort - MergeSort", JOptionPane.INFORMATION_MESSAGE); //Se muestra la lista antes.
        for (int i = 0; i < lista.size(); i++) { //For para mostrar el array, ya organizado completamente.
            mensajeDespues += lista.get(i) + " "; //Se concatena en el String, generando una cadena.
        }
        JOptionPane.showMessageDialog(null, "Lista después de aplicar la operacion: " + mensajeDespues, "QuickSort - MergeSort", JOptionPane.INFORMATION_MESSAGE); //Muestra el después.
    }
}
