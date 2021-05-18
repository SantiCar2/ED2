package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

	private JFrame frmEd;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmEd.setVisible(true);
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
		frmEd = new JFrame();
		frmEd.setTitle("ED2");
		frmEd.setBounds(100, 100, 485, 535);
		frmEd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEd.getContentPane().setLayout(null);
		
		JLabel jarra_1_lbl = new JLabel("Capacidad jarra 1");
		jarra_1_lbl.setBounds(12, 12, 111, 16);
		frmEd.getContentPane().add(jarra_1_lbl);
		
		JLabel jarra_2_lbl = new JLabel("Capacidad jarra 2");
		jarra_2_lbl.setBounds(186, 12, 111, 16);
		frmEd.getContentPane().add(jarra_2_lbl);
		
		textField = new JTextField();
		textField.setBounds(12, 40, 111, 20);
		frmEd.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(186, 40, 111, 20);
		frmEd.getContentPane().add(textField_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(12, 140, 445, 344);
		frmEd.getContentPane().add(textArea);
		
		JButton calcularBtn = new JButton("Calcular");
		calcularBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Hola");
			}
		});
		calcularBtn.setBounds(359, 40, 98, 20);
		frmEd.getContentPane().add(calcularBtn);
		
		JLabel resultado_lbl = new JLabel("Resultado");
		resultado_lbl.setBounds(12, 112, 111, 16);
		frmEd.getContentPane().add(resultado_lbl);
	}
}
