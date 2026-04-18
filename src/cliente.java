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
                    System.out.println("Ese email ya esta en uso.\n");
                    enUso = true;
                    break; 
                }
            }
        } while (enUso);
        
        System.out.println("Ingrese contrasena:");
        this.contrasena = sc.nextLine();
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
                System.out.println("Datos incorrectos.");
                contador++;
            }
        } while (contador < maxContador);
        
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
                    System.out.println("Bienvenido " + usuarioGuardado.getNombre() + " !");
                    return usuarioGuardado;
                }
            }
            contador++;
        } while (contador < maxContador);
        
        return null;
    }
    
    // ==========================================
    // 5. MÉTODOS DE DIRECCIÓN Y ENVÍO
    // ==========================================
    public void elegirDire(carrito miCarrito) {
        Scanner sc = new Scanner(System.in);
        boolean compraConfirmada = false;

        do {
            if (!this.direccion.equals("")) {
                System.out.println("\nTienes una direccion guardada: " + this.direccion);
                System.out.println("Deseas usar esta direccion?");
                System.out.println("1. Si");
                System.out.println("2. No");
                
                int opcionGuardada = -1;
                
                // --- Validacion de caracteres y decimales ---
                try {
                    opcionGuardada = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    // Se deja vacio porque opcionGuardada ya es -1 por defecto
                }
                
                // --- Switch optimizado ---
                switch (opcionGuardada) {
                    case 1:
                        miCarrito.mostrarDetalle(this, this.nombre);
                        compraConfirmada = true;
                        continue; 
                    case 2:
                        this.direccion = "";
                        this.precio = 0;
                        break; 
                    default:
                        System.out.println("\nOpcion invalida.");
                        continue; 
                }
            }

            System.out.println("\n--- Zonas de entrega ---");
            System.out.println("Se cobraran $15 de envio base");

            for (int i = 0; i < lista.size(); i++) {
                cliente l = lista.get(i);
                System.out.println(i + ". " + l.getDireccion() + " - $" + l.getPrecio());
            }
            
            System.out.println(lista.size() + ". Confirmar");
            System.out.print("Seleccione zona: ");
            
            int opcionDireccion = -1;
            
            // --- Validacion de caracteres y decimales ---
            try {
                opcionDireccion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                // Se deja vacio porque opcionDireccion ya es -1 por defecto
            }

            if (opcionDireccion >= 0 && opcionDireccion < lista.size()) {
                cliente zonaElegida = lista.get(opcionDireccion);
                System.out.println("Ingresa tu direccion exacta:");
                String calleEspecifica = sc.nextLine();
                
                if (calleEspecifica.trim().isEmpty()) {
                    System.out.println("\nError: No puede estar vacia.");
                } else {
                    this.direccion = zonaElegida.getDireccion() + " - " + calleEspecifica;
                    this.precio = zonaElegida.getPrecio();
                }
                
            } else if (opcionDireccion == lista.size()) {
                if (!this.direccion.equals("")) {
                    miCarrito.mostrarDetalle(this, this.nombre);
                    compraConfirmada = true;
                } else {
                    System.out.println("\nPrimero selecciona zona y direccion.");
                }
            } else {
                System.out.println("\nOpcion invalida.");
            }
        } while (!compraConfirmada);
    }

    // ==========================================
    // 6. GETTERS
    // ==========================================
    public String getNombre() { return this.nombre; }
    public String getEmail() { return this.email; }
    public String getContrasena() { return this.contrasena; }
    public String getDireccion() { return this.direccion; }
    public float getPrecio() { return this.precio; }
}