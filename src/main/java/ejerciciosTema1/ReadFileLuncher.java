package ejerciciosTema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
Modifica el ejercicio 4, llámalo ReadFileLauncherv2, y ahora preguntará por Scanner si se quiere mostrar por p
antalla el contenido del fichero o si se quiere guardar en otro fichero. En caso de elegir guardarlo en otro fichero,
pide el nombre y guarda ahí el contenido del fichero que estás leyendo.

De nuevo, en este ejercicio no podemos utilizar ningún stream de lectura de ficheros, solamente redirecciones de
salidas de procesos hijos.
 */
public class ReadFileLuncher {
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        System.out.println("Fichero a leer: ");
        String f= s.nextLine();

        //Construir el processBuilder
        ProcessBuilder pb =  new ProcessBuilder("java", "-jar", "ReadFilev2.jar", f);
        try {
            Process p = pb.start();
            int code = p.waitFor();

            if (code == 0){
                try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))){
                    String line="";
                    while ((line = br.readLine()) != null){
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
