/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author iorit
 */
public class Hilo3 extends Thread{
    public void run(){
        Integer num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
        
        for (int i = 0; i < num; i++) {
            System.out.println(i);
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo3.class.getName()).log(Level.SEVERE, "Error al dormir el hilo", ex);
            }
        }
    }
}
