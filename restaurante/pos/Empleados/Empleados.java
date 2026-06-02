package pos.Empleados;

import pos.Platillos.Platillos;

public class Empleados implements Runnable {
    private int numeroEmpleado;
    private String nombre;
    protected Platillos platillo;

    public Empleados(int numeroEmpleado, String nombre, Platillos platillo) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.platillo = platillo;
    }

    public int getNumeroEmpleado() {
         return numeroEmpleado;
         }
         
    public String getNombre() {
         return nombre;
         }

    @Override
    public void run() {
        System.out.println(nombre + " recibe el platillo: " + platillo.getNombre());
        platillo.preparar();
        System.out.println(nombre + " entrega el pedido: " + platillo.getNombre());
    }
}
