package ejerciciosTema1;

/*
Crea un programa llamado ReadFile que reciba como argumento de ejecución el
fichero (o el path al fichero) que se quiere leer.

El programa debe comprobar que existe este argumento de ejecución, en caso contrario
mostrará un mensaje diciendo cómo se debe ejecutar y terminará.

Si el fichero no existe, o es una carpeta, mostrará un mensaje de error informativo.

Si to_do funciona bien, mostraremos por pantalla el contenido del fichero.
 */

import java.io.*;

public class ReadFile {
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
