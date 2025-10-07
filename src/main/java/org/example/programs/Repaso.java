package org.example.programs;

import java.util.Scanner;

public class Repaso {
    public static void main(String[] args) {
        // 1. Va a mostrar el numero de args que tiene y luego los muestra separados por comas en una sola linea.
        // 2. Pido una cadena de texto (System.out)
        // 3. Leo esa cadena (System.in))
        // 4. Digo la longitud de lo leido (System.out)

        // * Si no hay argumentos de ejecución, que termine con código 7


       if (args.length == 0){
           System.out.println("Necesito argumentos");
           System.exit(7);
       }

       //1.
        System.out.println("En el programa hay un total de " + args.length + " argumentos.");
       for(String arg: args){
           System.out.print(arg + " , ");
       }
        System.out.println();

       //2.
        System.out.println("Dime una cadena: ");

        //3.
        Scanner s= new Scanner(System.in);
        String cadena = s.nextLine();

        //4.
        System.out.println("Longitud = " + cadena.length());
    }
}
