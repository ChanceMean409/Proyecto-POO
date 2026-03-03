import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        productos.inventario();
        cliente.lista();

        ArrayList<cliente> historialUsuarios = new ArrayList<>();
        cliente c = null;
        boolean puedeEntrar = false;
        int opcionContinuarTienda;

        do {
            int opcionAcceso = 1;
            if (!historialUsuarios.isEmpty()) {
                System.out.println("\n--- ACCESO AL SISTEMA ---");
                System.out.println("1. Registrar nuevo usuario e iniciar sesion");
                System.out.println("2. Iniciar sesion con cuenta existente");
                System.out.println("3. Salir");
                opcionAcceso = sc.nextInt();
                sc.nextLine();
            }

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
                default:
                    System.out.println("Opcion invalida.");
                    puedeEntrar = false;
                    break;
            }

            if (puedeEntrar) {
                carrito miCarrito = new carrito();
                miCarrito.comprarBiberes();
                
                if (!miCarrito.estaVacio()) {
                    c.elegirDire(miCarrito);
                }

                System.out.println("\n---------------------------------------------");
                System.out.println("Desea realizar otra compra en el sistema?");
                System.out.println("1. Si, continuar con el mismo usuario (" + c.getNombre() + ")");
                System.out.println("2. Si, registrar o acceder con otro usuario");
                System.out.println("3. No, cerrar sistema");
                opcionContinuarTienda = sc.nextInt();
                sc.nextLine();
            } else {
                opcionContinuarTienda = 3;
            }

        } while (opcionContinuarTienda == 1 || opcionContinuarTienda == 2);

        System.out.println("\nSistema cerrado correctamente. !Gracias por su compra!");
    }
}