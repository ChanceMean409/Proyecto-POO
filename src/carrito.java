

import java.util.ArrayList;
import java.util.List;

public class carrito {
    //definicion de atributos
    private List<productos> listaDeProductos;
    private float costoEnvio;
    private float descuento;
    
    //constructor sin argumentos
    public carrito(){
        this.listaDeProductos = new ArrayList<>();
        this.costoEnvio = 150;
        this.descuento=0;
    }
    //metodo de agregar objetos
    public void agregarProductos(productos nuevoProducto){
        listaDeProductos.add(nuevoProducto);
        System.out.println("Producto Agregado Exitosamente.");
    }
        //metodo de quitar productos
    public void eliminarProducto(int indice){
        if (indice >= 0 && indice < listaDeProductos.size()){
        listaDeProductos.remove(indice);
        }else{
        System.out.println("Numero de Producto Invalido");
        }
      }
    //Calcular total
    public float calcularTotal(){
        float subtotal=0;
        for (productos p : listaDeProductos) {
            subtotal=subtotal+p.getPrecio();
        }
       return subtotal+costoEnvio - descuento;
     }
    //mostrar carrito final
    public void mostrarDetalle(){
        System.out.println("\n---MI CARRITO ---");
        if (listaDeProductos.isEmpty()) {
            System.out.println("El Carrito está vacío.");
        }else{
            for (int i = 0; i < listaDeProductos.size(); i++) {
                productos p = listaDeProductos.get(i);
                System.out.println("["+ i+ "]"+ p.getNombre()+ " - $"+p.getPrecio());
            }
            System.out.println("Costo de envío: $"+costoEnvio);
            System.out.println("TOTAL A PAGAR: $"+calcularTotal());
        }
      }
    }

