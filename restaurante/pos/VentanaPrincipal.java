package pos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import pos.Empleados.*;
import pos.Platillos.*;

public class VentanaPrincipal implements java.awt.event.ActionListener {
    private JFrame jfrm;
    private JLabel entrada, platoFuerte, postre, bebida;
    private JLabel[] precios = new JLabel[15];
    private JButton[] comidas = new JButton[15];
    private JButton[] btnAgregar = new JButton[15];
    private JButton[] btnEliminar = new JButton[15];
    public JTextField[] cantidadComida = new JTextField[15];
    private JButton borrarOrden;
    private JButton siguiente;
    private JButton verHistorial;
    private Orden orden = new Orden();
    private int cantidad;
    public boolean s;

    public VentanaPrincipal() {
        prepararconfig();

        jfrm = new JFrame("Restaurante Proyecto Final - POO");
        jfrm.setSize(925, 525);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLocationRelativeTo(null);
        jfrm.setResizable(false);
        jfrm.setLayout(null);
        jfrm.setVisible(true);

        JLabel titulo = new JLabel("RESTAURANTE FRANÇAIS");
        titulo.setBounds(20, 10, 500, 30);
        titulo.setFont(new Font("Dialog", Font.BOLD, 16));
        jfrm.add(titulo);

        JLabel limiteLabel = new JLabel("Límite: 5 por platillo. Presiona el nombre para ver info.");
        limiteLabel.setBounds(20, 40, 450, 20);
        limiteLabel.setFont(new Font("Dialog", Font.ITALIC, 11));
        limiteLabel.setForeground(Color.GRAY);
        jfrm.add(limiteLabel);

        entrada = new JLabel("ENTRADAS");
        entrada.setBounds(20, 80, 100, 20);
        entrada.setFont(new Font("QuickSand", Font.BOLD, 14));
        jfrm.add(entrada);

        JSeparator sep1 = new JSeparator();
        sep1.setBounds(110, 90, 360, 4);
        jfrm.add(sep1);

        for (int i = 0; i < 4; i++) {
            comidas[i].setBounds(5, 110 + (i * 30), 200, 20);
            precios[i].setBounds(255, 110 + (i * 30), 70, 20);
            btnAgregar[i].setBounds(365, 110 + (i * 30), 42, 20);
            btnEliminar[i].setBounds(408, 110 + (i * 30), 38, 20);
            cantidadComida[i].setBounds(318, 110 + (i * 30), 40, 20);
            btnAgregar[i].addActionListener(this);
            btnEliminar[i].addActionListener(this);
            comidas[i].addActionListener(this);
            jfrm.add(comidas[i]); jfrm.add(precios[i]);
            jfrm.add(btnAgregar[i]); jfrm.add(btnEliminar[i]); jfrm.add(cantidadComida[i]);
        }

        platoFuerte = new JLabel("PLATOS FUERTES");
        platoFuerte.setFont(new Font("QuickSand", Font.BOLD, 14));
        platoFuerte.setBounds(20, 240, 150, 20);
        jfrm.add(platoFuerte);

        JSeparator sep2 = new JSeparator();
        sep2.setBounds(148, 250, 322, 2);
        jfrm.add(sep2);

        for (int i = 4; i < 8; i++) {
            comidas[i].setBounds(5, 270 + ((i - 4) * 30), 200, 20);
            precios[i].setBounds(255, 270 + ((i - 4) * 30), 70, 20);
            btnAgregar[i].setBounds(365, 270 + ((i - 4) * 30), 42, 20);
            btnEliminar[i].setBounds(408, 270 + ((i - 4) * 30), 38, 20);
            cantidadComida[i].setBounds(318, 270 + ((i - 4) * 30), 40, 20);
            btnAgregar[i].addActionListener(this);
            btnEliminar[i].addActionListener(this);
            comidas[i].addActionListener(this);
            jfrm.add(comidas[i]); jfrm.add(precios[i]);
            jfrm.add(btnAgregar[i]); jfrm.add(btnEliminar[i]); jfrm.add(cantidadComida[i]);
        }

        postre = new JLabel("POSTRES");
        postre.setFont(new Font("QuickSand", Font.BOLD, 14));
        postre.setBounds(480, 80, 100, 20);
        jfrm.add(postre);

        JSeparator sep3 = new JSeparator();
        sep3.setBounds(545, 90, 350, 2);
        jfrm.add(sep3);

        for (int i = 8; i < 12; i++) {
            comidas[i].setBounds(462, 110 + ((i - 8) * 30), 185, 20);
            precios[i].setBounds(672, 110 + ((i - 8) * 30), 70, 20);
            btnAgregar[i].setBounds(775, 110 + ((i - 8) * 30), 42, 20);
            btnEliminar[i].setBounds(818, 110 + ((i - 8) * 30), 38, 20);
            cantidadComida[i].setBounds(728, 110 + ((i - 8) * 30), 40, 20);
            btnAgregar[i].addActionListener(this);
            btnEliminar[i].addActionListener(this);
            comidas[i].addActionListener(this);
            jfrm.add(comidas[i]); jfrm.add(precios[i]);
            jfrm.add(btnAgregar[i]); jfrm.add(btnEliminar[i]); jfrm.add(cantidadComida[i]);
        }

        bebida = new JLabel("BEBIDAS");
        bebida.setFont(new Font("QuickSand", Font.BOLD, 14));
        bebida.setBounds(480, 240, 100, 20);
        jfrm.add(bebida);

        JSeparator sep4 = new JSeparator();
        sep4.setBounds(540, 250, 355, 2);
        jfrm.add(sep4);

        for (int i = 12; i < 15; i++) {
            comidas[i].setBounds(462, 270 + ((i - 12) * 30), 185, 20);
            precios[i].setBounds(672, 270 + ((i - 12) * 30), 70, 20);
            btnAgregar[i].setBounds(775, 270 + ((i - 12) * 30), 42, 20);
            btnEliminar[i].setBounds(818, 270 + ((i - 12) * 30), 38, 20);
            cantidadComida[i].setBounds(728, 270 + ((i - 12) * 30), 40, 20);
            btnAgregar[i].addActionListener(this);
            btnEliminar[i].addActionListener(this);
            comidas[i].addActionListener(this);
            jfrm.add(comidas[i]); jfrm.add(precios[i]);
            jfrm.add(btnAgregar[i]); jfrm.add(btnEliminar[i]); jfrm.add(cantidadComida[i]);
        }

        siguiente = new JButton("SIGUIENTE");
        siguiente.setFont(new Font("Dialog", Font.BOLD, 13));
        siguiente.setBounds(720, 430, 150, 32);
        siguiente.addActionListener(this);
        jfrm.add(siguiente);

        borrarOrden = new JButton("BORRAR ORDEN");
        borrarOrden.setFont(new Font("Dialog", Font.BOLD, 12));
        borrarOrden.setBounds(560, 430, 148, 32);
        borrarOrden.addActionListener(this);
        jfrm.add(borrarOrden);

        verHistorial = new JButton("HISTORIAL");
        verHistorial.setFont(new Font("Dialog", Font.BOLD, 12));
        verHistorial.setBounds(20, 430, 120, 32);
        verHistorial.addActionListener(this);
        jfrm.add(verHistorial);
    }

