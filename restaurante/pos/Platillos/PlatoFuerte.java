package pos.Platillos;

public class PlatoFuerte extends Platillos {
    private int guarnicion; // 0=Sin, 1=Papas, 2=Arroz, 3=Puré
    private boolean tamanoGrande;
    private String tamano;

    public PlatoFuerte(int calorias, String nombre, int precio, int guarnicion, boolean tamanoGrande) {
        super(calorias, nombre, precio);
        this.guarnicion = guarnicion;
        this.tamanoGrande = tamanoGrande;
        this.tamano = "Mediano";
    }

    public int getGuarnicion() {
         return guarnicion;
         }

    public void setGuarnicion(int guarnicion) {
         this.guarnicion = guarnicion;
         }

    public String getTamano() {
         return tamano; 
        }

    public void setTamano(String tamano) {
         this.tamano = tamano;
         }

    public String getNombreGuarnicion() {
        String[] guarniciones = {"Sin guarnición", "Papas fritas", "Arroz", "Puré"};
        return guarnicion >= 0 && guarnicion < guarniciones.length ? guarniciones[guarnicion] : "Sin guarnición";
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Plato Fuerte: " + nombre + " | Precio: $" + precio +
                " | Guarnición: " + getNombreGuarnicion() +
                " | Tamaño: " + tamano);
    }

    @Override
    public void preparar() {
        System.out.println("[CocineroPrincipal] Preparando plato fuerte: " + nombre);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[CocineroPrincipal] Plato fuerte listo: " + nombre);
    }
}
