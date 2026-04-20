import java.util.ArrayList;
import java.util.Scanner;

public class NoPedecederos extends productos {
    
    // ==========================================
    // 1. ATRIBUTOS  
    // ==========================================
    private String tipoDeEmpaque;
    
    // ==========================================
    // 2. HERENCIA 
    // ==========================================
    public NoPedecederos(String nombre, float precio, int stock, String categoria, String tipoDeEmpaque) {
        super(nombre, precio, stock, categoria);
        this.tipoDeEmpaque = tipoDeEmpaque;
    }

    // ==========================================
    // 3. POLIMORFISMO Y INVENTARIO 
    // ==========================================
    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + " | Empaque: " + this.tipoDeEmpaque;
    }
 public static void inventario() {
        catalogo.add(new NoPedecederos("Jabon en barra", 2, 40, "Limpieza", "Envoltura de papel"));
        catalogo.add(new NoPedecederos("Detergente polvo", 5, 25, "Limpieza", "Bolsa plastica"));
        catalogo.add(new NoPedecederos("Papel higienico", 3, 50, "Higiene", "Empaque plastico (4 rollos)"));
        catalogo.add(new NoPedecederos("Pasta dental", 4, 30, "Higiene", "Caja de carton"));
        catalogo.add(new NoPedecederos("Champu", 6, 20, "Cuidado Personal", "Botella de plástico"));
        catalogo.add(new NoPedecederos("Esponja de cocina", 1, 60, "Limpieza", "Bolsa de polipropileno"));
        catalogo.add(new NoPedecederos("Pilas AA", 7, 15, "Ferreteria", "Blister de carton y plastico"));
        catalogo.add(new NoPedecederos("Fosforos", 1, 100, "Hogar", "Caja de carton"));
        catalogo.add(new NoPedecederos("Bombilla LED", 4, 22, "Iluminacion", "Caja de carton"));
        catalogo.add(new NoPedecederos("Cloro", 2, 18, "Desinfectantes", "Botella de polietileno"));
        catalogo.add(new NoPedecederos("Cinta adhesiva", 2, 12, "Papeleria", "Rollo plastico"));
        catalogo.add(new NoPedecederos("Bolsas de basura", 3, 35, "Limpieza", "Rollo con banda de papel"));
        catalogo.add(new NoPedecederos("Velas blancas", 5, 10, "Hogar", "Paquete de celofan"));
    }
 
    // ==========================================
    // 4. MENU Y VALIDACIONES  
    // ==========================================
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
    
    // ==========================================
    // 5. GETTERS
    // ==========================================
    public String getTipoDeEmpaque() { return tipoDeEmpaque; }
}