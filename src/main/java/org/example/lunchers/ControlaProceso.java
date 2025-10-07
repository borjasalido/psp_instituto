package org.example.lunchers;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ControlaProceso {
    public static void main(String[] args) {
        String p="gnome-text-editor";
        ProcessBuilder pb= new ProcessBuilder(p);

        try {
            Process p1= pb.start();
            //La variable process es un objeto que contiene el proceso que acabo de lanzar
            //y asi puedo esperarlo, ver inforamción suya, finalizarlo, etc.

            System.out.println("El pid del proceso es " + p1.pid()); //pid es el numero que identifica el proceso

            //Puedo esperar durante un tiempo determinado a que el proceso termine
            p1.waitFor(30, TimeUnit.SECONDS);


        }catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("FIN");


    }
}
