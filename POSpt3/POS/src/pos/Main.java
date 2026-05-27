
package pos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Orden orden1 = new Orden();
        orden1.mostrarMenu();
        System.out.println("Ingrese el valor del producto: ");
        int num = Integer.parseInt(br.readLine());
        


        orden1.menu.get(num-1).mostrarInformacion();



    }

}
