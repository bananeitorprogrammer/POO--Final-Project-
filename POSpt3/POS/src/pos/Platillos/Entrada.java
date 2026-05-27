package pos.Platillos;

import java.util.ArrayList;

public class Entrada extends Platillos {
    // Atributos
    ArrayList<String> menuEntradas = new ArrayList<>();
    private boolean aderezo;
    private String tamano;

    // Constructor
    public Entrada(int numOrden, String nombre, double precio, boolean aderezo, String tamano) {
        super(nombre, precio, numOrden);
        super.setTiempoPreparacion(15);
        this.aderezo = aderezo;
        this.tamano = tamano;
    }

    // Sobre-esritura de metodos
    @Override
    public synchronized void preparar() {
        super.preparar();
        System.out.println("-----DESCRIPCION DE ENTRADA---------");
        System.out.println("Entrada: " + getNombre());
        System.out.println("Aderezo: " + aderezo);
        System.out.println("Tamano: " + tamano);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println(aderezo ? "Con aderezo" : "Sin aderezo");
        System.out.println("Tamano: " + tamano);
    }

}
