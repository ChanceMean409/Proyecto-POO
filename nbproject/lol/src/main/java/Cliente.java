
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gabrielcilantro2
 */
public class Cliente {
    // definicion de atributos de la clase
    private String nombre;
    private String email;
    private ArrayList<String> lista;
    private String contrasena;
   //constructor
    public void Cliente(){
        nombre=null;
    }
    
    //registro
    private void registro(){
        Scanner sc = new Scanner(System.in);
        //ingresar datos por el usuario
        System.out.println("Ingrese su nombre:");
        nombre=sc.nextLine();
        
        System.out.println("Ingrese su Email:");
        email=sc.nextLine();
        
        System.out.println("Ingrese contrasena:");
        contrasena=sc.nextLine();
        System.out.println("\nDATOS GUARDADOS CORRECTAMENTE.\n");
        
        
    }
//metodo sin argumento
    public void setNombre(String nombre){
       this. nombre=nombre;
    }
        public void setEmail(String email){
        this.email=email;
    }
        public void setContrasena(String contrasena){
       this. contrasena=contrasena;
    }
        
    //metodo autenticar
    public void verificar(String Adress, String password){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInicie sesion");
        System.out.println("Ingrese su Email:");
        email=sc.nextLine();
        System.out.println("Ingrese su Contrasena:");
        contrasena=sc.nextLine();
    }

    /*metodo para agregar direcciom
    public void agregarDireccion(String direccion){
    lista.add(direccion);
    }
    // metodo para mostrar datos
    public void mostrarDatos(){
        System.out.println("Nombre :"+nombre);
        System.out.println("Email :"+email);
        System.out.println("Direccion :"+lista);
    }
*/
}

    