package org.example.lunchers;

import java.io.IOException;

public class LanzarFireFox {
    public static void main(String[] args) {
        String p= "firefox";
        ProcessBuilder pb = new ProcessBuilder(p);

        try {
            pb.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
