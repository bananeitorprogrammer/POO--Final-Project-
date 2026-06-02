package pos;

import javax.swing.*;
import java.awt.*;

public class VentanaPlatoFuerte implements java.awt.event.ActionListener {
    private JFrame jfrm;
    private JLabel tituloIzq, guarnicionesIzq, guarnicionesDer, tamanoIzq, tamanoDer;
    private JLabel[] platosLabel;
    private Orden orden = new Orden();
    private JComboBox<String>[] guarniciones;
    private ButtonGroup[] tamanoGroup;
    private JRadioButton[] tamanoChico, tamanoMediano, tamanoGrande;
    private JTextField[] cantidadComida;
    private boolean hayComplementos;
    private JButton siguiente, atras;

    @SuppressWarnings("unchecked")
    public VentanaPlatoFuerte(JTextField[] cantidadComida, boolean hayComplementos) {
        this.cantidadComida = cantidadComida;
        this.hayComplementos = hayComplementos;

        jfrm = new JFrame("Restaurante POS - Platos Fuertes");
        jfrm.setSize(925, 525);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLocationRelativeTo(null);
        jfrm.setResizable(false);
        jfrm.setLayout(null);

        JLabel subtitulo = new JLabel("Selecciona tus especificaciones para los platos fuertes");
        subtitulo.setBounds(20, 15, 520, 22);
        subtitulo.setFont(new Font("Dialog", Font.ITALIC, 12));
        subtitulo.setForeground(Color.GRAY);
        jfrm.add(subtitulo);

        tituloIzq = new JLabel("PLATOS FUERTES");
        tituloIzq.setBounds(30, 50, 150, 20);
        tituloIzq.setFont(new Font("Dialog", Font.BOLD, 13));
        jfrm.add(tituloIzq);

        guarnicionesIzq = new JLabel("Guarnición");
        guarnicionesIzq.setBounds(250, 50, 100, 20);
        guarnicionesIzq.setFont(new Font("Dialog", Font.PLAIN, 12));
        jfrm.add(guarnicionesIzq);

        tamanoIzq = new JLabel("C   M   G");
        tamanoIzq.setBounds(368, 50, 80, 20);
        tamanoIzq.setFont(new Font("Dialog", Font.PLAIN, 11));
        jfrm.add(tamanoIzq);

        int cant4 = Integer.parseInt(cantidadComida[4].getText());
        int cant5 = Integer.parseInt(cantidadComida[5].getText());
        int cant6 = Integer.parseInt(cantidadComida[6].getText());
        int cant7 = Integer.parseInt(cantidadComida[7].getText());
        int totalPlatos = cant4 + cant5 + cant6 + cant7;

        platosLabel = new JLabel[totalPlatos];
        guarniciones = new JComboBox[totalPlatos];
        tamanoChico = new JRadioButton[totalPlatos];
        tamanoMediano = new JRadioButton[totalPlatos];
        tamanoGrande = new JRadioButton[totalPlatos];
        tamanoGroup = new ButtonGroup[totalPlatos];

        int labelIndex = 0;
        int distX = 30, distY = 80;

        for (int j = 4; j < 8; j++) {
            int cantidad = Integer.parseInt(cantidadComida[j].getText());
            for (int i = 0; i < cantidad; i++) {
                platosLabel[labelIndex] = new JLabel(orden.menu.get(j).getNombre() + " #" + (i + 1));
                platosLabel[labelIndex].setBounds(distX, distY + (labelIndex * 28), 220, 20);
                platosLabel[labelIndex].setFont(new Font("Dialog", Font.PLAIN, 12));
                jfrm.add(platosLabel[labelIndex]);

                guarniciones[labelIndex] = new JComboBox<>(new String[]{"Sin guarnición", "Papas fritas", "Arroz", "Puré"});
                guarniciones[labelIndex].setBounds(distX + 210, distY + (labelIndex * 28), 115, 22);
                jfrm.add(guarniciones[labelIndex]);

                tamanoChico[labelIndex] = new JRadioButton();
                tamanoChico[labelIndex].setBounds(distX + 332, distY + (labelIndex * 28), 20, 20);
                jfrm.add(tamanoChico[labelIndex]);

                tamanoMediano[labelIndex] = new JRadioButton();
                tamanoMediano[labelIndex].setBounds(distX + 356, distY + (labelIndex * 28), 20, 20);
                jfrm.add(tamanoMediano[labelIndex]);

                tamanoGrande[labelIndex] = new JRadioButton();
                tamanoGrande[labelIndex].setBounds(distX + 380, distY + (labelIndex * 28), 20, 20);
                jfrm.add(tamanoGrande[labelIndex]);

                tamanoGroup[labelIndex] = new ButtonGroup();
                tamanoGroup[labelIndex].add(tamanoChico[labelIndex]);
                tamanoGroup[labelIndex].add(tamanoMediano[labelIndex]);
                tamanoGroup[labelIndex].add(tamanoGrande[labelIndex]);
                tamanoMediano[labelIndex].setSelected(true);

                labelIndex++;
                if (labelIndex == 10) {
                    distX = 470; distY = 80;
                    guarnicionesDer = new JLabel("Guarnición");
                    guarnicionesDer.setBounds(692, 50, 100, 20);
                    guarnicionesDer.setFont(new Font("Dialog", Font.PLAIN, 12));
                    jfrm.add(guarnicionesDer);
                    tamanoDer = new JLabel("C   M   G");
                    tamanoDer.setBounds(808, 50, 80, 20);
                    tamanoDer.setFont(new Font("Dialog", Font.PLAIN, 11));
                    jfrm.add(tamanoDer);
                    labelIndex = 0; distY = 80;
                }
            }
        }

        siguiente = new JButton("SIGUIENTE");
        siguiente.setFont(new Font("Dialog", Font.BOLD, 13));
        siguiente.setBounds(720, 440, 150, 32);
        siguiente.addActionListener(this);
        jfrm.add(siguiente);

        atras = new JButton("ATRÁS");
        atras.setFont(new Font("Dialog", Font.BOLD, 13));
        atras.setBounds(560, 440, 148, 32);
        atras.addActionListener(this);
        jfrm.add(atras);

        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == atras) {
            jfrm.setVisible(false);
            new VentanaPrincipal();
        } else if (e.getSource() == siguiente) {
            jfrm.setVisible(false);
            new VentanaTarifa(cantidadComida);
        }
    }
}
