import java.util.ArrayList;
import java.util.Scanner;

public class cliente {
    
    // ==========================================
    // 1. ATRIBUTOS
    // ==========================================
    private String nombre;
    private String email;
    private String contrasena;
    private String direccion;
    private float precio;
    
    public static ArrayList<cliente> lista = new ArrayList<>();

    // ==========================================
    // 2. CONSTRUCTORES
    // ==========================================
    public cliente() {
        nombre = "";
        email = "";
        contrasena = "";
        direccion = "";
        precio = 0;
    }

    public cliente(String direccion, float precio) {
        this.direccion = direccion;
        this.precio = precio;
    }
    
    // ==========================================
    // 3. BASE DE DATOS DE ZONAS
    // ==========================================
    public static void lista() {
        lista.add(new cliente("Belisario", 20));
        lista.add(new cliente("20 de noviembre", 20));
        lista.add(new cliente("San agustin", 10));
        lista.add(new cliente("Pilita seca", 15));
        lista.add(new cliente("Miguel aleman", 20));
        lista.add(new cliente("Cruz grande", 20));
        lista.add(new cliente("Mariano N. Ruiz", 25));
        lista.add(new cliente("Zona rosa", 30));
        lista.add(new cliente("Centro", 10));
        lista.add(new cliente("Mirador", 20));
    }
 
    // ==========================================
    // 4. MÉTODOS DE AUTENTICACIÓN Y REGISTRO
    // ==========================================
    public void registro(ArrayList<cliente> historialUsuarios) {
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
    
    public boolean verificar() {
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        int maxContador = 3;
        do {
            System.out.println("\nInicie sesion");
            System.out.println("Ingrese su Email:");
            String correo = sc.nextLine();
            System.out.println("Ingrese su Contrasena:");
            String clave = sc.nextLine();
            
            if (correo.equalsIgnoreCase(this.email) && clave.equals(this.contrasena)) {
                System.out.println("\nBienvenido " + this.nombre + " !");
                return true;
            } else {
                System.out.println("Correo erroneo o contrasena incorrecta");
                contador++;
            }
        } while (contador < maxContador);
        
        System.out.println("Has Alcanzado el limite de Intentos\n ACCESO DENEGADO");
        return false;
    }
    
    public cliente iniciarSesionExistente(ArrayList<cliente> historialUsuarios) {
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        int maxContador = 3;
        do {
            System.out.println("\nInicie sesion con cuenta existente");
            System.out.println("Ingrese su Email:");
            String correo = sc.nextLine();
            System.out.println("Ingrese su Contrasena:");
            String clave = sc.nextLine();
            
            for (cliente usuarioGuardado : historialUsuarios) {
                if (usuarioGuardado.getEmail().equalsIgnoreCase(correo) && usuarioGuardado.getContrasena().equals(clave)) {
                    System.out.println("Bienvenido de nuevo " + usuarioGuardado.getNombre() + " !");
                    return usuarioGuardado;
                }
            }
            System.out.println("Correo erroneo o contrasena incorrecta");
            contador++;
            
        } while (contador < maxContador);
        
        System.out.println("Has Alcanzado el limite de Intentos\n ACCESO DENEGADO");
        return null;
    }
    
    // ==========================================
    // 5. MÉTODOS DE DIRECCIÓN Y ENVÍO
    // ==========================================
    public static cliente seleccionarDireccion(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            return lista.get(indice); 
        } else { 
            System.out.println("Indice invalido"); 
        } 
        return null;
    }

    public void elegirDire(carrito miCarrito) {
        Scanner sc = new Scanner(System.in);
        boolean compraConfirmada = false;

        do {
            if (!this.direccion.equals("")) {
                System.out.println("\nTienes una direccion guardada: " + this.direccion);
                System.out.println("Deseas usar esta direccion para tu pedido?");
                System.out.println("1. Si, enviar aqui");
                System.out.println("2. No, ingresar otra direccion");
                int opcionGuardada = sc.nextInt();
                sc.nextLine();
                
                if (opcionGuardada == 1) {
                    miCarrito.mostrarDetalle(this, this.nombre);
                    System.out.println("\n!Gracias por su compra!");
                    compraConfirmada = true;
                    continue;
                    
                } else if (opcionGuardada == 2) {
                    this.direccion = "";
                    this.precio = 0;
                    System.out.println("\nDireccion anterior descartada. Por favor, elige una nueva zona.");
                    
                } else {
                    this.direccion = ""; 
                    this.precio = 0;
                    System.out.println("\nOpcion invalida. Mostrando zonas de entrega...");
                }
            }

            System.out.println("\n--- Zonas de entrega ---");
            System.out.println("Se cobraran $15 de envio base");
            
            for (int i = 0; i < lista.size(); i++) {
                cliente l = lista.get(i);
                System.out.println(i + ". " + l.getDireccion() + " - $" + l.getPrecio());
            }
            
            System.out.println(lista.size() + ". Confirmar compra y direccion");
            System.out.print("Seleccione una opcion: ");
            int opcionDireccion = sc.nextInt();
            sc.nextLine();

            if (opcionDireccion >= 0 && opcionDireccion < lista.size()) {
                cliente zonaElegida = lista.get(opcionDireccion);
                
                System.out.println("\nHas elegido la zona: " + zonaElegida.getDireccion() + " - $" + zonaElegida.getPrecio());
                System.out.println("Ingresa tu direccion especifica (Calle, Numero, Cruzamientos):");
                String calleEspecifica = sc.nextLine();
                
                if (calleEspecifica.trim().isEmpty()) {
                    System.out.println("\nError: La direccion especifica no puede estar vacia. Intentalo de nuevo.");
                } else {
                    this.direccion = zonaElegida.getDireccion() + " - " + calleEspecifica;
                    this.precio = zonaElegida.getPrecio();
                    System.out.println("\nDireccion guardada con exito. Ahora selecciona la opcion de Confirmar compra.");
                }
                
            } else if (opcionDireccion == lista.size()) {
                if (!this.direccion.equals("")) {
                    miCarrito.mostrarDetalle(this, this.nombre);
                    System.out.println("\n!Gracias por su compra!");
                    compraConfirmada = true;
                } else {
                    System.out.println("\nPrimero debes seleccionar una zona y proporcionar tu direccion antes de confirmar.");
                }
            } else {
                System.out.println("\nOpcion invalida. Por favor selecciona un numero de la lista.");
            }
        } while (!compraConfirmada);
    }

    // ==========================================
    // 6. GETTERS
    // ==========================================
    public String getNombre() { return this.nombre; }
    public String getEmail() { return this.email; }
    public String getContrasena() { return this.contrasena; }
    public String getDireccion() { return direccion; }
    public float getPrecio() { return precio; }
}