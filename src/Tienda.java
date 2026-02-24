import java.util.Scanner;
import java.util.ArrayList;

public class Tienda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("!Buenas, Bienvenidos a GaRoSa!");
        productos.inventario();
        cliente.lista();
        
        ArrayList<cliente> historialUsuarios = new ArrayList<>();
        
        int opcionContinuarTienda = 0;
        cliente c = null;          
        boolean puedeEntrar = false; 
        
        do {
            if (opcionContinuarTienda != 1) {
                int opcionAcceso = 1;
                
                if (!historialUsuarios.isEmpty()) {
                    System.out.println("\n--- ACCESO AL SISTEMA ---");
                    System.out.println("1. Registrar nuevo usuario");
                    System.out.println("2. Iniciar sesion con cuenta existente");
                    opcionAcceso = sc.nextInt();
                }
                
                if (opcionAcceso == 1) {
                    c = new cliente();
                    c.registro(historialUsuarios);
                    puedeEntrar = c.verificar();
                    
                    if (puedeEntrar) {
                        historialUsuarios.add(c);
                    }
                } else if (opcionAcceso == 2) {
                    cliente temp = new cliente();
                    c = temp.iniciarSesionExistente(historialUsuarios);
                    
                    if (c != null) {
                        puedeEntrar = true;
                    } else {
                        puedeEntrar = false;
                    }
                }
            }
            
            if (puedeEntrar) {
                System.out.println("\n========================================");
                System.out.println("  BIENVENIDOS A LA TIENDA DE ABARROTES");
                System.out.println("========================================");
                
                carrito miCarrito = new carrito();
                int opcion;
                int opcionSalir = productos.catalogo.size();
                int articulosComprados = 0;
                
                do {
                    System.out.println("\n--- Pasillo de Productos ---");
                    for (int i = 0; i < productos.catalogo.size(); i++) {
                        productos p = productos.catalogo.get(i);
                        System.out.println(i + ". " + p.getNombre() + " -  $" + p.getPrecio());
                    }
                    System.out.println(opcionSalir + ". ir a la caja a pagar (Salir)");
                    System.out.println("\nElija el numero de producto que desea: ");
                    opcion = sc.nextInt();
                    
                    if (opcion >= 0 && opcion < opcionSalir) {
                        productos productoElegido = productos.catalogo.get(opcion);
                        if (productoElegido.verificarDisponibilidad(1)) {
                            miCarrito.agregarProductos(productoElegido);
                            productoElegido.actualizarStock(1);
                            articulosComprados++;
                        } else {
                            System.out.println("Lo sentimos, producto agotado.");
                        }
                    } else if (opcion != opcionSalir) {
                        System.out.println("Opcion no valida. intente de nuevo.");
                    }
                } while (opcion != opcionSalir);
                
                if (articulosComprados > 0) {
                    System.out.println("\nElija su direcion");
                    System.out.println("\n--- Zonas de entrega ---");
                    int opcionDireccion;
                    cliente direccionElegida = null;
                    boolean compraConfirmada = false;
                    
                    do {
                        for (int i = 0; i < cliente.lista.size(); i++) {
                            cliente l = cliente.lista.get(i);
                            System.out.println(i + "." + l.getDireccion() + " - $" + l.getPrecio());
                        }
                        System.out.println(cliente.lista.size() + ". Confirmar compra y direccion");
                        opcionDireccion = sc.nextInt();
                        
                        if (opcionDireccion >= 0 && opcionDireccion < cliente.lista.size()) {
                            direccionElegida = cliente.lista.get(opcionDireccion);
                            System.out.println("Has elegido :" + direccionElegida.getDireccion() + " - con un precio de - $" + direccionElegida.getPrecio());
                            System.out.println("Ahora ingresa " + cliente.lista.size() + " para confirmar la compra.");
                        } else if (opcionDireccion == cliente.lista.size()) {
                            if (direccionElegida != null) {
                                miCarrito.mostrarDetalle(direccionElegida, c.getNombre());
                                System.out.println("\n Gracias por su compra !");
                                compraConfirmada = true;
                            } else {
                                System.out.println("\nPara confirmar la compra, primero debes seleccionar el numero de tu zona de entrega.");
                            }
                        } else {
                            System.out.println("\nOpcion de direccion invalida");
                        }
                    } while (!compraConfirmada);
                    
                } else {
                    System.out.println("\nEl carrito esta vacio. Cancelando este pedido...");
                }
                
                System.out.println("\n----------------------------------------");
                System.out.println("¿Desea realizar otra compra en el sistema?");
                System.out.println("1. Si, continuar con el mismo usuario (" + c.getNombre() + ")");
                System.out.println("2. Si, registrar o acceder con otro usuario");
                System.out.println("3. No, cerrar sistema");
                opcionContinuarTienda = sc.nextInt();
                
            } else {
                System.out.println("\nNo se pudo verificar el acceso. Cerrando sesion...");
                opcionContinuarTienda = 3; 
            }
            
        } while (opcionContinuarTienda == 1 || opcionContinuarTienda == 2);
        
        System.out.println("\nSistema cerrado correctamente. !Gracias por su compra!");
    }   
}
