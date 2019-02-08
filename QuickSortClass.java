package com.company;
/*
 * Hoja de trabajo No.3
 * Algoritmos y Estructuras de Datos
 * Created by Maria Isabel Ortiz Naranjo 18176
 * Created by Diego Estrada 18540
 *  Clase QuickSort
 */
public class QuickSortClass {
    // Extraido de: https://es.stackoverflow.com/questions/7836/c%C3%B3mo-funciona-el-algoritmo-de-quicksort
    static void quickSort(int[] vector, int left, int right){
        int p = vector[left];
        int i = left;
        int j = right;
        int auxIntercambio;
        while (i < j) {
            while (vector[i] <= p && i < j) {
                i++;
            }
            while (vector[j] > p) {
                j--;
            }
            if (i < j) {
                auxIntercambio = vector[i];
                vector[i] = vector[j];
                vector[j] = auxIntercambio;
            }
        }
        vector[left] = vector[j];
        vector[j] = p;
        if (left < j - 1) {
            quickSort(vector, left, j - 1);
        }
        if (j + 1 < right) {
            quickSort(vector, j + 1, right);
        }
    }
}
