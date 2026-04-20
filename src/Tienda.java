import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Perecederos.inventario();
        NoPedecederos.inventario();
        cliente.lista();

        ArrayList<cliente> historialUsuarios = new ArrayList<>();
        cliente c = null; 
        boolean puedeEntrar = false;
        int opcionContinuarTienda = 0; 

        do {
            if (opcionContinuarTienda != 1) {
                int opcionAcceso = 1;
                
                if (!historialUsuarios.isEmpty()) {
                    do {
                        System.out.println("\n--- ACCESO AL SISTEMA ---");
                        System.out.println("1. Registrar nuevo usuario");
                        System.out.println("2. Inicie sesion con cuenta existente");
                        System.out.println("3. Salir");
                        System.out.print("Seleccione una opcion: ");
                        
                        // --- Validacion de caracteres y decimales ---
                        try {
                            opcionAcceso = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            opcionAcceso = -1; 
                        }
                        
                        if (opcionAcceso < 1 || opcionAcceso > 3) {
                            System.out.println("Opcion invalida. Por favor ingrese un numero entero.");
                        }
                    } while (opcionAcceso < 1 || opcionAcceso > 3);
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
                }
            }

            if (puedeEntrar) {

                carrito miCarrito = new carrito(); 
                int opcionMenu = 0; 

                do {
                    System.out.println("\n========= TIENDA =========");
                    System.out.println("1. Comprar Perecederos");
                    System.out.println("2. Comprar No Perecederos");
                    System.out.println("3. Finalizar compra");
                    System.out.println("4. Salir");
                    System.out.print("Seleccione una opcion: ");

                    // --- Validacion de caracteres y decimales ---
                    try {
                        opcionMenu = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        opcionMenu = -1; 
                    }

                    switch(opcionMenu){
                        case 1:
                            Perecederos.mostrarPerecederos(miCarrito);
                            break;

                        case 2:
                            NoPedecederos.mostrarNoPerecederos(miCarrito);
                            break;

                        case 3:
                            if (!miCarrito.estaVacio()) {
                                c.elegirDire(miCarrito);
                                opcionMenu = 4; 
                            } else {
                                System.out.println("\nEl carrito esta vacio.");
                            }
                            break;

                        case 4:
                            System.out.println("SALIENDO...");
                            break;

                        default:
                            System.out.println("\nOpcion invalida.");
                    }

                } while(opcionMenu != 4);

                do {
                    System.out.println("\n---------------------------------------------");
                    System.out.println("Desea realizar otra compra en el sistema?");
                    System.out.println("1. Si, continuar con el mismo usuario (" + c.getNombre() + ")");
                    System.out.println("2. Si, registrar o acceder con otro usuario");
                    System.out.println("3. No, cerrar sistema");
                    System.out.print("Seleccione una opcion: ");
                    
                    // --- Validacion de caracteres y decimales ---
                    try {
                        opcionContinuarTienda = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        opcionContinuarTienda = -1; 
                    }
                    
                    if (opcionContinuarTienda < 1 || opcionContinuarTienda > 3) {
                        System.out.println("Opcion invalida.");
                    }
                } while (opcionContinuarTienda < 1 || opcionContinuarTienda > 3);
                
            } else {
                opcionContinuarTienda = 3;
            }

        } while (opcionContinuarTienda == 1 || opcionContinuarTienda == 2);

        System.out.println("\nSistema cerrado correctamente.");
    }
}