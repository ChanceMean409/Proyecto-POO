import java.util.ArrayList;
import java.util.Scanner;

public class Perecederos extends productos {
    
    // ==========================================
    // 1. ATRIBUTOS 
    // ==========================================
    private String fechaCaducidad;
    
    // ==========================================
    // 2. HERENCIA  
    // ==========================================
    public Perecederos(String nombre, float precio, int stock, String categoria, String fechaCaducidad) {
        super(nombre, precio, stock, categoria);
        this.fechaCaducidad = fechaCaducidad;
    }
    
    // ==========================================
    // 3. POLIMORFISMO Y INVENTARIO 
    // ==========================================
    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + " | Caduca: " + this.fechaCaducidad;
    }
        public static void inventario() {
        catalogo.add(new Perecederos("Pan de elote (2 piezas)", 15, 59, "Harinas", "25/03/2026"));
        catalogo.add(new Perecederos("Pan Chocha de vainilla (1 unidad)", 15, 39, "Harinas", "24/04/2026"));
        catalogo.add(new Perecederos("Atun en agua", 25, 20, "Enlatados", "12/06/2026"));
        catalogo.add(new Perecederos("Atun en aceite", 35, 25, "Enlatados", "03/08/2026"));
        catalogo.add(new Perecederos("Chiplotles (bolsa pequena)", 15, 48, "Enlatados", "19/09/2026"));
        catalogo.add(new Perecederos("Vasos desechables (10 vasos)", 20, 30, "Desechables", "31/10/2026"));
        catalogo.add(new Perecederos("Coca cola 3L", 54, 20, "Bebidas", "14/12/2026"));
        catalogo.add(new Perecederos("Leche", 31, 58, "Lacteos", "27/03/2026"));
        catalogo.add(new Perecederos("Queso Oaxaca", 55, 10, "Lacteos", "11/03/2026"));
        catalogo.add(new Perecederos("Queso Fresco", 35, 10, "Lacteos", "22/05/2026"));
        catalogo.add(new Perecederos("Sopa", 7, 48, "Harinas", "05/07/2026"));
        catalogo.add(new Perecederos("Mayonesa", 35, 10, "Enlatados", "30/09/2026"));
        catalogo.add(new Perecederos("Corn flakes", 55, 17, "Harinas", "25/11/2026"));
        }
           
    // ==========================================
    // 4. MENU Y VALIDACIONES 
    // ==========================================
public static void mostrarPerecederos(carrito miCarrito) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1; 
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
            
            // --- Validacion de caracteres y decimales ---
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1; 
            }

            if (opcion >= 0 && opcion < lista.size()) {
                Perecederos seleccionado = lista.get(opcion);
                
                int cantidad = -1;
                boolean cantidadValida = false;

                // Bloqueamos al usuario hasta que de una cantidad real o cancele con 0
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
    public String getFechaCaducidad() { return fechaCaducidad; }
}