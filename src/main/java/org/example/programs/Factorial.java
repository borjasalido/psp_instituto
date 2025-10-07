package org.example.programs;

/*
El programa va a tener argumentos de ejecución:
    - Si se ejecita Factorial.jar 6, el programa devolverá el factorial de 6
    - Si se ejecita Factorial.jar sin args, terminará con código 1
    - Si se ejecita Factorial.jar con más de un arg, terminará con cñodigo 2
    - Si se ejecita Factorial.jar con un arg, pero no es Int, terminara con código 3
 */

public class Factorial {
    public static void main(String[] args) {

        //Compruebo que hay 1 arg:
        if (args.length == 0){
            System.out.println("Falta el argumento de ejecución");
            System.exit(1); //Código de finalización.
        }else if(args.length > 1){
            System.out.println("Solo es posible un argumento de ejecución");
            System.exit(2); //Código de finalización.
        }

        int number= 0;
        try {
            number= Integer.parseInt(args[0]);
        }catch (NumberFormatException e){
            System.out.println("El argumento no es un número entero");
            System.exit(3); //Código de finalización
        }

        //Factorial
        int factorial= 1;
        for (int i = 1; i <= number ; i++) {
            factorial *= i;
        }
        factorial = factorial + 1;

        System.out.println("El factorial es = " + factorial);

    }
}
