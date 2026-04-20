import java.util.ArrayList;


public class productos {
    
    // ==========================================
    // 1. ATRIBUTOS 
    // ==========================================
    protected String nombre;
    protected float precio;
    protected int stock;
    protected String categoria;
    
    public static ArrayList<productos> catalogo = new ArrayList<>();

    // ==========================================
    // 2. CONSTRUCTORES
    // ==========================================
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

    // ==========================================
    // 3. MÉTODOS POLIMÓRFICOS
    // ==========================================
    public String obtenerDetalles() {
        return this.nombre + " - $" + this.precio + " | Stock: " + this.stock;
    }

    public boolean verificarDisponibilidad(int inventario) {
        if (inventario > 0 && stock >= inventario) {
            return true;
        } else {
            return false;
        }
    }

    public void actualizarStock(int cantidad) {
        if (verificarDisponibilidad(cantidad)) {
            stock -= cantidad;
        }
    }

    // ==========================================
    // 5. GETTERS 
    // ==========================================
    public String getNombre() { return this.nombre; }
    public float getPrecio() { return this.precio; }
    public String getCategoria() { return this.categoria; }
    public int getStock() { return this.stock; }
}