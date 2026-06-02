package pos.Platillos;

public class Bebidas extends Platillos {
    private boolean alcoholica;

    public Bebidas(int calorias, String nombre, int precio, boolean alcoholica) {
        super(calorias, nombre, precio);
        this.alcoholica = alcoholica;
    }

    public boolean isAlcoholica() { 
        return alcoholica; 
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Bebida: " + nombre + " | Precio: $" + precio +
                (alcoholica ? " | Alcohólica" : ""));
    }

    @Override
    public void preparar() {
        System.out.println("Cantinero Preparando bebida: " + nombre);
        try {
            // 2 minutos = 2 segundos
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Cantinero Bebida lista: " + nombre);
    }
}
