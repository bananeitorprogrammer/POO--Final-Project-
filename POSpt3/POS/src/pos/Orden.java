package pos;

import java.util.ArrayList;

import pos.Platillos.Bebidas;
import pos.Platillos.Entrada;
import pos.Platillos.Platillos;
import pos.Platillos.PlatoFuerte;
import pos.Platillos.Postres;

public class Orden {
    ArrayList<Platillos> menu = new ArrayList<Platillos>();

    public Orden() {
        inicializarMenu();
    }

    public void inicializarMenu() {
        menu.add(new Entrada(1,"Ensalada Niçoise", 180, false, null));
        menu.add(new Entrada(2,"Sopa de cebolla", 120, false, null));
        menu.add(new Entrada(3,"Caracoles cocinados", 250, false, null));
        menu.add(new Entrada(4,"Tabla de quesos y embutidos", 220, false, null));

        menu.add(new PlatoFuerte(5,"Carne con papas", 290, 0, 0, false));
        menu.add(new PlatoFuerte(6,"Mejillones", 240, 0, 0, false));
        menu.add(new PlatoFuerte(7,"Ratatouille", 350, 0, 0, false));
        menu.add(new PlatoFuerte(8,"Pollo estofado en vino tinto", 350, 0, 0, false));

        menu.add(new Postres(9,"Crème Brûlée", 70, false, null, null));
        menu.add(new Postres(10,"Éclairs", 100, false, null, null));
        menu.add(new Postres(11,"Macarons", 80, false, null, null));
        menu.add(new Postres(12,"Mouse de chocolate", 110, false, null, null));

        menu.add(new Bebidas(13,"Vino", 60, true));
        menu.add(new Bebidas(14,"Cafe", 40, false));
        menu.add(new Bebidas(15,"Agua", 20, false));
    }

    public void mostrarMenu() {
        System.out.println("---------MENU---------");
        System.out.println("ENTRADAS");
        for (Platillos platillo : menu) {
            if (platillo instanceof Entrada) {
                platillo.mostrarInformacion();
                System.out.println();
            }
        }
        System.out.println("----------------------");
        System.out.println("PLATOS FUERTES");
        for (Platillos platillo : menu) {
            if (platillo instanceof PlatoFuerte) {
                platillo.mostrarInformacion();
                System.out.println();
            }
        }
        System.out.println("----------------------");
        System.out.println("POSTRES");
        for (Platillos platillo : menu) {
            if (platillo instanceof Postres) {
                platillo.mostrarInformacion();
                System.out.println();
            }
        }
        System.out.println("----------------------");
        System.out.println("BEBIDAS");
        for (Platillos platillo : menu) {
            if (platillo instanceof Bebidas) {
                platillo.mostrarInformacion();
                System.out.println();
            }
        }
        System.out.println("----------------------");

    }
}
