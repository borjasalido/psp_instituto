package org.example.lunchers;

import java.io.IOException;

public class LanzaProceso {
    public static void main(String[] args) {

        String programa= "gnome-text-editor";
        ProcessBuilder pb = new ProcessBuilder(programa);

        try {
            pb.start();
        }catch (IOException e){
            //e.printStackTrace();
            System.err.println("Error de Es: " +  e.getMessage());
        }catch (Exception e){
            System.err.println("Error de otro Es: " + e.getMessage());
        }

        String[] programWithArgs = {"gnome-text-editor", "uno.txt", "dos.txt"};
        ProcessBuilder pb2= new ProcessBuilder(programWithArgs);
        try{
            pb2.start();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}