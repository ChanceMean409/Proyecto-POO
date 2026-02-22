

import java.util.ArrayList;
import java.util.List;

public class carrito {
    //definicion de atributos
    private List<productos> listaDeProductos;
    private float costoEnvio;
    
    //constructor sin argumentos
    public carrito(){
        this.listaDeProductos = new ArrayList<>();
        this.costoEnvio = 10;
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
    public float calcularTotal(cliente direccionElegida){
        float subtotal=0;
        for (productos p : listaDeProductos) {
            subtotal=subtotal+p.getPrecio();
        }
       return subtotal+ direccionElegida.getPrecio();
     }
    //mostrar carrito subtotal
    public void mostrarDetalle(cliente direccionElegida){
        System.out.println("\n---  MI CARRITO ---");
        if (listaDeProductos.isEmpty()) {
            System.out.println("El Carrito esta vacio.");
        }else{
            for (int i = 0; i < listaDeProductos.size(); i++) {
                productos p = listaDeProductos.get(i);
                System.out.println("["+ i+ "]"+ p.getNombre()+ " - $"+p.getPrecio());
            }
            System.out.println("Costo de envio base : $"+costoEnvio);
            System.out.println("Costo con direccion ("+direccionElegida.getDireccion()+") : $"+direccionElegida.getPrecio());
            System.out.println("TOTAL A PAGAR: $"+calcularTotal(direccionElegida));
        }
      }
    }

