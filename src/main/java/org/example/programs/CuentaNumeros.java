package org.example.programs;

/*
Crea un programa que muiestre por pantalla los numeros del 1 al 5
(en una linea, u del 6 al 10 en otra linea)
 */
public class CuentaNumeros {
    public static void main(String[] args) {

            for (int i = 0; i < 5; i++) {
                System.out.print(i + 1 + " ");
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
            }
        }

        System.out.println();
        for (int i = 5; i < 10; i++) {
            System.out.print(i + 1 + " ");
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }


    }
}
