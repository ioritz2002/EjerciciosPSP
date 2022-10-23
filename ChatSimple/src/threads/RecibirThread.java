/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.KeyboardReader;

/**
 *
 * @author iorit
 */
public class RecibirThread extends Thread{

    private Socket socketCliente;
    private ObjectInputStream ois;
    private KeyboardReader keyReader;
    private String text;
    
    public RecibirThread(Socket socketCliente) {
        this.socketCliente = socketCliente;
        if (socketCliente.isClosed()) {
            System.out.println("Error");
        }
    }
    
    @Override
    public synchronized void run(){
        keyReader = new KeyboardReader();
        
        do {
            try {
                this.ois = new ObjectInputStream(socketCliente.getInputStream());
                this.text = (String) ois.readObject();
                
                System.out.println(text);
                if (text.equalsIgnoreCase("Salir")) {
                    System.out.println("Fin de la conversacion");
                }
            } catch (IOException ex) {
                Logger.getLogger(RecibirThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RecibirThread.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } while (!text.equalsIgnoreCase("Salir"));
    }
}
