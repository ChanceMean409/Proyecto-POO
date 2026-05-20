import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class carrito {
    
    // ==========================================
    // 1. ATRIBUTOS
    // ==========================================
    private List<productos> listaDeProductos;
    private float costoEnvio;
    
    // ==========================================
    // 2. CONSTRUCTORES
    // ==========================================
    public carrito() {
        this.listaDeProductos = new ArrayList<>();
        this.costoEnvio = 15;
    }
    
    // ==========================================
    // 3. MÉTODOS DEL CARRITO Y TOTALES
    // ==========================================
    public boolean estaVacio() {
        return listaDeProductos.isEmpty();
    }
    
    public void agregarProductos(productos producto, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            listaDeProductos.add(producto);
        }
        producto.actualizarStock(cantidad);
        System.out.println("Se agregaron " + cantidad + " unidades de " + producto.getNombre() + " a su carrito");
    }

    public void eliminarProducto(int indice) {
        if (indice >= 0 && indice < listaDeProductos.size()) {
            listaDeProductos.remove(indice);
        } else {
            System.out.println("Numero de Producto Invalido");
        }
    }
    
    public float calcularTotal(cliente direccionElegida) {
        float subtotal = 0;
        for (productos p : listaDeProductos) {
            subtotal = subtotal + p.getPrecio();
        }
        return subtotal + direccionElegida.getPrecio() + costoEnvio;
    }
    
    public void mostrarDetalle(cliente direccionElegida, String nombreCliente) {
        System.out.println("\nCliente: " + nombreCliente);
        System.out.println("---  TICKET DE COMPRA ---");
        
        if (listaDeProductos.isEmpty()) {
            System.out.println("El Carrito esta vacio.");
        } else {
            ArrayList<String> nombres = new ArrayList<>();
            ArrayList<Integer> cantidades = new ArrayList<>();
            ArrayList<Float> precios = new ArrayList<>();
            
            for (productos p : listaDeProductos) {
                String nombreActual = p.getNombre();
                
                if (nombres.contains(nombreActual)) {
                    int index = nombres.indexOf(nombreActual);
                    cantidades.set(index, cantidades.get(index) + 1);
                } else {
                    nombres.add(nombreActual);
                    cantidades.add(1);
                    precios.add(p.getPrecio());
                }
            }
            
            for (int i = 0; i < nombres.size(); i++) {
                int cant = cantidades.get(i);
                String nom = nombres.get(i);
                float precioUnitario = precios.get(i);
                float subtotalProducto = cant * precioUnitario;
                
                System.out.println(cant + "x " + nom + " - $" + subtotalProducto + " ($" + precioUnitario + " c/u)");
            }
            System.out.println("---------------------------------");
            System.out.println("Costo de envio base : $" + costoEnvio);
            System.out.println("Costo con direccion (" + direccionElegida.getDireccion() + ") : $" + direccionElegida.getPrecio());
            System.out.println("---------------------------------");
            System.out.println("TOTAL A PAGAR: $" + calcularTotal(direccionElegida));

            String nombreSinEspacios = nombreCliente.replace(" ", "_");
            String rutaArchivo = "C:\\Users\\rlopr\\Escritorio\\.txt\\Ticket_" + nombreSinEspacios + ".txt";

            try {
                FileWriter archivo = new FileWriter(rutaArchivo, false);
                PrintWriter escritor = new PrintWriter(archivo);

                escritor.println("Cliente: " + nombreCliente);
                escritor.println("---  TICKET DE COMPRA ---");

                for (int i = 0; i < nombres.size(); i++) {
                    int cant = cantidades.get(i);
                    String nom = nombres.get(i);
                    float precioUnitario = precios.get(i);
                    float subtotalProducto = cant * precioUnitario;
                    
                    escritor.println(cant + "x " + nom + " - $" + subtotalProducto + " ($" + precioUnitario + " c/u)");
                }
                
                escritor.println("---------------------------------");
                escritor.println("Costo de envio base : $" + costoEnvio);
                escritor.println("Costo con direccion (" + direccionElegida.getDireccion() + ") : $" + direccionElegida.getPrecio());
                escritor.println("---------------------------------");
                escritor.println("TOTAL A PAGAR: $" + calcularTotal(direccionElegida));

                escritor.close();
                
                System.out.println("\nExito: Se ha generado tu recibo en el Escritorio (Ticket_" + nombreSinEspacios + ".txt)");

            } catch (IOException e) {
                System.out.println("\nError: No se pudo guardar el archivo en la ruta especificada. " + e.getMessage());
            }
        }
    }
}