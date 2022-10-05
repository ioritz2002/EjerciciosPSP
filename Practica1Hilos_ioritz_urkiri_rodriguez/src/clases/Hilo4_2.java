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
public class Hilo4_2 extends Thread{
    private Integer numN;
    
    public Hilo4_2(Integer numN){
        this.start();
        this.numN = numN;
    }
    
    public void run(){
        for (int i = 0; i < numN; i++) {
            System.out.println(i);
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo4_2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
