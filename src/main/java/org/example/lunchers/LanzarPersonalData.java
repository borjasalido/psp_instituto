package org.example.lunchers;

import java.io.*;
import java.util.Scanner;

public class LanzarPersonalData {
    public static void main(String[] args) {

        //1. Lanza el jar de PErsonalData

        //2. Imprime la salida de PersonalData ("¿Qué quieres saber?")

        //3. Pido por entrada estandar que introduczca SOLAMENTE "n", "e", "c"

        //4. Si ha introducido n, envio "nombre" al subproceso
        //4. Si ha introducido e, envio "edad" al subproceso
        //4. Si ha introducido c, envio "curso" al subproceso
        //4. Si ha introducido otra cosa, se lo envio tal cual al subproceso

        //5. Recojo el código de finalización e imprimo el system.out


        Scanner s = new Scanner(System.in);
        System.out.println("Introduce SOLAMENTE n e c");
        String entrada = s.nextLine();


        String[] programa = {"java", "-jar", "/home/borja/IdeaProjects/psp-introduction/out/artifacts/personal_data/psp-borja.jar", entrada};
        ProcessBuilder pb = new ProcessBuilder(programa);

        try {
            Process p = pb.start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));) {

                //2. Imprime la salida de PersonalData ("¿Qué quieres saber?")
                System.out.println(br.readLine());
                //br.readLine();

                /*
                Esto son pruebas para ver que funciona mi programa
                bw.write("nombre\n");   //Necesito poner el \n porque en el subproceso se utiliza .nextLine()
                // es decir, lee hasta que encuentre el salto de línea.
                bw.flush(); //Hace que se vacíe el buffer de BufferedWriter y se envíe (al subproceso)
                System.out.println(br.readLine());
                 */

                //3. Pido por entrada estandar que introduzca SOLAMENTE "n", "e", o "c"
                Scanner sc = new Scanner(System.in);
                String line = sc.nextLine();

                //4. Si ha introducido n, envío "nombre" al subproceso
                //Si ha introducido e, envío "edad" al subproceso
                //Si ha introducido c, envío "curso" al subproceso
                //Si ha introducido otra cosa, se la envío tal cual al subproceso
                String enviar = "";
                switch (line) {
                    case "n":
                        enviar = "nombre";
                        break;
                    case "e":
                        enviar = "edad";
                        break;
                    case "c":
                        enviar = "curso";
                        break;
                }
                bw.write(enviar);
                bw.newLine();   //Concatena un \n -> enviar += '\n'
                bw.flush();

                //5. Recojo el código de finalización e imprimo el system.out del subproceso
                System.out.println(br.readLine());
                int code = p.waitFor();
                if (code != 0) {
                    System.out.println("Lo has hecho mal: " + code);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}