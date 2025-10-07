package ejerciciosTema1;
/*
Crea el programa Launcher, que será un ejecutador (launcher) de programas instalados en el ordenador. Para ello:

Pide a la persona usuaria por Scanner un programa a ejecutar. Si se introduce “ESC” se termina el programa.
Ejecútalo y muestra por pantalla el id de ese proceso (pid).
Espera 10 segundos o hasta que se cierre el proceso. Trascurrido este tiempo, vuelve al punto 1 hasta que se introduzca “ESC”.
El programa deberá tener prueba de errores: no debe finalizar si el proceso no existe, sino mostrar un mensaje de error y continuar
su funcionamiento normal.

Si estás en Ubuntu, puedes lanzar los programas instalados gnome-text-editor (editor de textos), gnome-calculator (calculadora),
eog (visor de imágenes), rhythmbox (reproductor de música), gnome-terminal (una terminal), nautilus (explorador de archivos)... Aquí puedes consultar las que
vienen instaladas por defecto.
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Luncher {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Dime que programa quieres ejecutar: ");
        String app= "";
        while (!app.equalsIgnoreCase("ESC")) {
            System.out.print("Programa: ");
            app = s.nextLine();
            ProcessBuilder pb = new ProcessBuilder(app);
            try {
                Process p = pb.start();
                System.out.println(p.pid());
                p.waitFor(10, TimeUnit.SECONDS);
            } catch (IOException e) {
                System.out.println("No existe el programa");
            } catch (InterruptedException e) {
                System.out.println("Error en la espera del proceso");
            }
        }
    }
}
