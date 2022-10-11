/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author iorit
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Hilo5> treads_5 = null;
        int numN;
        //Ejercio1
        /*Hilo1 t1 = new Hilo1();
        t1.start();*/

        //Ejercicio2
        /*Hilo2 t2 = new Hilo2();
       t2.start();*/
        //Ejercicio3
        /*Hilo3 t3 = new Hilo3();
       t3.start();*/
        //Ejercicio4
        //Hilo4_1 t4 = new Hilo4_1();
        //t4.start();
        //Ejercicio5
        while (true) {

            try {
                do {
                    System.out.println("Introduce un numero igual o menor a 10");
                    numN = new Scanner(System.in).nextInt();

                    if (numN > 10) {
                        System.out.println("El numero tiene que ser menor o igual a 10");
                    }
                } while (numN > 10);
                Hilo5 t5 = null;
                treads_5 = new ArrayList<>();
                for (int i = 0; i < numN; i++) {
                    if (treads_5.size() >= 10 && i == 0) {
                        borrarHilos(numN, treads_5);
                    } else {
                        if ((treads_5.size() + numN) > 10) {
                            borrarHilos(((treads_5.size()+numN)-10), treads_5);
                        } else{
                           t5 = new Hilo5();
                           treads_5.add(t5); 
                        }
                        
                    }

                }

                for (Hilo5 hilo5 : treads_5) {
                    hilo5.start();
                }

            } catch (NumberFormatException e) {
                System.out.println("Tienes que introducir un numero");
            } catch (NullPointerException e) {
                System.out.println("Tienes que introducir un numero");
            }

        }
    }

    private static void borrarHilos(int numN, List<Hilo5> treads_5) {
        for (int i = 0; i < numN; i++) {
            treads_5.remove(i);
        }
    }

}
