package proyecto;

import proyecto.v3.BinaryTree;
import proyecto.v3.Tree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {

    /**
     *  Nos tocó la solución del famoso "problema de las jarras" usando arboles n-arios y pasándolos a binarios.
     */


    private JFrame frame;
    private JTextField jarra1;
    private JTextField jarra2;
    private JTextField objetivo;
    private String ret = "";

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
        res.setBounds(12, 140, 461, 600);
        frame.getContentPane().add(res);

        JButton calcularBtn = new JButton("Calcular");
        calcularBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jarra1.getText().isEmpty() && !jarra2.getText().isEmpty() && !objetivo.getText().isEmpty()) {
                    if (jarra1.getText().matches("\\d+") && jarra2.getText().matches("\\d+") && objetivo.getText().matches("\\d+")) {
                            // El \d+ se usa para poder discriminar los números de las letras
                        short jar1 = Short.parseShort(jarra1.getText());
                        short jar2 = Short.parseShort(jarra2.getText());
                        short obje = Short.parseShort(objetivo.getText());
                        Tree t;

                        if (jar1 >= jar2) {

                            t = new Tree(obje, jar1, jar2);

                        } else {

                            t = new Tree(obje, jar2, jar1);

                        }

                        BinaryTree bt = new BinaryTree(t);

                        getAns(bt);

                        res.setText(ret);

                        ret = "";

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

    private void getAns(BinaryTree bt) {
        int bestN = 2147483647;
        BinaryTree.BinaryNode bestAns = null;
        ArrayList<BinaryTree.BinaryNode> ans = new ArrayList<BinaryTree.BinaryNode>(); //ArrayList de respuestas
        getAns(bt.getRoot(), ans);  //El método que se invoca, es para poder obtener las respuestas que están dentro del árbol.
        if (ans.isEmpty()) { //Verifica si hay respuestas.
            JOptionPane.showMessageDialog(frame, "Los valores ingresados no otorgan una respuesta.", "", JOptionPane.ERROR_MESSAGE);
        } else {
            for (BinaryTree.BinaryNode bn : ans) { //Separa la respuesta que tenga menos pasos (la mejor)
                if (bn.getN() < bestN) {
                    bestN = bn.getN();
                    bestAns = bn;
                }
            }
            llenarOp(bestAns, bestAns.getN()); //Se llena el String ¨ret¨con los pasos para poder llegar a la mejor respuesta
            ret = ret + "\n" + bestAns.getState();
        }
    }

    private void getAns(BinaryTree.BinaryNode bn, ArrayList ar) {
        if (bn != null && bn.isAnswer()) { //Se recorre el árbol en su totalidad buscando la respuesta
            ar.add(bn);
        }
        if (bn != null) {
            getAns(bn.getRight(), ar);
            getAns(bn.getLeft(), ar);
        }
    }

    private void llenarOp(BinaryTree.BinaryNode node, int bestN) {
        if (node.getParent() == null) { //Condición de parada.
            return;
        }
        BinaryTree.BinaryNode next = node; // Se declara el un nodo temporal
        boolean trueParent = false;
        int cont = 0;
        while (!trueParent && cont < 10) { // Sale del ciclo hasta que se esté seguro que el nodo que sigue es el verdadero padre (en el árbol n-ario)
            next = next.getParent();
            try {
                if (next.getN() > next.getParent().getN()) { //Se compara el número de pasos del padre del nodo para ver si este disminuye
                    trueParent = true;
                    ret = next.getParent().getState() + "\n" + ret;
                }
            } catch (Exception e) { //En el caso de llegar a la raíz sale un NullPointer, esto evita que el código pare.
                trueParent = true;
            }

            cont++;
        }
        llenarOp(next, bestN); // Se repite hasta llegar a la raíz del árbol.

    }

}
