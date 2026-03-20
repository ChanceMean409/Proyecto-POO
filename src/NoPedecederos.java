import java.util.ArrayList;
import java.util.Scanner;

public class NoPedecederos extends productos {

    private String tipoDeEmpaque;

    public NoPedecederos(String nombre, float precio, int stock, String categoria, String tipoDeEmpaque) {
        super(nombre, precio, stock, categoria);
        this.tipoDeEmpaque = tipoDeEmpaque;
    }

    public String getTipoDeEmpaque() {
        return tipoDeEmpaque;
    }

    // compra 
    public static void mostrarNoPerecederos(carrito miCarrito) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        ArrayList<NoPedecederos> lista = new ArrayList<>();

        do {
            System.out.println("\n--- PRODUCTOS NO PERECEDEROS ---");

            lista.clear();
            int index = 0;

            for (productos p : catalogo) {
                if (p instanceof NoPedecederos) {
                    NoPedecederos np = (NoPedecederos) p;

                    lista.add(np);

                    System.out.println(
                        index + ". " +
                        p.getNombre() +
                        " - $" + p.getPrecio() +
                        " | Stock: " + p.getStock() +
                        " | Empaque: " + np.getTipoDeEmpaque()
                    );

                    index++;
                }
            }

            System.out.println(index + ". Salir");
            System.out.print("Seleccione producto: ");
            opcion = sc.nextInt();

            if (opcion >= 0 && opcion < lista.size()) {
                NoPedecederos seleccionado = lista.get(opcion);

                System.out.print("Cantidad: ");
                int cantidad = sc.nextInt();

                // Validación de cantidad
                if (cantidad > 0) {
                    if (seleccionado.verificarDisponibilidad(cantidad)) {
                        miCarrito.agregarProductos(seleccionado, cantidad);
                    } else {
                        System.out.println("\nLo sentimos, no hay suficiente stock.");
                    }
                } else {
                    System.out.println("\nPor favor, ingrese una cantidad mayor a 0.");
                }
                
            // Validación de opción incorrecta
            } else if (opcion != lista.size()) {
                System.out.println("\nOpcion no valida. Intente de nuevo.");
            }

        } while (opcion != lista.size()); 
    }
}