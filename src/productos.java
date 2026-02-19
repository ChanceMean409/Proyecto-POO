
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

        catalogo.add(new productos("pan", 38,59, "harinas"));
        catalogo.add(new productos("atun",35, 20, "enlatados"));
        catalogo.add(new productos("chiplotles", 15, 48, "enlatados"));
        catalogo.add(new productos("vasos de unicel", 20, 30, "desechables"));
        catalogo.add(new productos("coca cola", 54, 20, "bebidas"));
        catalogo.add(new productos("leche", 25, 58, "lacteos"));
        catalogo.add(new productos("queso", 15, 10, "lacteos"));
        catalogo.add(new productos("sopa", 10, 48, "harinas"));
        catalogo.add(new productos("mayonesa", 35, 7, "enlatados"));
        catalogo.add(new productos("corn flakes", 57, 17, "harinas"));
    }
    // Verificar disponibilidad
    public boolean verificarDisponibilidad(int cantidad) {
        if (cantidad > 0 && stock >= cantidad) {
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
}
