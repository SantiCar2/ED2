package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JFrame frame;
    private JTextField jarra1;
    private JTextField jarra2;
    private JTextField objetivo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI window = new GUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public GUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("ED2");
        frame.setBounds(100, 100, 502, 535);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel jarra_1_lbl = new JLabel("Capacidad jarra 1");
        jarra_1_lbl.setBounds(12, 12, 111, 16);
        frame.getContentPane().add(jarra_1_lbl);

        JLabel jarra_2_lbl = new JLabel("Capacidad jarra 2");
        jarra_2_lbl.setBounds(133, 12, 111, 16);
        frame.getContentPane().add(jarra_2_lbl);

        jarra1 = new JTextField();
        jarra1.setBounds(12, 40, 111, 20);
        frame.getContentPane().add(jarra1);
        jarra1.setColumns(10);

        jarra2 = new JTextField();
        jarra2.setColumns(10);
        jarra2.setBounds(133, 39, 111, 20);
        frame.getContentPane().add(jarra2);

        JTextArea res = new JTextArea();
        res.setLineWrap(true);
        res.setEditable(false);
        res.setBounds(12, 140, 461, 344);
        frame.getContentPane().add(res);

        JButton calcularBtn = new JButton("Calcular");
        calcularBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jarra1.getText().isEmpty() && !jarra2.getText().isEmpty() && !objetivo.getText().isEmpty()) {
                    if (jarra1.getText().matches("//d+") && jarra2.getText().matches("//d+") && objetivo.getText().matches("//d+")) {
                        /*try {
                            Short jar1 = Short.parseShort(jarra1.getText());
                            Short jar2 = Short.parseShort(jarra2.getText());
                            Short objet = Short.parseShort(objetivo.getText());

                        } catch (NumberFormatException NEx) {
                            JOptionPane.showMessageDialog(frame, "Los valores ingresados no son validos", "ERROR", JOptionPane.ERROR_MESSAGE);
                            jarra1.setText(null);
                            jarra2.setText(null);
                            objetivo.setText(null);
                            res.setText(null);
                        }*/
                        short jar1 = Short.parseShort(jarra1.getText());
                        short jar2 = Short.parseShort(jarra2.getText());
                        short obje = Short.parseShort(objetivo.getText());
                        // TODO: Crear arbol y pasar los parametros


                    } else {
                        JOptionPane.showMessageDialog(frame, "Los valores ingresados no son N" + (char) 218 + "meros.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        jarra1.setText(null);
                        jarra2.setText(null);
                        objetivo.setText(null);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Todos los campos deben estar llenos.", "WARNING", JOptionPane.WARNING_MESSAGE);
                    jarra1.setText(null);
                    jarra2.setText(null);
                    objetivo.setText(null);
                }

            }
        });
        calcularBtn.setBounds(375, 40, 98, 20);
        frame.getContentPane().add(calcularBtn);

        JLabel resultado_lbl = new JLabel("Resultado");
        resultado_lbl.setBounds(12, 112, 111, 16);
        frame.getContentPane().add(resultado_lbl);

        objetivo = new JTextField();
        objetivo.setColumns(10);
        objetivo.setBounds(254, 39, 111, 20);
        frame.getContentPane().add(objetivo);

        JLabel objetivo_lbl = new JLabel("Objetivo");
        objetivo_lbl.setBounds(254, 12, 111, 16);
        frame.getContentPane().add(objetivo_lbl);
    }
}
