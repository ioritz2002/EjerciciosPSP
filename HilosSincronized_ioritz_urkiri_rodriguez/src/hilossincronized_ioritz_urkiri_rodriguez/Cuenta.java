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
public class Cuenta {
    private Integer saldo;
    
    public Cuenta(Integer saldo){
        this.saldo = saldo;
    }
    
    public void restar(Integer cantidad){
        saldo-=cantidad;
    }
    
    public synchronized void retirarDinero(Integer cantidad, String nombre){
        if (saldo >= cantidad) {
            System.out.println("Se va a retirar saldo (Actual=" + saldo + ")");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            restar(cantidad);
            System.out.println(nombre + " retira " + cantidad + " (Actual=" + saldo + ")");
            
        } else{
            System.out.println(nombre + " no se puede retirar dinero (Actual=)" + saldo + ")");
        }
    }
}
