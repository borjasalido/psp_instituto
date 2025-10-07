package org.example.lunchers;

import java.io.*;

public class LanzaRepaso {
    public static void main(String[] args) {
        String [] app = {"java","-jar","/home/borja/IdeaProjects/psp-introduction/out/artifacts/repaso/psp-borja.jar" , "hola" , "que" , "tal"};
        //Vamos a hacerlo con Runtime en lugar de ProcesBuilder (son muy similares)

        Runtime rt= Runtime.getRuntime();

        try {
            Process p = rt.exec(app);       //Similar al .start de ProcesBuilder
            //Redirijo entradas y salidas del suproceso hacie este
            try (BufferedReader br= new BufferedReader(new InputStreamReader(p.getInputStream()));
                 BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(p.getOutputStream()))
                 ){
                // 1. leo
                System.out.println(br.readLine());

                // 2.
                System.out.println(br.readLine());

                // 3.
                System.out.println(br.readLine());

                // 4. Digo la longitud de lo leido (System.out)
                bw.write("esto es mi cadena");              //aqui hay que meter el  \n porque la cadena en el programa es .nextLine();
                bw.flush();     //esto es necesario para continuar, porque si no esta se queda leyendo lo que escribes todo el tiempo

                //5.
                System.out.println(br.readLine());
                int codigo= p.waitFor();
                if (codigo != 0){
                    System.out.println(br.readLine());
                }


            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
