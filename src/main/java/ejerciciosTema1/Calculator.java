package ejerciciosTema1;
/*
Crea el programa Calculator. Recibirá tres argumentos de ejecución:

El primer operando (un número double)
El segundo operando (un número double)
El operador (un char que puede ser +, -, *, / o % dependiendo de la operación).
En caso de que no se respete el número de argumentos o que su formato esté mal, se imprime un mensaje de error informando qué ha sucedido.

Si to do funciona bien, mostrar por pantalla el resultado de la operación.

Por ejemplo, si se ejecuta java -jar Calculadora.jar 3.4 5.7 +, el resultado será 9.1.
 */
public class Calculator {
    public static void main(String[] args) {
        if(args.length != 3){
            System.err.println("Argumentos incorrectos.");
            System.exit(1);
        }

        double num1= 0.0, num2 = 0.0;
        String op="";
        try {
            num1 = Double.parseDouble(args[0]);
            num2 = Double.parseDouble(args[1]);
            op = args[2];
        }catch (NumberFormatException e){
            System.err.println("Argumentos incorrectos.");
            System.exit(2);
        }

        //Calculadora
        switch (op){
            case  "+" :
                System.out.println(num1 + num2);
                break;
            case "-" :
                System.out.println(num1 - num2);
                break;
            case "*" :
                System.out.println(num1 * num2);
                break;
            case "/":
                System.out.println(num1 / num2);
                break;
            default:
                System.out.println("Operador no conocido");
        }
    }
}
