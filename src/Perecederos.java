public  class Perecederos extends productos {
    private int diasParaCaducar ;

    public Perecederos (String nombre, float precio, int stock, String categoria, int diasParaCaducar){
    super(nombre, precio,stock, categoria) ;
    this.diasParaCaducar=diasParaCaducar ;
    }
    public int getDiasParaCaducar(){
    return diasParaCaducar ;
    }
    // inventario de pedecederos 
    public static void inventarioPerecederos(){

        if(!listaPerecederos.isEmpty()) return;

        listaPerecederos.add(new Perecederos("Leche",31,58,"Lacteos",7));
        listaPerecederos.add(new Perecederos("Queso Oaxaca",55,10,"Lacteos",5));
        listaPerecederos.add(new Perecederos("Queso Fresco",35,10,"Lacteos",4));
    }
}