    public void prepararconfig() {
        for (int i = 0; i < comidas.length; i++) {
            comidas[i] = new JButton(orden.menu.get(i).getNombre());
            comidas[i].setHorizontalAlignment(SwingConstants.LEFT);
            comidas[i].setBorderPainted(false);
            comidas[i].setContentAreaFilled(false);
            comidas[i].setFocusPainted(false);
            comidas[i].setFont(new Font("Dialog", Font.PLAIN, 12));
            precios[i] = new JLabel("$" + orden.menu.get(i).getPrecio());
            precios[i].setFont(new Font("Dialog", Font.PLAIN, 12));
            btnAgregar[i] = new JButton("+");
            btnEliminar[i] = new JButton("-");
            cantidadComida[i] = new JTextField("0");
            cantidadComida[i].setEditable(false);
            cantidadComida[i].setFont(new Font("Dialog", Font.PLAIN, 12));
            cantidadComida[i].setBackground(Color.WHITE);
            cantidadComida[i].setHorizontalAlignment(SwingConstants.CENTER);
        }
    }

    private void mostrarInfoPlatillo(int index) {
        Platillos p = orden.menu.get(index);
        String tipo = (index < 4) ? "Entrada" : (index < 8) ? "Plato Fuerte" : (index < 12) ? "Postre" : "Bebida";
        JOptionPane.showMessageDialog(jfrm,
                "Nombre: " + p.getNombre() + "\nPrecio: $" + p.getPrecio() + "\nTipo: " + tipo + "\nCalorías: " + p.getCalorias() + " kcal" ,
                "Información del platillo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarHistorial() {
        List<OrdenRegistro> historial = RegistroDatos.cargarHistorial();
        if (historial.isEmpty()) {
            JOptionPane.showMessageDialog(jfrm, "No hay órdenes registradas aún.", "Historial", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (OrdenRegistro reg : historial) sb.append(reg.toString()).append("\n");
        JTextArea area = new JTextArea(sb.toString());
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(420, 350));
        JOptionPane.showMessageDialog(jfrm, scroll, "Historial de Órdenes", JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < comidas.length; i++) {
            if (e.getSource() == comidas[i]) { mostrarInfoPlatillo(i); return; }
            if (e.getSource() == btnAgregar[i]) {
                if (Integer.parseInt(cantidadComida[i].getText()) < 5) {
                    cantidad = Integer.parseInt(cantidadComida[i].getText()) + 1;
                    cantidadComida[i].setText(String.valueOf(cantidad));
                }
                return;
            }
            if (e.getSource() == btnEliminar[i]) {
                cantidad = Integer.parseInt(cantidadComida[i].getText());
                if (cantidad > 0) { cantidadComida[i].setText(String.valueOf(cantidad - 1)); }
                return;
            }
        }

        if (e.getSource() == borrarOrden) {
            for (JTextField tf : cantidadComida) tf.setText("0");
        } else if (e.getSource() == verHistorial) {
            mostrarHistorial();
        } else if (e.getSource() == siguiente) {
            boolean hayEntradas = false, hayPlatosFuertes = false, hayComplementos = false;
            for (int i = 0; i < 4; i++) if (!cantidadComida[i].getText().equals("0")) { hayEntradas = true; break; }
            for (int i = 4; i < 8; i++) if (!cantidadComida[i].getText().equals("0")) { hayPlatosFuertes = true; break; }
            for (int i = 8; i < cantidadComida.length; i++) if (!cantidadComida[i].getText().equals("0")) { hayComplementos = true; break; }

            if (!hayEntradas && !hayPlatosFuertes && !hayComplementos) {
                JOptionPane.showMessageDialog(jfrm, "Por favor, seleccione al menos un platillo.", "Selección requerida", JOptionPane.WARNING_MESSAGE);
            } else if (hayEntradas) {
                jfrm.setVisible(false);
                new VentanaEntradas(cantidadComida, hayPlatosFuertes, hayComplementos);
            } else if (hayPlatosFuertes) {
                jfrm.setVisible(false);
                new VentanaPlatoFuerte(cantidadComida, hayComplementos);
            } else {
                jfrm.setVisible(false);
                new VentanaTarifa(cantidadComida);
            }
        }
    }
}
