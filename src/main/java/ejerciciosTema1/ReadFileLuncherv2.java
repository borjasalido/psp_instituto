package ejerciciosTema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFileLuncherv2 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Fichero a leer: ");
        String f = s.nextLine();

        //Construir ProcessBuilder
        ProcessBuilder pb = new ProcessBuilder("java", "-jar",
                "/home/borja/IdeaProjects/psp-introduction/out/artifacts/ReadFilev2/ReadFilev2.jar", f);

        System.out.println("Guardar en fichero [f] o mostrar por pantalla [p]: ");
        String tipo= s.nextLine();

        if (tipo.equals("f")){
            String copy = s.nextLine();
            File log= new File(copy);
            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
        }

        Process p = pb.start();

        if (tipo.equals("p")){
            try (BufferedReader br= new BufferedReader(new InputStreamReader(p.getInputStream()))){
                String line;
                while ((line = br.readLine()) != null){
                    System.out.println(line);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
