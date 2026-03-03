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
    
    //METODO DE INVENTARIO PREDETERMINADO
      public static void inventario() {
        if (!catalogo.isEmpty()) return; // evita duplicados
        
        catalogo.add(new productos("Pan de elote (2 piezas)",15,59, "Harinas"));
        catalogo.add(new productos("Pan Choncha de vainilla (1 unidad)", 15,39, "Harinas"));
        catalogo.add(new productos("Atun en agua",25, 20, "Enlatados"));
        catalogo.add(new productos("Atun en aceite",35, 25, "Enlatados"));
        catalogo.add(new productos("Chiplotles (bolsa pequena)", 15, 48, "Enlatados"));
        catalogo.add(new productos("Vasos desechables (10 vasos)", 20, 30, "Desechables"));
        catalogo.add(new productos("Coca cola 3L", 54, 20, "Bebidas"));
        catalogo.add(new productos("Leche", 31, 58, "Lacteos"));
        catalogo.add(new productos("Queso Oaxaca", 55, 10, "Lacteos"));
        catalogo.add(new productos("Queso Fresco", 35, 10, "Lacteos"));
        catalogo.add(new productos("Sopa", 7, 48, "Harinas"));
        catalogo.add(new productos("Mayonesa", 35, 10, "Enlatados"));
        catalogo.add(new productos("Corn flakes", 55, 17, "Harinas"));
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