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
    static void quickSort(int[] v, int left, int right){
        int p = v[left];
        int i = left;
        int j = right;
        int aux;
        while (i < j) {
            while (v[i] <= p && i < j) {
                i++;
            }
            while (v[j] > p) {
                j--;
            }
            if (i < j) {
                aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
        }
        v[left] = v[j];
        v[j] = p;
        if (left < j - 1) {
            quickSort(v, left, j - 1);
        }
        if (j + 1 < right) {
            quickSort(v, j + 1, right);
        }
    }
}
