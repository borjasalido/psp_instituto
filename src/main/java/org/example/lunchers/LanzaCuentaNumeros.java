package org.example.lunchers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LanzaCuentaNumeros {
    public static void main(String[] args) {
        String[] programas={"java", "-jar", "/home/borja/IdeaProjects/psp-introduction/out/artifacts/psp_borja_jar/psp-borja.jar"};
        ProcessBuilder pb= new ProcessBuilder(programas);

        try {
            Process p= pb.start();

            //Para redirigir la salida estandar del subproceso hijo,
            //voy a envolver s estram de salida en un BufferReadder, para leerlo desde aqui
            InputStream is= p.getInputStream();
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader br= new BufferedReader(isr);
            String line = "";
            while ( (line = br.readLine()) != null){
                System.out.println(line);
            }
            p.waitFor();
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("FIN");

    }
}
