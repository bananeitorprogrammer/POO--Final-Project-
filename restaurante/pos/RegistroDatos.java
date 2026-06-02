package pos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RegistroDatos {
    private static final String ARCHIVO = "Historial.dat";

    public static void guardarOrden(OrdenRegistro orden) {
        List<OrdenRegistro> historial = cargarHistorial();
        historial.add(orden);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(historial);
        } catch (IOException e) {
            System.err.println("Error al guardar historial: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<OrdenRegistro> cargarHistorial() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<OrdenRegistro>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
