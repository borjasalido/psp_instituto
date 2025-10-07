package ejerciciosTema1;

/*
Modifica el ejercicio 1 con un nuevo programa que se llame ReadFilev2 que tendrá la misma funcionalidad.
Añade códigos de finalización en caso de que haya errores:

1 si no se han introducido bien los argumentos de ejecución.
2 si el fichero no existe.
3 si es una carpeta y no un fichero.
4 otros.
Crea el programa ReadFileLauncher que preguntará por el Scanner un fichero a leer y lanzará como proceso el programa
creado ReadFilev2. Es importante que recuerdes que este programa nunca utilizará ningún stream de lectura de ficheros,
simplemente lanzará ReadFilev2 con ProcessBuilder o Runtime.

Redirecciona entradas y/o salidas estándar para que se vea toda la información del fichero.


 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFilev2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Falta el argumento de ejecución con el fichero");
            System.exit(3);
        }
        File file = new File(args[0]);
        if (!file.isFile()) {
            System.out.println("No es un fichero");
            System.exit(4);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
