
package pos.Platillos;

public class Platillos {
    // Atributos de la clase
    private int numOrden;
    private String nombre;
    private double precio;
    private int tiempoPreparacion;

    // Constructor
    public Platillos(String nombre, double precio, int numOrden) {
        setTiempoPreparacion(20);
        this.numOrden = numOrden;
        this.nombre = nombre;
        this.precio = precio;
    }

    // gets
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempo) {
        tiempoPreparacion = tiempo;
    }

    // metodo preparar
    public synchronized void preparar() {
        System.out.println("Inciiando preparacion del platillo...");
        System.out.println("El platillo: " + this.nombre + " incia su preparación");
        try {
            Thread.sleep(this.tiempoPreparacion);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(" ---------PEDIDO LISTO---------" + this.nombre);
    }

    public void mostrarInformacion() {
        System.out.println(numOrden + ". " + this.nombre);
        System.out.println("Precio: " + this.precio);
        System.out.println("Tiempo de preparación: " + this.tiempoPreparacion + " minutos");
    }
}
