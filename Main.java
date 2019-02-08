/*
 * Hoja de trabajo No.3
 * Algoritmos y Estructuras de Datos
 * Created by Maria Isabel Ortiz Naranjo 18176
 * Created by Diego Estrada 18540
 *  Main para el uso de los distintos Sorts
 */
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
    //Crear los distintos Sorts para ser utilizados posteriormente
     GnomeSort gs = new GnomeSort();
     MergeSort ms = new MergeSort();
     QuickSort qs = new QuickSort();
     RadixSort rs = new RadixSort();
     CombSort cs = new CombSort();

     System.out.println("===================================================================================================\n" +
                "Escriba el nombre del archivo con la serie de numeros a ordenar, seguido de la terminacion '.txt'..\n" +
                "===================================================================================================\n");
     //Se pide el nombre del archivo que contiene los numeros
     Scanner sc = new Scanner(System.in);
     String selectedFile = sc.nextLine();

     File fileToRead = new File(selectedFile);
     BufferedReader br = null;
     FileReader fr = null;
     String msg ="";

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            System.out.println("\n>> Leyendo los numeros del fichero: " + selectedFile + "<<\n");

            fr = new FileReader (selectedFile);
            br = new BufferedReader(fr);

            // Lectura del fichero
            while((msg=br.readLine())!=null){
                System.out.println("Lectura exitosa...\n");
                String[] dataArray = msg.split(" ");//Array que contiene los numeros del archivo .txt
                int[] arrayToSort = new int[dataArray.length];//Array para ordenar.

                //Asignacion de valores a array a ser ordenado
                for (int index=1; index<dataArray.length; index++) {
                    arrayToSort[index] = Integer.valueOf(dataArray[index]);
                }
                //Menu
                System.out.println("Escoja el sort que desea hacer: \n" +
                        "1.GnomeSort\n" +
                        "2.MergeSort\n" +
                        "3.QuickSort\n" +
                        "4.RadixSort\n" +
                        "5.CombSort\n");
                Scanner sc1 = new Scanner(System.in);
                int numOption = sc1.nextInt();
                //En caso de que seleccione las distintas opciones
                switch (numOption){
                    case 1: gs.gnomeSort(arrayToSort);//GnomeSort
                        break;
                    case 2: ms.sort(arrayToSort,0,arrayToSort.length-1);//MergeSort
                        break;
                    case 3: qs.quickSort(arrayToSort,0,arrayToSort.length-1);//QuickSort
                        break;
                    case 4: rs.radixsort(arrayToSort,arrayToSort.length);//RadixSort
                        break;
                    case 5: cs.sort(arrayToSort);//CombSort
                        break;
                    default:
                        System.out.println("Numero invalido, agrega uno entre 1 y 5");
                }
                //Escribe el archivo con el array ordenado
                Writer writer = null;
                try {
                    writer = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream(selectedFile), "utf-8"));
                    for (int i=0; i<arrayToSort.length;i++){
                        writer.write(arrayToSort[i]+" ");
                    }
                } catch (IOException ex) {
                } finally {
                    try {writer.close();} catch (Exception ex) {}
                };
                break;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
     }
}
