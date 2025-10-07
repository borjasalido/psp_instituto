package org.example.programs;

// Que imprima por salida estándar el mensaje "queé quieres saber"?
//Que lea entrada estándar (Scanner de System.in) las palabras "nombre", "edad" o "curso"
//Que imprima por salida estándar el dato correspondiente
//Si ha metido una palabra diferente a "nombre", "edad" o "curso", que finalice con código 10

import java.util.Scanner;

public class PersonalData {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("¿Qué quieres saber?");
        String valor= s.nextLine();

        if (valor.equals("nombre")){
            System.out.println("Borja");
        }else if (valor.equals("edad")) {
            System.out.println("19");
        }else if (valor.equals("curso")){
            System.out.println("2 DAM");
        }else {
            System.out.println("No te entiendo");
            System.exit(10);
        }

    }
}
