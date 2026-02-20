
import java.util.ArrayList;

public class productos {
    
    private String nombre;
    private float precio;
    private int stock;
    private String categoria;
    //lista de productos
    public static ArrayList<productos> catalogo=new ArrayList<>();
    // Constructor sin argumentos (producto ya definido)
    public productos() {
        nombre = "";
        precio = 0;
        stock = 0;
        categoria = "";
    }
    public productos(String nombre, float precio, int stock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }
    //Inventario
      public static void inventario() {
        if (!catalogo.isEmpty()) return; // evita duplicados

        catalogo.add(new productos("Pan", 38,59, "Harinas"));
        catalogo.add(new productos("Atun",35, 20, "Enlatados"));
        catalogo.add(new productos("Chiplotles", 15, 48, "Enlatados"));
        catalogo.add(new productos("Vasos de unicel", 20, 30, "Desechables"));
        catalogo.add(new productos("Coca cola", 54, 20, "Bebidas"));
        catalogo.add(new productos("Leche", 25, 58, "Lacteos"));
        catalogo.add(new productos("Queso", 15, 10, "Lacteos"));
        catalogo.add(new productos("Sopa", 10, 48, "Harinas"));
        catalogo.add(new productos("Mayonesa", 35, 7, "Enlatados"));
        catalogo.add(new productos("Corn flakes", 57, 17, "Harinas"));
    }
    // Verificar disponibilidad
    public boolean verificarDisponibilidad(int inventario) {
        if (inventario > 0 && stock >= inventario) {
            return true;
        } else {
            return false;
        }
    }

    // Actualizar stock
    public void actualizarStock(int cantidad) {
        if (verificarDisponibilidad(cantidad)) {
            stock -= cantidad;
        }
    }
    public String getNombre(){
        return this.nombre;
    }
    public float getPrecio(){
        return this.precio;
    }
}
