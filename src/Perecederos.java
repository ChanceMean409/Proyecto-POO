
import java.util.ArrayList;
import java.util.Scanner;

public class Perecederos extends productos {

    private String fechaCaducidad;

    public Perecederos(String nombre, float precio, int stock, String categoria, String fechaCaducidad) {
        super(nombre, precio, stock, categoria);
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }
// compra 
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

                System.out.println(
                    index + ". " +
                    p.getNombre() +
                    " - $" + p.getPrecio() +
                    " | Stock: " + p.getStock() +
                    " | Caduca: " + per.getFechaCaducidad()
                );

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

            if (seleccionado.verificarDisponibilidad(cantidad)) {
                miCarrito.agregarProductos(seleccionado, cantidad);
            } else {
                System.out.println("No hay suficiente stock.");
            }
        }

    } while (opcion != lista.size()); 
}}