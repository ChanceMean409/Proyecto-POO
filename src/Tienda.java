
import java.util.Scanner;
public class Tienda {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        cliente c=new cliente();
        productos.inventario();
        c.registro();
        boolean puedeEntrar = c.verificar();
        
        if (puedeEntrar){
            System.out.println("\n========================================");
            System.out.println("    BIENBENIDOS A LA TIENDA DE ABARROTES");
            System.out.println("========================================");
            carrito miCarrito = new carrito();
            int opcion;
            int opcionSalir = productos.catalogo.size();
            
            do {
                System.out.println("\n--- Pasillo de Productos ---");
                for (int i = 0; i < productos.catalogo.size(); i++) {
                    productos p =productos.catalogo.get(i);
                    System.out.println(i+". "+p.getNombre()+" -  $"+p.getPrecio());
                }
                System.out.println(opcionSalir+". ir a la caja a pagar (Salir)");
                System.out.println(opcionSalir+"\nElija el numero de producto que desea: ");
                opcion = sc.nextInt();
                if (opcion>=0&&opcion<opcionSalir) {
                    productos productoElegido = productos.catalogo.get(opcion);
                    if (productoElegido.verificarDisponibilidad(1)) {
                        miCarrito.agregarProductos(productoElegido);
                        productoElegido.actualizarStock(1);
                    }else{
                        System.out.println("Lo sentimos, producto agotado.");
                    }
                }else if (opcion!= opcionSalir){
                    System.out.println("Opcion no valida. intente de nuevo.");
                }
            } while (opcion!=opcionSalir);
            miCarrito.mostrarDetalle();
            System.out.println("\n¡Gracias por su compra!");
            
        } else {
            System.out.println("\nCerrando el sistema por seguridad");
        }
    }
    
}
