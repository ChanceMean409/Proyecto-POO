import java.util.ArrayList;
public class productos {
    
    private String nombre;
    private float precio;
    private int stock;
    private String categoria;
    //LISTA de productos
    public static ArrayList<productos> catalogo=new ArrayList<>();
    
    // CONSTRUCTOR sin argumentos (producto ya definido)
    public productos() {
        nombre = "";
        precio = 0;
        stock = 0;
        categoria = "";
    }

    //CONSTRUCTOR con argumentos
    public productos(String nombre, float precio, int stock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }
        // nueva forma de inventario
    public static ArrayList<Perecederos> listaPerecederos = new ArrayList<>();
    public static ArrayList<NoPedecederos> listaNoPerecederos = new ArrayList<>();
    // creacion de los inventario al general
     public static void generarCatalogo(){

        if(!catalogo.isEmpty()) return;

        catalogo.addAll(listaPerecederos);
        catalogo.addAll(listaNoPerecederos);
    }
   
    // METODO para verificar disponibilidad
    public boolean verificarDisponibilidad(int inventario) {
        if (inventario > 0 && stock >= inventario) {
            return true;
        } else {
            return false;
        }
    }

    // METODO PARA actualizar stock
    public void actualizarStock(int cantidad) {
        if (verificarDisponibilidad(cantidad)) {
            stock -= cantidad;
        }
    }
    
    //GETTERS
    public String getNombre(){
        return this.nombre;
    }
    public float getPrecio(){
        return this.precio;
    }
    public String getCategoria() {
        return this.categoria;
    }
    public int getStock() {
        return this.stock;
    }
}