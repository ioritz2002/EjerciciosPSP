/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
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
public class Servidor {
    private static final int PUERTO = 5000;
    private ServerSocket socketServidor = null;
    private Socket socketCliente = null;
    private String texto = null;
    private KeyboardReader lector = null;
    private EnviarThread enviar = null;
    private RecibirThread recibir = null;
    
    public Servidor(){
        try {
            socketServidor = new ServerSocket(PUERTO);
            System.out.println("Esperando una conexion");
            socketCliente = socketServidor.accept();
            System.out.println(socketCliente.getInetAddress() + " se ha conectado");
            
            enviar = new EnviarThread(socketCliente);
            enviar.start();
            
            recibir = new RecibirThread(socketCliente);
            recibir.start();
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                socketCliente.close();
                socketServidor.close();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    public static void main(String[] args){
        
    }
}
