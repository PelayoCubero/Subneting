import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana extends JFrame {

    Ventana(Subred s) {

        setLocationRelativeTo(null);

        setSize(800, 200);

        String[] titulo = { "Mascara", "Direccion de red", "Primera red", "Ultima red", "Broadcast" };
        Object[][] redes = new Object[s.getSubredes().length][titulo.length];

        for (int i = 0; i < redes.length; i++) {

            redes[i][0] = s.getSubredes()[i].getRed().getMascaraComoDireccion();
            redes[i][1] = s.getSubredes()[i].getRed().getDireccion();
            redes[i][2] = s.getSubredes()[i].getPrimero().getDireccion();
            redes[i][3] = s.getSubredes()[i].getUltimo().getDireccion();
            redes[i][4] = s.getSubredes()[i].getBroadcast().getDireccion();

        }

        JTable direcciones = new JTable(redes, titulo);

        add(direcciones);

        setVisible(true);

    }

    Ventana() {

        crear();

    }

    private void crear() {

        setTitle("Subneting");

        setSize(450, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(3, 3, 10, 50));

        JLabel dir = new JLabel("Direccion");
        JLabel mas = new JLabel("Mascara");
        JLabel cant = new JLabel("numero de direcciones");

        JTextField obtenerDir = new JTextField();
        JTextField obtenerMas = new JTextField();
        JTextField obtenerCant = new JTextField();

        obtenerDir.setSize(100, 25);

        JButton crear = new JButton("Crear");

        panel.add(dir);
        panel.add(mas);
        panel.add(cant);
        panel.add(obtenerDir);
        panel.add(obtenerMas);
        panel.add(obtenerCant);
        panel.add(crear);

        add(panel);

        ActionListener bCrear = new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {

                    new Ventana(new Subred(
                            new IP(obtenerDir.getText().toString(), Integer.parseInt(obtenerMas.getText().toString())),
                            Integer.parseInt(obtenerCant.getText().toString())));

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null, "Error");

                }

            }
        };
        crear.addActionListener(bCrear);

        setVisible(true);

    }

}