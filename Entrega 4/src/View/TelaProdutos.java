package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import Model.Produto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Panel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaProdutos {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtQuantidade;
	private JTextField txtPreco;
	private JTable table_1;
	private DefaultTableModel dm;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProdutos window = new TelaProdutos();
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
	public TelaProdutos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Menu Gerente");
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_formulario = new JPanel();
		panel_formulario.setBounds(653, 0, 231, 444);
		frame.getContentPane().add(panel_formulario);
		panel_formulario.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(23, 96, 46, 14);
		panel_formulario.add(lblNome);
		
		JLabel lblDescicao = new JLabel("Descri\u00E7\u00E3o");
		lblDescicao.setBounds(23, 135, 61, 14);
		panel_formulario.add(lblDescicao);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade");
		lblNewLabel_2.setBounds(23, 174, 74, 14);
		panel_formulario.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Pre\u00E7o");
		lblNewLabel_3.setBounds(23, 208, 46, 14);
		panel_formulario.add(lblNewLabel_3);
		
		txtNome = new JTextField();
		txtNome.setBounds(94, 93, 109, 20);
		panel_formulario.add(txtNome);
		txtNome.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(94, 132, 109, 20);
		panel_formulario.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(94, 171, 109, 20);
		panel_formulario.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(94, 205, 109, 20);
		panel_formulario.add(txtPreco);
		txtPreco.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar novo");
		btnAdicionar.setBounds(23, 307, 164, 23);
		panel_formulario.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover existente");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemover.setBounds(23, 375, 164, 23);
		panel_formulario.add(btnRemover);
		
		JButton btnAtualizar = new JButton("Atualizar existente");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizar.setBounds(23, 341, 164, 23);
		panel_formulario.add(btnAtualizar);
		
		JLabel lblNewLabel = new JLabel("Dados do produto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 11, 231, 29);
		panel_formulario.add(lblNewLabel);
		
		
		
		
		Panel panel_produtos = new Panel();
		panel_produtos.setBounds(0, 0, 10, 10);
		
		
		
		 String[] colunas = new String[] {
		            "Id", "Nome", "Descrição", "Quantidade", "Valor"
		        };
		 Object[][] produtos = new Object[][] {
			 {1, "tenis", "para corrida", 1,  new Double(40.0)}
			 
			 
		 };
		 
		 final Class[] columnClass = new Class[] {
		            Integer.class, String.class,String.class, Integer.class, Double.class
		        };
		   
		 DefaultTableModel model = new DefaultTableModel(produtos, colunas) {
	            @Override
	            public boolean isCellEditable(int row, int column)
	            {
	                return false;
	            }
	            @Override
	            public Class<?> getColumnClass(int columnIndex)
	            {
	                return columnClass[columnIndex];
	            }
	        };
		frame.getContentPane().add(panel_produtos);
		JTable table_1_1 = new JTable(new DefaultTableModel(
			new Object[][] {
				{new Integer(1), "tenis", "para corrida", new Integer(1), new Double(40.0)},
			},
			new String[] {
				"Id", "Nome", "Descri\u00E7\u00E3o", "Quantidade", "Valor"
			}
		));
		table_1_1.setBackground(Color.WHITE);
		table_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		panel_produtos.add(table_1_1);
		JScrollPane scrollPane = new JScrollPane(table_1_1);
		scrollPane.setBounds(44, 51, 584, 393);
		frame.getContentPane().add(scrollPane);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(638, 108, 1, 2);
		frame.getContentPane().add(separator);
		
		table = new JTable();
		table.setBounds(67, 22, 1, 1);
		frame.getContentPane().add(table);
		
		textField = new JTextField();
		textField.setBounds(44, 19, 447, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(511, 17, 117, 23);
		frame.getContentPane().add(btnNewButton);
		
	//	panel.add()
		//frame.getContentPane().add(new JScrollPane(table_1));
		
	}
	public JFrame getFrame() {
		return frame;
	}

	

	public void popularTabela(Produto produto) {
		String[]linha= {
			produto.getNomeProduto(),
			produto.getDescricao(),
			String.valueOf(produto.getQuantidade()),
			String.valueOf(produto.getValor())
		};
		dm.addRow(linha);
	}
	
	 
	
	private void addRowActionPerformed(java.awt.event.ActionEvent ae) {
		String nomeProduto = txtNome.getText();
		String descricao = txtDescricao.getText();
		double valor = Validacao.converterDouble(txtPreco.getText()) ;
		int quantidade = Validacao.converterInteiro(txtQuantidade.getText());
		Produto p = new Produto(nomeProduto,descricao,valor,quantidade);
		popularTabela(p);
		//chamar a controler para se comunicar na DAO
		
		txtNome.setText("");
		txtDescricao.setText("");
		txtPreco.setText("");
		txtQuantidade.setText("");
	}
	
	private void removerActionPerformed(java.awt.event.ActionEvent ae) {
		dm.removeRow(table_1.getSelectedRow());
		
	}
}

