
import java.util.ArrayList;
import java.util.Scanner;

public class cliente {
     // definicion de atributos de la clase
    private String nombre;
    private String email;
    private ArrayList<String> listaDeDirecciones;
    private String contrasena;
   //constructor
    public cliente(){
        nombre="";
        email="";
        contrasena="";
    }
    
    //registro
    public void registro(){
        Scanner sc = new Scanner(System.in);
        //ingresar datos por el usuario
        System.out.println("Ingrese su nombre:");
        this.nombre=sc.nextLine();
        
        System.out.println("Ingrese su Email:");
        this.email=sc.nextLine();
        
        System.out.println("Ingrese contrasena:");
        this.contrasena=sc.nextLine();
        System.out.println("\nDATOS GUARDADOS CORRECTAMENTE.\n");
        
    }  
    //metodo autenticar
    public boolean verificar(){
        Scanner sc = new Scanner(System.in);
        int contador=0;
        int maxContador=3;
        do{
        System.out.println("\nInicie sesion");
        System.out.println("Ingrese su Email:");
        String correo=sc.nextLine();
        System.out.println("Ingrese su Contrasena:");
        String clave=sc.nextLine();
        if (correo.equals(this.email)&&clave.equals(this.contrasena)){
            System.out.println("Bienvenido "+this.nombre+" !");
        return true;
        }else{
            System.out.println("Correo erroneo o contraseña incorrecta");
            contador++;
        }
       }while (contador<maxContador);
        System.out.println("Has Alcanzado el limite de Intentos\n ACCESO DENEGADO");
        return false;
    }
    
}
