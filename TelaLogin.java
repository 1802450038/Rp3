package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;

import Controler.LoginControler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin {

	/**
	 * Interface grafica para Login no sistema
	 */
	private JFrame frame;
	private JTextField txtTextologin;
	private JPasswordField textoSenha;
	private LoginControler loginControler;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
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
	public TelaLogin() {
		loginControler = new LoginControler();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel login = new JLabel("Login");
		login.setBounds(120, 84, 46, 14);
		frame.getContentPane().add(login);
		
		txtTextologin = new JTextField();
		txtTextologin.setBounds(120, 109, 206, 20);
		frame.getContentPane().add(txtTextologin);
		txtTextologin.setColumns(10);
		
		JLabel senha = new JLabel("Senha");
		senha.setBounds(120, 152, 46, 14);
		frame.getContentPane().add(senha);
		
		textoSenha = new JPasswordField();
		textoSenha.setBounds(120, 177, 206, 20);
		frame.getContentPane().add(textoSenha);
		
		JButton botaoEntrar = new JButton("Entrar");
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sLogin = login.getText();
				String sSenha = senha.getText();
				boolean logou = loginControler.logar(sLogin,sSenha );
				
			}

			
		});
		botaoEntrar.setBounds(174, 270, 89, 23);
		frame.getContentPane().add(botaoEntrar);
		
		JTextPane txtpnLojaDeArtigos = new JTextPane();
		txtpnLojaDeArtigos.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnLojaDeArtigos.setText("Loja de artigos esportivos");
		txtpnLojaDeArtigos.setBounds(78, 24, 336, 31);
		frame.getContentPane().add(txtpnLojaDeArtigos);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtTextologin() {
		return txtTextologin;
	}

	public void setTxtTextologin(JTextField txtTextologin) {
		this.txtTextologin = txtTextologin;
	}

	public JPasswordField getTextoSenha() {
		return textoSenha;
	}

	public void setTextoSenha(JPasswordField textoSenha) {
		this.textoSenha = textoSenha;
	}
}
