package proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

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
		
		JLabel lblNewLabel = new JLabel("Capacidad jarra 1");
		lblNewLabel.setBounds(12, 12, 111, 16);
		frmEd.getContentPane().add(lblNewLabel);
		
		JLabel lblCapacidadJarra = new JLabel("Capacidad jarra 2");
		lblCapacidadJarra.setBounds(186, 12, 111, 16);
		frmEd.getContentPane().add(lblCapacidadJarra);
		
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
		textArea.setBounds(12, 140, 445, 344);
		frmEd.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setBounds(359, 40, 98, 20);
		frmEd.getContentPane().add(btnNewButton);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(12, 112, 111, 16);
		frmEd.getContentPane().add(lblResultado);
	}
}
