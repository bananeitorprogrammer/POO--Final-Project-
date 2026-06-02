package pos.Platillos;

public class Postres extends Platillos {
    private boolean especial;
    private String sabor;
    private String tamano;

    public Postres(int calorias, String nombre, int precio, boolean especial, String sabor, String tamano) {
        super(calorias, nombre, precio);
        this.especial = especial;
        this.sabor = sabor;
        this.tamano = tamano;
    }

    public boolean isEspecial() { 
        return especial;
     }

    public String getSabor() {
         return sabor; 
        }

    public String getTamano() {
         return tamano; 
        }

    public void setTamano(String tamano) { 
        this.tamano = tamano; 
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Postre: " + nombre + " | Precio: $" + precio);
    }

    @Override
    public void preparar() {
        System.out.println("[Pastelero] Preparando postre: " + nombre);
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[Pastelero] Postre listo: " + nombre);
    }
}
