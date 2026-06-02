package pos.Platillos;

import java.io.Serializable;

public abstract class Platillos implements Serializable {
    private static final long serialVersionUID = 1L;
    protected int calorias;
    protected String nombre;
    protected int precio;

    public Platillos(int calorias, String nombre, int precio) {
        this.calorias = calorias;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCalorias() {
        return calorias;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public abstract void mostrarInformacion();

    public abstract void preparar();
}
