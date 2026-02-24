import java.util.ArrayList;
import java.util.Scanner;

public class cliente {
    private String nombre;
    private String email;
    private String contrasena;
    private String direccion;
    private float precio;
    public static ArrayList<cliente> lista = new ArrayList<>();

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
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getContrasena(){
        return this.contrasena;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public float getPrecio(){
        return precio;
    }
    
    public void registro(ArrayList<cliente> historialUsuarios){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese su nombre:");
        this.nombre = sc.nextLine();
        
        boolean enUso;
        do {
            enUso = false;
            System.out.println("Ingrese su Email:");
            this.email = sc.nextLine();
            
            for (cliente usuarioGuardado : historialUsuarios) {
                if (usuarioGuardado.getEmail().equalsIgnoreCase(this.email)) {
                    System.out.println("Ese email ya esta en uso, utilice otro.\n");
                    enUso = true;
                    break; 
                }
            }
        } while (enUso);
        
        System.out.println("Ingrese contrasena:");
        this.contrasena = sc.nextLine();
        System.out.println("\nDATOS GUARDADOS CORRECTAMENTE.\n");    
    } 
    
    public static cliente seleccionarDireccion(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            return lista.get(indice); 
        } else { 
            System.out.println("Índice inválido"); 
        } 
        return null;
    }
    
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
            
            if (correo.equalsIgnoreCase(this.email) && clave.equals(this.contrasena)){
                System.out.println("Bienvenido "+this.nombre+" !");
                return true;
            } else {
                System.out.println("Correo erroneo o contraseña incorrecta");
                contador++;
            }
        } while (contador<maxContador);
        
        System.out.println("Has Alcanzado el limite de Intentos\n ACCESO DENEGADO");
        return false;
    }
    
    public cliente iniciarSesionExistente(ArrayList<cliente> historialUsuarios){
        Scanner sc = new Scanner(System.in);
        int contador=0;
        int maxContador=3;
        do{
            System.out.println("\nInicie sesion con cuenta existente");
            System.out.println("Ingrese su Email:");
            String correo=sc.nextLine();
            System.out.println("Ingrese su Contrasena:");
            String clave=sc.nextLine();
            
            for (cliente usuarioGuardado : historialUsuarios) {
                if (usuarioGuardado.getEmail().equalsIgnoreCase(correo) && usuarioGuardado.getContrasena().equals(clave)){
                    System.out.println("Bienvenido de nuevo "+usuarioGuardado.getNombre()+" !");
                    return usuarioGuardado;
                }
            }
            System.out.println("Correo erroneo o contraseña incorrecta");
            contador++;
            
        } while (contador<maxContador);
        
        System.out.println("Has Alcanzado el limite de Intentos\n ACCESO DENEGADO");
        return null;
    }
}