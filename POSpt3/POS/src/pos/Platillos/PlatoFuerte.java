
package pos.Platillos;

import java.util.ArrayList;

public class PlatoFuerte extends Platillos {
    // Atributos
    ArrayList<String> menuPlatoFuerte = new ArrayList<>();
    private int temperatura;
    private int calorias;
    private boolean guarnicon;

    // Construtcor
    public PlatoFuerte(int numOrden, String nombre, double precio, int temperatura, int calorias, boolean guarnicon) {
        super(nombre, precio, numOrden);
        super.setTiempoPreparacion(30);
        this.calorias = calorias;
        this.temperatura = temperatura;
        this.guarnicon = guarnicon;
    }

    public synchronized void preparar() {
        super.preparar();
        System.out.println("-----DESCRIPCION DE PLATO FUERTE---------");
        System.out.println("Entrada: " + getNombre());
        System.out.println("Guarnicion: " + guarnicon);
        System.out.println("Temperatura interna: " + temperatura);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Calorias: " + calorias);
        System.out.println("Temperatura interna: " + temperatura);
        System.out.println("Guarnicion: " + (guarnicon ? "Si" : "No"));
    }
}
