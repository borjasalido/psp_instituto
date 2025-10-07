package org.example.lunchers;

/*
    Haz un programa que lance Factorial, y que recoja el resultado o el cñódigo de finalización
    si ha haido algún error.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LanzarFactorial {
    public static void main(String[] args) {

        Scanner s= new Scanner(System.in);

        System.out.println("Dime de que quieres hacer el factorial: ");
        String argumento= s.next();
        String[] programa={"java", "-jar", "/home/borja/IdeaProjects/psp-introduction/out/artifacts/factorial/psp-borja.jar", argumento};
        ProcessBuilder pb= new ProcessBuilder(programa);

        try {
            Process p= pb.start();

            //Para redirigir la salida estandar del subproceso hijo,
            //voy a envolver s estram de salida en un BufferReadder, para leerlo desde aqui
            InputStream is= p.getInputStream();
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader br= new BufferedReader(isr);

            String result= br.readLine();
            System.out.println("-----> " + result);

            int codeExit = p.waitFor();
            System.out.println("El codigo de finalizacion es = " + codeExit);

            //Aqui utilizo el stream y cuando termine:
            //el br.close() se puede quitar con un try(______){
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
