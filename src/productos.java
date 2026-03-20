import java.util.ArrayList;
public class productos {
    protected String nombre;
    protected float precio;
    protected int stock;
    protected String categoria;
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
        // pedecederos
        catalogo.add(new Perecederos("Pan de elote (2 piezas)",15,59, "Harinas","25/03/2026"));
        catalogo.add(new Perecederos("Pan Chocha de vainilla (1 unidad)", 15,39, "Harinas","24/04/2026"));
        catalogo.add(new Perecederos ("Atun en agua",25, 20, "Enlatados","12/06/2026"));
        catalogo.add(new Perecederos("Atun en aceite",35, 25, "Enlatados","03/08/2026"));
        catalogo.add(new Perecederos("Chiplotles (bolsa pequena)", 15, 48, "Enlatados","19/09/2026"));
        catalogo.add(new Perecederos("Vasos desechables (10 vasos)", 20, 30, "Desechables","31/10/2026"));
        catalogo.add(new Perecederos("Coca cola 3L", 54, 20, "Bebidas","14/12/2026"));
        catalogo.add(new Perecederos("Leche", 31, 58, "Lacteos","27/03/2026"));
        catalogo.add(new Perecederos("Queso Oaxaca", 55, 10, "Lacteos","11/03/2026"));
        catalogo.add(new Perecederos("Queso Fresco", 35, 10, "Lacteos","22/05/2026"));
        catalogo.add(new Perecederos("Sopa", 7, 48, "Harinas","05/07/2026"));
        catalogo.add(new Perecederos("Mayonesa", 35, 10, "Enlatados","30/09/2026"));
        catalogo.add(new Perecederos("Corn flakes", 55, 17, "Harinas","25/11/2026"));
        // no perecederos
        catalogo.add(new NoPedecederos("Jabón en barra", 2, 40, "Limpieza", "Envoltura de papel"));
        catalogo.add(new NoPedecederos("Detergente polvo", 5, 25, "Limpieza", "Bolsa plástica"));
        catalogo.add(new NoPedecederos("Papel higiénico", 3, 50, "Higiene", "Empaque plástico (4 rollos)"));
        catalogo.add(new NoPedecederos("Pasta dental", 4, 30, "Higiene", "Caja de cartón"));
        catalogo.add(new NoPedecederos("Champú", 6, 20, "Cuidado Personal", "Botella de plástico"));
        catalogo.add(new NoPedecederos("Esponja de cocina", 1, 60, "Limpieza", "Bolsa de polipropileno"));
        catalogo.add(new NoPedecederos("Pilas AA",7, 15, "Ferretería", "Blister de cartón y plástico"));
        catalogo.add(new NoPedecederos("Fósforos", 1, 100, "Hogar", "Caja de cartón"));
        catalogo.add(new NoPedecederos("Bombilla LED", 4, 22, "Iluminación", "Caja de cartón"));
        catalogo.add(new NoPedecederos("Cloro", 2, 18, "Desinfectantes", "Botella de polietileno"));
        catalogo.add(new NoPedecederos("Cinta adhesiva", 2, 12, "Papelería", "Rollo plástico"));
        catalogo.add(new NoPedecederos("Bolsas de basura", 3, 35, "Limpieza", "Rollo con banda de papel"));
        catalogo.add(new NoPedecederos("Velas blancas", 5, 10, "Hogar", "Paquete de celofán"));
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