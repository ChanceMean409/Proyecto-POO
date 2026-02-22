import java.util.ArrayList;
import java.util.List;

public class carrito {
    
    // Definicion de atributos
    private List<productos> listaDeProductos;
    private float costoEnvio;
    
    // Constructor sin argumentos
    public carrito(){
        this.listaDeProductos = new ArrayList<>();
        this.costoEnvio = 10;
    }
    
    // Metodo de agregar objetos
    public void agregarProductos(productos nuevoProducto){
        listaDeProductos.add(nuevoProducto);
        System.out.println("Producto Agregado Exitosamente.");
    }
    
    // Metodo de quitar productos (Ojo: los índices aquí son por cada producto individual)
    public void eliminarProducto(int indice){
        if (indice >= 0 && indice < listaDeProductos.size()){
            listaDeProductos.remove(indice);
        } else {
            System.out.println("Numero de Producto Invalido");
        }
    }
    
    // Calcular total (¡Corregido para cobrar los 10 pesos base!)
    public float calcularTotal(cliente direccionElegida){
        float subtotal = 0;
        for (productos p : listaDeProductos) {
            subtotal = subtotal + p.getPrecio();
        }
        // Ahora sí suma los productos + la zona + el costo base de 10
        return subtotal + direccionElegida.getPrecio() + costoEnvio;
    }
    
    // Mostrar carrito y stackear (agrupar) productos repetidos
    public void mostrarDetalle(cliente direccionElegida){
        System.out.println("\n---  TICKET DE COMPRA ---");
        
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
                
                // Si el producto ya está en nuestra lista agrupada, le sumamos 1
                if (nombres.contains(nombreActual)) {
                    int index = nombres.indexOf(nombreActual);
                    cantidades.set(index, cantidades.get(index) + 1);
                } 
                // Si es un producto nuevo, lo agregamos por primera vez
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
                
                // Formato: 3x Pan - $114.0 ($38.0 c/u)
                System.out.println(cant + "x " + nom + " - $" + subtotalProducto + " ($" + precioUnitario + " c/u)");
            }
            
            System.out.println("---------------------------------");
            System.out.println("Costo de envio base : $" + costoEnvio);
            System.out.println("Costo con direccion (" + direccionElegida.getDireccion() + ") : $" + direccionElegida.getPrecio());
            System.out.println("---------------------------------");
            System.out.println("TOTAL A PAGAR: $" + calcularTotal(direccionElegida));
        }
    }
}