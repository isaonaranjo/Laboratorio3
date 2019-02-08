/*
 * Hoja de trabajo No.3
 * Algoritmos y Estructuras de Datos
 * Created by Maria Isabel Ortiz Naranjo 18176
 * Created by Diego Estrada 18540
 *  Generador de numeros aleatorios
 */
import java.util.Arrays;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

class Generator{

    public static void main(String[] args) {
        System.out.println(">> Que nombre desea ponerle a su archivo de texto <<\n");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        Random random = new Random();
        String output = "";
        for(int i=0;i<2999;i++){
            output = output + " ";
            int n = random.nextInt(500);
            output = output + Integer.toString(n);
        }
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileName), "utf-8"));
            writer.write(output);
        } catch (IOException ex) {
        } finally {
            try {writer.close();} catch (Exception ex) {}
        }

    }
}