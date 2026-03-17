import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         Perecederos.inventarioPerecederos();
         NoPedecederos.inventarioNoPedecederos();
         productos.generarCatalogo();
        cliente.lista();

        ArrayList<cliente> historialUsuarios = new ArrayList<>();
        cliente c = null;
        boolean puedeEntrar = false;
        int opcionContinuarTienda = 0; // Inicializa la variable

        do {
            // Verifica si el usuario pidio continuar con la misma cuenta
            if (opcionContinuarTienda != 1) {
                int opcionAcceso = 1;
                
                // Muestra el menu de acceso si hay usuarios registrados y valida entrada
                if (!historialUsuarios.isEmpty()) {
                    do {
                        System.out.println("\n--- ACCESO AL SISTEMA ---");
                        System.out.println("1. Registrar nuevo usuario");
                        System.out.println("2. Iniciar sesion con cuenta existente");
                        System.out.println("3. Salir");
                        opcionAcceso = sc.nextInt();
                        sc.nextLine(); // Limpia el buffer
                        
                        if (opcionAcceso < 1 || opcionAcceso > 3) {
                            System.out.println("Opcion invalida. Intente de nuevo.");
                        }
                    } while (opcionAcceso < 1 || opcionAcceso > 3);
                }

                // Procesa la opcion de acceso elegida
                switch (opcionAcceso) {
                    case 1:
                        c = new cliente();
                        c.registro(historialUsuarios);
                        puedeEntrar = c.verificar();
                        if (puedeEntrar) historialUsuarios.add(c);
                        break;
                    case 2:
                        cliente temp = new cliente();
                        c = temp.iniciarSesionExistente(historialUsuarios);
                        puedeEntrar = (c != null);
                        break;
                    case 3:
                        System.out.println("Saliendo del sistema...");
                        return;
                }
            }

            // Inicia el proceso de compra si el acceso fue exitoso
            if (puedeEntrar) {
                carrito miCarrito = new carrito();
                miCarrito.comprarBiberes();
                
                // Verifica que el carrito no este vacio para pedir direccion
                if (!miCarrito.estaVacio()) {
                    c.elegirDire(miCarrito);
                }

                // Muestra opciones para nueva compra y valida entrada
                do {
                    System.out.println("\n---------------------------------------------");
                    System.out.println("Desea realizar otra compra en el sistema?");
                    System.out.println("1. Si, continuar con el mismo usuario (" + c.getNombre() + ")");
                    System.out.println("2. Si, registrar o acceder con otro usuario");
                    System.out.println("3. No, cerrar sistema");
                    opcionContinuarTienda = sc.nextInt();
                    sc.nextLine();
                    
                    if (opcionContinuarTienda < 1 || opcionContinuarTienda > 3) {
                        System.out.println("Opcion invalida. Intente de nuevo.");
                    }
                } while (opcionContinuarTienda < 1 || opcionContinuarTienda > 3);
                
            } else {
                opcionContinuarTienda = 3;
            }

        } while (opcionContinuarTienda == 1 || opcionContinuarTienda == 2);

        System.out.println("\nSistema cerrado correctamente. !Gracias por su compra!");
    }
}