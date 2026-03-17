public class NoPedecederos extends productos {
    private String tipoDeEmpaque ;
    
    public NoPedecederos(String nombre,float precio, int stock, String categoria, String tipoDeEmpaque){
    super(nombre, precio, stock, categoria);
    this.tipoDeEmpaque=tipoDeEmpaque ;
    }
    
    public String tipoDeEmpaque(){
    return tipoDeEmpaque ;
    }
    // inventario de no pedecederos
    public static void inventarioNoPedecederos(){

        if(!listaNoPerecederos.isEmpty()) return;

        listaNoPerecederos.add(new NoPedecederos("Atun en agua",25,20,"Enlatados","Lata"));
        listaNoPerecederos.add(new NoPedecederos("Atun en aceite",35,25,"Enlatados","Lata"));
        listaNoPerecederos.add(new NoPedecederos("Mayonesa",35,10,"Enlatados","Frasco"));
        listaNoPerecederos.add(new NoPedecederos("Pan de elote (2 piezas)",15,59,"Harinas","Bolsa"));
        listaNoPerecederos.add(new NoPedecederos("Sopa",7,48,"Harinas","Bolsa"));
    }
// metodo para el carrito
   public String getTipoEmpaque(){
    return tipoDeEmpaque;
}
    }
