
package pos.Platillos;

import java.util.ArrayList;

public class Postres extends Platillos{
    //Atributos propios 
    ArrayList<String> menuPostres = new ArrayList<>();
    private boolean caliente;
    private String textura;
    private String sabor;
    
    //Constructor 
    public Postres(int numOrden, String nombre, double precio, boolean caliente, String textura, String sabor) {
        super(nombre, precio, numOrden);
        super.setTiempoPreparacion(10);
        this.caliente=caliente;
        this.textura=textura;
        this.sabor=sabor;
    }
    
    //Sobre-escritura de metodos  
    public synchronized void preparar() {
        super.preparar(); 
        System.out.println("-----DESCRIPCION DEL POSTRE---------");
        System.out.println("Entrada: "+getNombre());
        System.out.println("Textura: "+textura);
        System.out.println("Sabor: "+sabor);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Caliente: " + (caliente ? "Si" : "No"));
        System.out.println("Textura: " + textura);
        System.out.println("Sabor: " + sabor);
    }
}