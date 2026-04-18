import java.util.ArrayList;
import java.util.Scanner;

public class Perecederos extends productos {

    // ==========================================
    // 1. ATRIBUTOS
    // ==========================================
    private String fechaCaducidad;

    // ==========================================
    // 2. CONSTRUCTORES
    // ==========================================
    public Perecederos(String nombre, float precio, int stock, String categoria, String fechaCaducidad) {
        super(nombre, precio, stock, categoria);
        this.fechaCaducidad = fechaCaducidad;
    }

    // ==========================================
    // 3. POLIMORFISMO 
    // ==========================================
    @Override 
    public String obtenerDetalles() {
        return super.obtenerDetalles() + " | Caduca: " + this.fechaCaducidad;
    }

    // ==========================================
    // 4. MÉTODOS DE COMPRA 
    // ==========================================
    public static void mostrarPerecederos(carrito miCarrito) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        ArrayList<Perecederos> lista = new ArrayList<>();

        do {
            System.out.println("\n--- PRODUCTOS PERECEDEROS ---");
            lista.clear();
            int index = 0;

            for (productos p : catalogo) {
                if (p instanceof Perecederos) {
                    Perecederos per = (Perecederos) p;
                    lista.add(per);

                    System.out.println(index + ". " + p.obtenerDetalles());
                    index++;
                }
            }

            System.out.println(index + ". Salir");
            System.out.print("Seleccione producto: ");
            opcion = sc.nextInt();

            if (opcion >= 0 && opcion < lista.size()) {
                Perecederos seleccionado = lista.get(opcion);
                System.out.print("Cantidad: ");
                int cantidad = sc.nextInt();

                if (cantidad > 0) {
                    if (seleccionado.verificarDisponibilidad(cantidad)) {
                        miCarrito.agregarProductos(seleccionado, cantidad);
                    } else {
                        System.out.println("\nLo sentimos, no hay suficiente stock.");
                    }
                } else if (cantidad == 0) {
                    System.out.println("\nSeleccion cancelada: No se agregaron productos.");
                } else {
                    System.out.println("\nError: Ingrese una cantidad valida (mayor a 0).");
                }

            } else if (opcion != lista.size()) {
                System.out.println("\nOpcion no valida. Intente de nuevo.");
            }
        } while (opcion != lista.size()); 
    }

    // ==========================================
    // 5. GETTERS
    // ==========================================
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }
}