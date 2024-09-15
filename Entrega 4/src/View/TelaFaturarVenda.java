package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;

import Controler.VendaControler;
import Model.Cliente;
import Model.Status;
import Model.Venda;

import java.awt.TextField;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class TelaFaturarVenda {

	/**
	 * Interface grafica para Login no sistema
	 */
	private JFrame frame;
	Venda venda = new Venda();
	VendaControler vendaControler;
	private JTextField textFieldImposto;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFaturarVenda window = new TelaFaturarVenda(new Venda());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param v
	 */
	public TelaFaturarVenda(Venda v) {
		this.venda = v;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextPane txtpnLojaDeArtigos = new JTextPane();
		txtpnLojaDeArtigos.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnLojaDeArtigos.setText("Faturamento de venda");
		txtpnLojaDeArtigos.setBounds(102, 24, 312, 31);
		frame.getContentPane().add(txtpnLojaDeArtigos);

		JLabel lblNewLabel = new JLabel("Cliente:");
		lblNewLabel.setBounds(62, 101, 303, 14);
		lblNewLabel.setText(lblNewLabel.getText() + venda.getCliente().getNome());

		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Data:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(62, 126, 303, 14);
		lblNewLabel_1.setText(lblNewLabel_1.getText() + venda.getDataVenda());
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblId = new JLabel("ID: ");
		lblId.setBounds(62, 151, 138, 14);
		lblId.setText(lblId.getText() + venda.getId());
		frame.getContentPane().add(lblId);

		JLabel lblNewLabel_3 = new JLabel("Valor: R$");
		lblNewLabel_3.setBounds(62, 180, 138, 14);
		lblNewLabel_3.setText(lblNewLabel_3.getText() + venda.getVendaTotal());
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Status:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(62, 206, 303, 14);
		lblNewLabel_4.setText(lblNewLabel_4.getText() + venda.getStatus().nome);
		frame.getContentPane().add(lblNewLabel_4);

		Label label = new Label("Pagamento recebido:");
		label.setBounds(62, 226, 138, 22);
		label.setText(label.getText() + venda.getPagamentoRecebido());
		frame.getContentPane().add(label);

		Label label_1 = new Label("Imposto (% ):");
		label_1.setBounds(222, 176, 81, 22);
		frame.getContentPane().add(label_1);

		ButtonGroup group = new ButtonGroup();

		JRadioButton btDinheiro = new JRadioButton("Dinheiro");
		btDinheiro.setBounds(215, 225, 138, 23);
		frame.getContentPane().add(btDinheiro);

		JRadioButton btCartaoCredito = new JRadioButton("Cart\u00E3o de credito");
		btCartaoCredito.setBounds(215, 251, 138, 23);
		frame.getContentPane().add(btCartaoCredito);

		JRadioButton btCartaoDebito = new JRadioButton("Cart\u00E3o de d\u00E9bito");
		btCartaoDebito.setBounds(215, 277, 138, 23);
		frame.getContentPane().add(btCartaoDebito);

		group.add(btDinheiro);
		group.add(btCartaoCredito);
		group.add(btCartaoDebito);

		switch (venda.getPagamentoRecebido()) {
		case "Cartao de Credito":
			btCartaoCredito.setSelected(true);
			break;
		case "Cartão de Debito": {
			btCartaoDebito.setSelected(true);
			break;
		}
		case "Dinheiro": {
			btDinheiro.setSelected(true);
			break;
		}
		default:

		}

		
		JButton btnNewButton = new JButton("Registrar Pagamento");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("BOTAO "+ e.getID());
				if (btCartaoCredito.isSelected()) {
					venda.setPagamentoRecebido("Cartao de Credito");
				} else if (btCartaoDebito.isSelected()) {
					venda.setPagamentoRecebido("Cartão de Debito");

				} else if (btDinheiro.isSelected()) {
					venda.setPagamentoRecebido("Dinheiro");

				} else {
					int option = JOptionPane.showConfirmDialog(null, "Você precisa informar o pagamento. ", 
							"Aviso", JOptionPane.OK_OPTION);
					return;
				}
				// arnazenar e atualiza status
				if (vendaControler == null) {
					vendaControler = new VendaControler();
					//vendaControler.setTelaFaturarVenda(super().this));
					venda.setStatus(Status.PAGA);
					
					String sImposto = textFieldImposto.getText();
					Double dImposto = Double.parseDouble(sImposto);
					venda.setImposto(dImposto);
					vendaControler.faturarVenda(venda);				
				}
			}

		});
		btnNewButton.setBounds(59, 399, 179, 22);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Entregar Produtos");
		btnNewButton_1.setBounds(248, 399, 139, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 
				
				
				
			}
		});
		cancelar.setBounds(80, 432, 285, 23);
		frame.getContentPane().add(cancelar);
		textFieldImposto = new JTextField();
		textFieldImposto.setBounds(309, 177, 56, 20);
		frame.getContentPane().add(textFieldImposto);
		textFieldImposto.setText(venda.getImposto()+"");
		textFieldImposto.setColumns(10);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public VendaControler getVendaControler() {
		return vendaControler;
	}

	public void setVendaControler(VendaControler vendaControler) {
		this.vendaControler = vendaControler;
	}
	
	public void fechar() {
		//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		frame.setVisible(false); //you can't see me!
		frame.dispose(); //Destroy the JFrame object
	}
	
	public void exibir() {
		frame.setVisible(true);
	}
	
		
}
