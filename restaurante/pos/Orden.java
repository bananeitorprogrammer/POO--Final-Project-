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
        menu.add(new Entrada(450, "Ensalada Niçoise", 180, false, null));
        menu.add(new Entrada(350, "Sopa de cebolla", 120, false, null));
        menu.add(new Entrada(300, "Caracoles cocinados", 250, false, null));
        menu.add(new Entrada(800, "Tabla de quesos y embutidos", 220, false, null));

        menu.add(new PlatoFuerte(750, "Carne con papas", 290, 0, false));
        menu.add(new PlatoFuerte(400, "Mejillones", 240, 0, false));
        menu.add(new PlatoFuerte(250, "Ratatouille", 350, 0, false));
        menu.add(new PlatoFuerte(550, "Pollo estofado en vino tinto", 350, 0, false));

        menu.add(new Postres(400, "Crème Brûlée", 70, false, null, null));
        menu.add(new Postres(300, "Éclairs", 100, false, null, null));
        menu.add(new Postres(120, "Macarons", 80, false, null, null));
        menu.add(new Postres(320, "Mouse de chocolate", 110, false, null, null));

        menu.add(new Bebidas(120, "Vino", 60, true));
        menu.add(new Bebidas(50, "Cafe", 40, false));
        menu.add(new Bebidas(0, "Agua", 20, false));
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
