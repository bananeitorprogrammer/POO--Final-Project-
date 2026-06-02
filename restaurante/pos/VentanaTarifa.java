package pos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import pos.Empleados.*;
import pos.Platillos.*;

public class VentanaTarifa implements java.awt.event.ActionListener {
    private JFrame jfrm;
    private JButton finalizar, atras;
    private JTextField[] cantidadComida;
    private Orden orden = new Orden();

    public VentanaTarifa(JTextField[] cantidadComida) {
        this.cantidadComida = cantidadComida;

        jfrm = new JFrame("Restaurante POS - Resumen y Tarifas");
        jfrm.setSize(925, 525);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLocationRelativeTo(null);
        jfrm.setResizable(false);
        jfrm.setLayout(null);

        JLabel tituloLabel = new JLabel("Así se vería su orden:");
        tituloLabel.setBounds(20, 15, 300, 22);
        tituloLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        jfrm.add(tituloLabel);

        List<String> itemsList = new ArrayList<>();
        int total = 0;
        StringBuilder ordenSB = new StringBuilder();
        StringBuilder preciosSB = new StringBuilder();

        String[] categorias = {"ENTRADAS", "PLATOS FUERTES", "POSTRES", "BEBIDAS"};
        int[][] rangos = {{0, 4}, {4, 8}, {8, 12}, {12, 15}};

        for (int c = 0; c < 4; c++) {
            boolean hayAlgo = false;
            StringBuilder catSB = new StringBuilder();
            for (int i = rangos[c][0]; i < rangos[c][1]; i++) {
                int cant = Integer.parseInt(cantidadComida[i].getText());
                if (cant > 0) {
                    hayAlgo = true;
                    int subtotal = cant * orden.menu.get(i).getPrecio();
                    total += subtotal;
                    String linea = "  " + orden.menu.get(i).getNombre() + " x" + cant;
                    String precio = "  $" + subtotal;
                    catSB.append(linea).append("\n");
                    preciosSB.append(precio).append("\n");
                    for (int k = 0; k < cant; k++) {
                        itemsList.add(orden.menu.get(i).getNombre() + " x1 = $" + orden.menu.get(i).getPrecio());
                    }
                }
            }
            if (hayAlgo) {
                ordenSB.append(categorias[c]).append("\n").append(catSB);
            }
        }
        ordenSB.append("\n──────────────────────\n");
        ordenSB.append("TOTAL: $").append(total);
        preciosSB.append("\n──────────────────────\n");
        preciosSB.append("TOTAL: $").append(total);

        JTextArea ordenArea = new JTextArea(ordenSB.toString());
        ordenArea.setEditable(false);
        ordenArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollOrden = new JScrollPane(ordenArea);
        scrollOrden.setBounds(20, 50, 430, 350);
        jfrm.add(scrollOrden);

        JLabel preciosLabel = new JLabel("Precios");
        preciosLabel.setBounds(480, 15, 150, 22);
        preciosLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        jfrm.add(preciosLabel);

        JTextArea preciosArea = new JTextArea(preciosSB.toString());
        preciosArea.setEditable(false);
        preciosArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollPrecios = new JScrollPane(preciosArea);
        scrollPrecios.setBounds(480, 58, 410, 340);
        jfrm.add(scrollPrecios);

        finalizar = new JButton("FINALIZAR");
        finalizar.setFont(new Font("Dialog", Font.BOLD, 13));
        finalizar.setBounds(720, 440, 150, 32);
        finalizar.addActionListener(this);
        jfrm.add(finalizar);

        atras = new JButton("ATRÁS");
        atras.setFont(new Font("Dialog", Font.BOLD, 13));
        atras.setBounds(560, 440, 148, 32);
        atras.addActionListener(this);
        jfrm.add(atras);

        this._itemsList = itemsList;
        this._total = total;

        jfrm.setVisible(true);
    }

    private List<String> _itemsList;
    private int _total;

    private void procesarOrden() {
        OrdenRegistro registro = new OrdenRegistro(_itemsList, _total);
        RegistroDatos.guardarOrden(registro);

        List<Thread> hilos = new ArrayList<>();
        for (int i = 0; i < cantidadComida.length; i++) {
            int cant = Integer.parseInt(cantidadComida[i].getText());
            for (int k = 0; k < cant; k++) {
                pos.Platillos.Platillos platillo = orden.menu.get(i);
                Empleados emp;
                if (i < 4) {
                    emp = new CocineroEntradas(i + 1, "Cocinero de Entradas", platillo);
                } else if (i < 8) {
                    emp = new CocineroPrincipal(i + 1, "Cocinero Principal", platillo);
                } else if (i < 12) {
                    emp = new Pastelero(i + 1, "Pastelero", platillo);
                } else {
                    emp = new Cantinero(i + 1, "Cantinero", platillo);
                }
                Thread hilo = new Thread(emp);
                hilos.add(hilo);
            }
        }

        JDialog progDialog = new JDialog(jfrm, "Preparando orden...", true);
        progDialog.setSize(340, 140);
        progDialog.setLocationRelativeTo(jfrm);
        progDialog.setLayout(new BorderLayout());
        progDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        JLabel progLabel = new JLabel("Los empleados están preparando su orden.", SwingConstants.CENTER);
        progLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
        JProgressBar bar = new JProgressBar();
        bar.setIndeterminate(true);
        JLabel tiempoLabel = new JLabel("Tiempo estimado: calculando...", SwingConstants.CENTER);
        tiempoLabel.setFont(new Font("Dialog", Font.ITALIC, 11));
        tiempoLabel.setForeground(Color.GRAY);

        progDialog.add(progLabel, BorderLayout.NORTH);
        progDialog.add(bar, BorderLayout.CENTER);
        progDialog.add(tiempoLabel, BorderLayout.SOUTH);

        Thread supervisor = new Thread(() -> {
            for (Thread h : hilos) h.start();
            for (Thread h : hilos) {
                try { h.join(); } catch (InterruptedException ex) { Thread.currentThread().interrupt(); }
            }
            SwingUtilities.invokeLater(() -> {
                progDialog.setVisible(false);
                jfrm.setVisible(false);
                JOptionPane.showMessageDialog(null,
                        "¡Orden completada! Total cobrado: $" + _total + "\nGracias por visitar Restaurante Français",
                        "Orden Finalizada", JOptionPane.INFORMATION_MESSAGE);
                new VentanaPrincipal();
            });
        });
        supervisor.setDaemon(true);
        supervisor.start();

        progDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == atras) {
            jfrm.setVisible(false);
            new VentanaPrincipal();
        } else if (e.getSource() == finalizar) {
            finalizar.setEnabled(false);
            procesarOrden();
        }
    }
}
