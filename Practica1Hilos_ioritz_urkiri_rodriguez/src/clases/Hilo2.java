/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iorit
 */
public class Hilo2 extends Thread{
    public void run(){
        try {
            System.out.println("Introduce un numero");
            Integer num = new Scanner(System.in).nextInt();
            
            
            for (int i = 0; i < num; i++) {
                System.out.println(i);
                sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, "Error en el hilo 2", ex);
        }
    }
}
