import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class carrito {
    
    // Definicion de atributos
    private List<productos> listaDeProductos;
    private float costoEnvio;
    
    // Constructor sin argumentos
    public carrito(){
        this.listaDeProductos = new ArrayList<>();
        this.costoEnvio = 15;
    }
    
    public boolean estaVacio() {
        return listaDeProductos.isEmpty();
    }
    
    //METODO DONDE SE HACE LA COMPRA DE PRODUCTOS
    public void comprarBiberes() {
        Scanner sc = new Scanner (System.in);
        int opcion;
        int opcionSalir = productos.catalogo.size();
        int articulosComprados = 0;

        do {
            System.out.println("\n--- Pasillo de Productos ---");
            for (int i = 0; i < productos.catalogo.size(); i++) {
                productos p = productos.catalogo.get(i);
                System.out.println(i + ". [" + p.getCategoria() + "] " + p.getNombre() + " - $" + p.getPrecio());
            }
            System.out.println(opcionSalir + ". Ir a la caja a pagar (Salir)");
            System.out.println("\nElija el numero del producto que desea: ");
            opcion = sc.nextInt();

            if (opcion >= 0 && opcion < opcionSalir) {
                productos productoElegido = productos.catalogo.get(opcion);

                if (productoElegido.getStock() == 0) {
                    System.out.println("\nLo sentimos, no hay suficiente cantidad disponible.");
                } else {
                    System.out.println("\nCuantas unidades de " + productoElegido.getNombre() + " desea? (Stock total: " + productoElegido.getStock() + ")");
                    int cantidad = sc.nextInt();

                    if (productoElegido.verificarDisponibilidad(cantidad)) {
                        agregarProductos(productoElegido, cantidad);
                        articulosComprados += cantidad;
                    } else {
                        System.out.println("\nLo sentimos, no hay suficiente cantidad disponible.");
                    }
                }
            } else if (opcion != opcionSalir) {
                System.out.println("\nOpcion no valida, intente de nuevo.");
            }
        } while (opcion != opcionSalir);

        if (articulosComprados == 0) {
            System.out.println("\nEl carrito esta vacio. Cancelando este pedido...");
        }
    }

    // Metodo de agregar objetos
    public void agregarProductos(productos producto, int cantidad){
        for (int i = 0; i < cantidad; i++) {
            listaDeProductos.add(producto);
        }
        producto.actualizarStock(cantidad);
        System.out.println("Se agregaron "+cantidad+" unidades de "+producto.getNombre()+" a su carrito");
    }

    // Metodo de quitar productos
    public void eliminarProducto(int indice){
        if (indice >= 0 && indice < listaDeProductos.size()){
            listaDeProductos.remove(indice);
        } else {
            System.out.println("Numero de Producto Invalido");
        }
    }
    
    // Calcular total 
    public float calcularTotal(cliente direccionElegida){
        float subtotal = 0;
        for (productos p : listaDeProductos) {
            subtotal = subtotal + p.getPrecio();
        }
        return subtotal + direccionElegida.getPrecio() + costoEnvio;
    }
    
    // Mostrar carrito y stackear (agrupar) productos repetidos
    public void mostrarDetalle(cliente direccionElegida, String nombreCliente){
        System.out.println("\nCliente: "+nombreCliente);
        System.out.println("---  TICKET DE COMPRA ---");
        
        if (listaDeProductos.isEmpty()) {
            System.out.println("El Carrito esta vacio.");
        } else {
            // Listas temporales para agrupar
            ArrayList<String> nombres = new ArrayList<>();
            ArrayList<Integer> cantidades = new ArrayList<>();
            ArrayList<Float> precios = new ArrayList<>();
            
            // Recorremos el carrito para contar repetidos
            for (productos p : listaDeProductos) {
                String nombreActual = p.getNombre();
                
                if (nombres.contains(nombreActual)) {
                    int index = nombres.indexOf(nombreActual);
                    cantidades.set(index, cantidades.get(index) + 1);
                } 
                else {
                    nombres.add(nombreActual);
                    cantidades.add(1);
                    precios.add(p.getPrecio());
                }
            }
            
            // Imprimimos el ticket ya stackeado
           for (int i = 0; i < nombres.size(); i++) {

    int cant = cantidades.get(i);
    String nom = nombres.get(i);
    float precioUnitario = precios.get(i);
    float subtotalProducto = cant * precioUnitario;

    System.out.print(cant + "x " + nom + " - $" + subtotalProducto + " ($" + precioUnitario + " c/u)");

    // muestra de la caducidad y el empaque en el ticket
    productos productoEncontrado = null;

    for(productos p : listaDeProductos){
        if(p.getNombre().equals(nom)){
            productoEncontrado = p;
            break;
        }
    }

    if(productoEncontrado instanceof Perecederos){
        Perecederos per = (Perecederos) productoEncontrado;
        System.out.print(" | Caduca en: " + per.getDiasParaCaducar() + " dias");
    }

    if(productoEncontrado instanceof NoPedecederos){
        NoPedecederos np = (NoPedecederos) productoEncontrado;
        System.out.print(" | Empaque: " + np.getTipoEmpaque());
    }

    System.out.println();
}
            
            System.out.println("---------------------------------");
            System.out.println("Costo de envio base : $" + costoEnvio);
            System.out.println("Costo con direccion (" + direccionElegida.getDireccion() + ") : $" + direccionElegida.getPrecio());
            System.out.println("---------------------------------");
            System.out.println("TOTAL A PAGAR: $" + calcularTotal(direccionElegida));
        }
    }}
