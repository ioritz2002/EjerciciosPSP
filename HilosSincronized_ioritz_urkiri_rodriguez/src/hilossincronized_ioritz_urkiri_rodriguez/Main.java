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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuenta c = new Cuenta(40);
        Persona h1 = new Persona(c, "Ana");
        Persona h2 = new Persona(c, "Mikel");
        h1.start();
        h2.start();
    }
    
}
