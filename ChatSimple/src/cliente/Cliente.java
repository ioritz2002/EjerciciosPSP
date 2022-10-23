/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.KeyboardReader;
import threads.EnviarThread;
import threads.RecibirThread;

/**
 *
 * @author iorit
 */
public class Cliente {
    private static final int PUERTO = 5000;
    private static final String HOST = "localhost";
    private Socket socketCliente = null;
    private String texto = null;
    private KeyboardReader lector = null;
    private EnviarThread enviar = null;
    private RecibirThread recibir = null;
    
    public Cliente(){
        try {
            socketCliente = new Socket(HOST, PUERTO);
            System.out.println("Conexion realizada");
            
            enviar = new EnviarThread(socketCliente);
            enviar.start();
            
            recibir = new RecibirThread(socketCliente);
            recibir.start();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                socketCliente.close();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args){
        new Cliente();
    }
}
