package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class TelaInicialVendedor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicialVendedor window = new TelaInicialVendedor();
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
	public TelaInicialVendedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Menu Gerente");
		frame.setBounds(100, 100, 450, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(0, 0, 434, 20);
		frame.getContentPane().add(textPane);
		
		JTextPane txtpnLojaDeArtigos = new JTextPane();
		txtpnLojaDeArtigos.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnLojaDeArtigos.setText("Loja de artigos esportivos");
		txtpnLojaDeArtigos.setBounds(88, 61, 336, 31);
		frame.getContentPane().add(txtpnLojaDeArtigos);
		
		JButton bntTitulo = new JButton("Realizar Troca");
		bntTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bntTitulo.setBounds(108, 212, 211, 23);
		frame.getContentPane().add(bntTitulo);
		
		JButton btnNewButton = new JButton("Realizar Venda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(108, 138, 211, 23);
		frame.getContentPane().add(btnNewButton);
		
	
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	

}
