
package pos.Empleados;

import pos.Platillos.Platillos;

public class Empleados implements Runnable {
    // Constructor
    private int numeroEmpleado;
    private String nombre;
    private String tipo;
    Platillos platillo;

    // Constructor
    public Empleados(int numeroEmpleado, String nombre, Platillos platillo) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.tipo = tipo;
        this.platillo = platillo;
    }


    public void run() {
        System.out.println(nombre + " recibe el platillo: " + platillo);
        platillo.preparar();
        System.out.println("Entrega el pedido");
    }

}
