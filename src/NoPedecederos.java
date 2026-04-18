import java.util.ArrayList;
import java.util.Scanner;

public class NoPedecederos extends productos {

    private String tipoDeEmpaque;

    public NoPedecederos(String nombre, float precio, int stock, String categoria, String tipoDeEmpaque) {
        super(nombre, precio, stock, categoria);
        this.tipoDeEmpaque = tipoDeEmpaque;
    }

    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + " | Empaque: " + this.tipoDeEmpaque;
    }

    public static void mostrarNoPerecederos(carrito miCarrito) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        ArrayList<NoPedecederos> lista = new ArrayList<>();

        do {
            System.out.println("\n--- PRODUCTOS NO PERECEDEROS ---");
            lista.clear();
            int index = 0;

            for (productos p : catalogo) {
                if (p instanceof NoPedecederos) {
                    NoPedecederos np = (NoPedecederos) p;
                    lista.add(np);
                    System.out.println(index + ". " + p.obtenerDetalles());
                    index++;
                }
            }

            System.out.println(index + ". Salir");
            System.out.print("Seleccione producto: ");
            
            // --- Validacion de caracteres y decimales ---
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1; 
            }

            if (opcion >= 0 && opcion < lista.size()) {
                NoPedecederos seleccionado = lista.get(opcion);
                
                int cantidad = -1;
                boolean cantidadValida = false;

                while (!cantidadValida) {
                    System.out.print("Cantidad para " + seleccionado.getNombre() + " (0 para cancelar): ");
                    
                    // --- Validacion de caracteres y decimales ---
                    try {
                        cantidad = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        cantidad = -1; 
                    }

                    if (cantidad > 0) {
                        if (seleccionado.verificarDisponibilidad(cantidad)) {
                            miCarrito.agregarProductos(seleccionado, cantidad);
                            cantidadValida = true;
                        } else {
                            System.out.println("\nLo sentimos, no hay suficiente stock.");
                        }
                    } else if (cantidad == 0) {
                        System.out.println("\nSeleccion cancelada.");
                        cantidadValida = true;
                    } else {
                        System.out.println("\nError: Ingrese una cantidad valida (un numero entero mayor o igual a 0).");
                    }
                }

            } else if (opcion != lista.size()) {
                System.out.println("\nOpcion no valida. Ingrese un numero de la lista.");
            }
        } while (opcion != lista.size()); 
    }

    public String getTipoDeEmpaque() { return tipoDeEmpaque; }
}