
import java.util.Scanner;
public class Tienda {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("!Buenas, Bienvenidos a GaRoSa!");
        productos.inventario();
        cliente.lista();
        int opcionContinuarTienda=0;
        do{
            cliente c=new cliente();
            c.registro();
            boolean puedeEntrar = c.verificar();
            if (puedeEntrar){
            System.out.println("\n========================================");
            System.out.println("  BIENBENIDOS A LA TIENDA DE ABARROTES");
            System.out.println("========================================");
            carrito miCarrito = new carrito();
            int opcion;
            int opcionSalir = productos.catalogo.size();
            int articulosComprados=0;
            do {
                System.out.println("\n--- Pasillo de Productos ---");
                for (int i = 0; i < productos.catalogo.size(); i++) {
                    productos p =productos.catalogo.get(i);
                    System.out.println(i+". "+p.getNombre()+" -  $"+p.getPrecio());
                }
                System.out.println(opcionSalir+". ir a la caja a pagar (Salir)");
                System.out.println("\nElija el numero de producto que desea: ");
                opcion = sc.nextInt();
                if (opcion>=0&&opcion<opcionSalir) {
                    productos productoElegido = productos.catalogo.get(opcion);
                    if (productoElegido.verificarDisponibilidad(1)) {
                        miCarrito.agregarProductos(productoElegido);
                        productoElegido.actualizarStock(1);
                        articulosComprados++;
                    }else{
                        System.out.println("Lo sentimos, producto agotado.");
                    }
                }else if (opcion!= opcionSalir){
                    System.out.println("Opcion no valida. intente de nuevo.");
                }
            } while (opcion!=opcionSalir);
          if (articulosComprados>0){
            // Eleccion de direcciones
            System.out.println("\nElija su direcion");
            System.out.println("\n--- Zonas de entrega ---");
            int opcionDireccion;
            cliente direccionElegida=null;
            boolean compraConfirmada = false;
            do{
            // mostrar direcciones
            for (int i = 0; i < cliente.lista.size(); i++) {
                cliente l = cliente.lista.get(i);
                System.out.println(i+"."+l.getDireccion()+" - $"+l.getPrecio());
            }
            System.out.println(cliente.lista.size()+". Confirmar compra y direccion");
            opcionDireccion=sc.nextInt();
            if (opcionDireccion >= 0 && opcionDireccion < cliente.lista.size()) {
                direccionElegida = cliente.lista.get(opcionDireccion);
                System.out.println("Has elegido :"+direccionElegida.getDireccion()+" - con un precio de - $"+direccionElegida.getPrecio());
                System.out.println("Ahora ingresa "+cliente.lista.size()+" para confirmar la compra.");
            }else if (opcionDireccion == cliente.lista.size()){
                if (direccionElegida != null) {
                    miCarrito.mostrarDetalle(direccionElegida);
                    System.out.println("\n Gracias por su compra !");
                    compraConfirmada=true;
                }else{
            System.out.println("\nPara confirmar la compra, primero debes seleccionar el numero de tu zona de entrega (0 al 9).");
                }
         }else{
            System.out.println("\nOpcion de direccion invalida");
        }
       }while (!compraConfirmada);
          }else{
              System.out.println("\nNo se pudo verificar el acceso. Cerrando sesion...");
          }
                System.out.println("\n----------------------------------------");
                System.out.println("Desea registrar una nueva compra en el sistema?");
                System.out.println("1. Si (Mismo u otro usuario)");
                System.out.println("2. No, cerrar sistema");
                opcionContinuarTienda=sc.nextInt();
        }
     }while (opcionContinuarTienda==1);
    System.out.println("\nSistema cerrado correctamente. !Gracias por su compra!");
  }   
}