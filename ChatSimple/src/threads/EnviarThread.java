/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.KeyboardReader;

/**
 *
 * @author iorit
 */
public class EnviarThread extends Thread {

    private String text = null;
    private KeyboardReader keyReader = null;
    private Socket socketCliente = null;
    private ObjectOutputStream oos = null;

    public EnviarThread(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    @Override
    public synchronized void run() {
        keyReader = new KeyboardReader();
        do {
            try {
                this.oos = new ObjectOutputStream(socketCliente.getOutputStream());
                text = keyReader.readString();
                if (text.equalsIgnoreCase("Salir")) {
                    System.out.println("Fin de la conversacion");
                }
                oos.writeObject(text);
            } catch (IOException ex) {
                Logger.getLogger(EnviarThread.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        } while (!text.equalsIgnoreCase("salir"));
    }
}
