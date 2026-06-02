package pos.Platillos;

public class Entrada extends Platillos {
    private boolean aderezo;
    private String tamano;

    public Entrada(int calorias, String nombre, int precio, boolean aderezo, String tamano) {
        super(calorias, nombre, precio);
        this.aderezo = aderezo;
        this.tamano = tamano;
    }

    public boolean isAderezo() { 
        return aderezo; 
    }
    public void setAderezo(boolean aderezo) { 
        this.aderezo = aderezo; 
    }
    public String getTamano() { 
        return tamano;
     }
    public void setTamano(String tamano) { 
        this.tamano = tamano; 
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Entrada: " + nombre + " | Precio: $" + precio +
                " | Aderezo: " + (aderezo ? "Sí" : "No") +
                " | Tamaño: " + (tamano != null ? tamano : "Mediano"));
    }

    @Override
    public void preparar() {
        System.out.println("[CocineroEntradas] Preparando entrada: " + nombre);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[CocineroEntradas] Entrada lista: " + nombre);
    }
}
