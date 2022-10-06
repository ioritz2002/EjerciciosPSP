/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iorit
 */
public class Hilo1 extends Thread{
    public void run(){
        System.out.println("Soy el hilo. Voy a contar");
        for (int i = 0; i < 50; i++) {
            System.out.println(i);
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, "Error en el hilo 1", ex);
            }
        }
    }
}
