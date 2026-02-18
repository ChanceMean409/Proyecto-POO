
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rlopr
 */
public class pruebaCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //mostrar datos
        System.out.println(cliente1.getNombre());
        System.out.println(cliente1.getEmail());
        System.out.println(cliente1.getContrasena());
        
        //verificar/////////////////////////////////////////////////
        
        
        if(cliente1.verificar(Adress, password)){
            System.out.println("Compra confirmada");
        }else{
            System.out.println("Compra denegada");
      }
    }
}
