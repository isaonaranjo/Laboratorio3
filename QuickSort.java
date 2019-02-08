/*
 * Hoja de trabajo No.3
 * Algoritmos y Estructuras de Datos
 * Created by Maria Isabel Ortiz Naranjo 18176
 * Created by Diego Estrada 18540
 *  Clase QuickSort
 */
public class QuickSort {
    // Extraido de: https://es.stackoverflow.com/questions/7836/c%C3%B3mo-funciona-el-algoritmo-de-quicksort
    static void quickSort(int[] v, int left, int right){
        // Se elige el pivote
        int p = v[left];
        // Los elementos > al pivote van a su derecha, los < a su izquierda
        //esta parte de la implementación es el corazón del ordenamiento
        //se utilizan variables auxiliares:
        //- i para controlar los elementos a la izquierda del pivote
        //- j para controlar los elementos a la derecha del pivote
        int i = left;
        int j = right;
        int aux;
        //mientras que deban evaluarse los elementos en el arreglo
        //para ubicar al nuevo pivote
        while (i < j) {
            while (v[i] <= p && i < j) {
                i++;
            }
            //se desminuye el valor de j
            //cuando este loop se detenga, el elemento en vector[j]
            //es menor o igual a pivote y deberá ir a su izquierda
            while (v[j] > p) {
                j--;
            }
            //siempre y cuando i sea menor a j, se hace un cambio de los elementos
            //puesto que el elemento en vector[i] debe ir a la derecha
            //y vector[j] a la izquierda
            if (i < j) {
                aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
        }
        // j llegó a una posición donde su elemento
        //es menor o igual al pivote, actualizamos entonces la posición del pivote, mandando vector[j]
        //a la ubicación del pivote y viceversa (el pivote a la posicion vector[j])

        v[left] = v[j];
        v[j] = p;
        if (left < j - 1) {
            //quicksort aplicado a A1

            quickSort(v, left, j - 1);
        }
        if (j + 1 < right) {
            //quicksort aplicado a A2
            quickSort(v, j + 1, right);
        }
    }
}
