package pos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrdenRegistro implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fecha;
    private List<String> items;
    private int total;

    public OrdenRegistro(List<String> items, int total) {
        this.fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.items = items;
        this.total = total;
    }

    public String getFecha() {
         return fecha; 
        }

    public List<String> getItems() {
         return items; 
        }

    public int getTotal() {
         return total;
         }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("================================\n");
        sb.append("  Orden: ").append(fecha).append("\n");
        sb.append("───────────────────────────────\n");
        for (String item : items) {
            sb.append("  - ").append(item).append("\n");
        }
        sb.append("───────────────────────────────\n");
        sb.append("  Total: $").append(total).append("\n");
        return sb.toString();
    }
}
