
import java.util.ArrayList;
import java.util.Scanner;

public class cliente {
     // definicion de atributos de la clase
    private String nombre;
    private String email;
    private String contrasena;
    private String direccion;
    private float precio;
    public static ArrayList<cliente> lista=new ArrayList<>();

//constructor
    public cliente(){
        nombre="";
        email="";
        contrasena="";
        direccion = "";
        precio = 0;
    }
    public cliente(String direccion, float precio){
        this.direccion=direccion;
        this.precio=precio;
    
    }
// crear lista de direcciones
    public static void lista(){
        lista.add(new cliente ("Belisario",30));
        lista.add(new cliente ("20 de noviembre",34));
        lista.add(new cliente ("San agustin",30));
        lista.add(new cliente ("Pilita seca",25));
        lista.add(new cliente ("Miguel aleman",35));
        lista.add(new cliente ("Cruz grande",35));
        lista.add(new cliente ("Mariano N. Ruiz",45));
        lista.add(new cliente ("Zona rosa",50));
        lista.add(new cliente ("Centro",15));
        lista.add(new cliente ("Mirador",45));
        
    }
    public String getDireccion(){
    return direccion;
    }
    public float getPrecio(){
    return precio;
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
    public static cliente seleccionarDireccion(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            return lista.get(indice); 
        } else { System.out.println("Índice inválido"); 
         } return null;
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