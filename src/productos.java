
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
    public static void inventario(){
        
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
