package pos;

import javax.swing.*;
import java.awt.*;

public class VentanaEntradas implements java.awt.event.ActionListener {
    private JFrame jfrm;
    private JLabel entradaIzq, aderezoIzq, tamanoIzq;
    private JLabel aderezoDer, tamanoDer;
    private JLabel[] entradas;
    private Orden orden = new Orden();
    private JCheckBox[] aderezo;
    private ButtonGroup[] tamanoGroup;
    private JRadioButton[] tamanoChico, tamanoMediano, tamanoGrande;
    private JTextField[] cantidadComida;
    private boolean hayPlatosFuertes, hayComplementos;
    private JButton siguiente, atras;

    public VentanaEntradas(JTextField[] cantidadComida, boolean hayPlatosFuertes, boolean hayComplementos) {
        this.cantidadComida = cantidadComida;
        this.hayPlatosFuertes = hayPlatosFuertes;
        this.hayComplementos = hayComplementos;

        jfrm = new JFrame("Restaurante POS - Entradas");
        jfrm.setSize(925, 525);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLocationRelativeTo(null);
        jfrm.setResizable(false);
        jfrm.setLayout(null);
        jfrm.setVisible(true);

        JLabel subtitulo = new JLabel("Selecciona tus especificaciones para las entradas");
        subtitulo.setBounds(20, 15, 500, 22);
        subtitulo.setFont(new Font("Dialog", Font.ITALIC, 12));
        subtitulo.setForeground(Color.GRAY);
        jfrm.add(subtitulo);

        entradaIzq = new JLabel("ENTRADAS");
        entradaIzq.setBounds(30, 50, 130, 20);
        entradaIzq.setFont(new Font("Dialog", Font.BOLD, 13));
        jfrm.add(entradaIzq);

        aderezoIzq = new JLabel("¿Aderezo?");
        aderezoIzq.setBounds(252, 50, 90, 20);
        aderezoIzq.setFont(new Font("Dialog", Font.PLAIN, 12));
        jfrm.add(aderezoIzq);

        tamanoIzq = new JLabel("C   M   G");
        tamanoIzq.setBounds(338, 50, 80, 20);
        tamanoIzq.setFont(new Font("Dialog", Font.PLAIN, 11));
        jfrm.add(tamanoIzq);

        int cant0 = Integer.parseInt(cantidadComida[0].getText());
        int cant1 = Integer.parseInt(cantidadComida[1].getText());
        int cant2 = Integer.parseInt(cantidadComida[2].getText());
        int cant3 = Integer.parseInt(cantidadComida[3].getText());
        int totalEntradas = cant0 + cant1 + cant2 + cant3;

        entradas = new JLabel[totalEntradas];
        aderezo = new JCheckBox[totalEntradas];
        tamanoChico = new JRadioButton[totalEntradas];
        tamanoMediano = new JRadioButton[totalEntradas];
        tamanoGrande = new JRadioButton[totalEntradas];
        tamanoGroup = new ButtonGroup[totalEntradas];

        int labelIndex = 0;
        int distX = 30, distY = 80;

        for (int j = 0; j < 4; j++) {
            int cantidad = Integer.parseInt(cantidadComida[j].getText());
            for (int i = 0; i < cantidad; i++) {
                entradas[labelIndex] = new JLabel(orden.menu.get(j).getNombre() + " #" + (i + 1));
                entradas[labelIndex].setBounds(distX, distY + (labelIndex * 28), 230, 20);
                entradas[labelIndex].setFont(new Font("Dialog", Font.PLAIN, 12));
                jfrm.add(entradas[labelIndex]);

                aderezo[labelIndex] = new JCheckBox();
                aderezo[labelIndex].setBounds(distX + 258, distY + (labelIndex * 28), 20, 20);
                jfrm.add(aderezo[labelIndex]);

                tamanoChico[labelIndex] = new JRadioButton();
                tamanoChico[labelIndex].setBounds(distX + 302, distY + (labelIndex * 28), 20, 20);
                jfrm.add(tamanoChico[labelIndex]);

                tamanoMediano[labelIndex] = new JRadioButton();
                tamanoMediano[labelIndex].setBounds(distX + 326, distY + (labelIndex * 28), 20, 20);
                jfrm.add(tamanoMediano[labelIndex]);

                tamanoGrande[labelIndex] = new JRadioButton();
                tamanoGrande[labelIndex].setBounds(distX + 350, distY + (labelIndex * 28), 20, 20);
                jfrm.add(tamanoGrande[labelIndex]);

                tamanoGroup[labelIndex] = new ButtonGroup();
                tamanoGroup[labelIndex].add(tamanoChico[labelIndex]);
                tamanoGroup[labelIndex].add(tamanoMediano[labelIndex]);
                tamanoGroup[labelIndex].add(tamanoGrande[labelIndex]);
                tamanoMediano[labelIndex].setSelected(true);

                labelIndex++;
                if (labelIndex == 10) {
                    distX = 470; distY = 80;
                    aderezoDer = new JLabel("¿Aderezo?");
                    aderezoDer.setBounds(692, 50, 90, 20);
                    aderezoDer.setFont(new Font("Dialog", Font.PLAIN, 12));
                    jfrm.add(aderezoDer);
                    tamanoDer = new JLabel("C   M   G");
                    tamanoDer.setBounds(778, 50, 80, 20);
                    tamanoDer.setFont(new Font("Dialog", Font.PLAIN, 11));
                    jfrm.add(tamanoDer);
                    labelIndex = 0; distY = 80;
                }
            }
        }

        siguiente = new JButton("SIGUIENTE ");
        siguiente.setFont(new Font("Dialog", Font.BOLD, 13));
        siguiente.setBounds(720, 440, 150, 32);
        siguiente.addActionListener(this);
        jfrm.add(siguiente);

        atras = new JButton(" ATRÁS");
        atras.setFont(new Font("Dialog", Font.BOLD, 13));
        atras.setBounds(560, 440, 148, 32);
        atras.addActionListener(this);
        jfrm.add(atras);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == atras) {
            jfrm.setVisible(false);
            new VentanaPrincipal();
        } else if (e.getSource() == siguiente) {
            if (hayPlatosFuertes) {
                jfrm.setVisible(false);
                new VentanaPlatoFuerte(cantidadComida, hayComplementos);
            } else {
                jfrm.setVisible(false);
                new VentanaTarifa(cantidadComida);
            }
        }
    }
}
