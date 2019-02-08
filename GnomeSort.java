/*
 * Hoja de trabajo No.3
 * Algoritmos y Estructuras de Datos
 * Created by Maria Isabel Ortiz Naranjo 18176
 * Created by Diego Estrada 18540
 *  Clase GnomeSort
 */
public class GnomeSort {
    //Extraido de: https://en.wikibooks.org/wiki/Algorithm_Implementation/Sorting/Gnome_sort

    static void gnomeSort(int[] theArray) {
        for (int index = 1; index < theArray.length; ) {
            if (theArray[index - 1] <= theArray[index]) {
                ++index;
            } else {
                int tempVal = theArray[index];
                theArray[index] = theArray[index - 1];
                theArray[index - 1] = tempVal;
                --index;
                if (index == 0) {
                    index = 1;
                }
            }
        }
    }
}
