package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import Controler.EstoqueControler;
import Controler.VendaControler;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class TelaInicialGerente {

	private JFrame frame;
	private JTextField campoData;

	public JTextField getCampoData() {
		return campoData;
	}

	VendaControler vc = new VendaControler();
	EstoqueControler e = new EstoqueControler();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicialGerente window = new TelaInicialGerente();
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
	public TelaInicialGerente() {
		vc.setTelaGerente(this);
		
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
		
		JButton bntTitulo = new JButton("Gerir Produtos");
		bntTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		bntTitulo.setBounds(134, 212, 150, 23);
		frame.getContentPane().add(bntTitulo);
		
		JLabel lblNewLabel = new JLabel("Relat\u00F3rio de vendas do dia:");
		lblNewLabel.setBounds(88, 153, 144, 14);
		frame.getContentPane().add(lblNewLabel);
		
		campoData = new JTextField();
		campoData.setText("15/12/2020");
		campoData.setBounds(253, 150, 86, 20);
		frame.getContentPane().add(campoData);
		campoData.setColumns(10);
		
		JButton btnNewButton = new JButton("Emitir Relat\u00F3rio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vc.relatorioData();
				
			}
		});
		btnNewButton.setBounds(134, 178, 150, 23);
		frame.getContentPane().add(btnNewButton);
		
	
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
