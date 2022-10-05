/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JOptionPane;

/**
 *
 * @author iorit
 */
public class Hilo4_1 extends Thread{
    public void run(){
        Integer numN = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
        Integer numM = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
        
        for (int i = 0; i < numM; i++) {
            new Hilo4_2(numN);
        }
    }
}
