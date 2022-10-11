/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilossincronized_ioritz_urkiri_rodriguez;

/**
 *
 * @author iorit
 */
public class Persona extends Thread{
    private Cuenta c;
    private String nombre;
    
    public Persona(Cuenta c, String nombre){
        this.c = c;
        this.nombre = nombre;
    }
    
    public void run(){
        for (int i = 0; i < 4; i++) {
            c.retirarDinero(10, nombre);
        }
    }
}
