
package pos.Platillos;

import java.util.ArrayList;

public class Bebidas extends Platillos {
    // atributos
    ArrayList<String> menuBebidas = new ArrayList<>();
    private String nombre;
    private double precio;
    private boolean alcohol;

    // Constructor
    public Bebidas(int numOrden, String nombre, double precio, boolean alcohol) {
        super(nombre, precio, numOrden);
        super.setTiempoPreparacion(5);
        this.nombre = nombre;
        this.precio = precio;
        this.alcohol = alcohol;
    }

    public void preparar_bebida() {
        System.out.println("Inciiando preparacion de la bebida...");
        System.out.println("El platillo: " + this.nombre + " incia su preparación");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(" ---------PEDIDO LISTO---------" + this.nombre);
    }
}
