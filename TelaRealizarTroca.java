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

public class TelaRealizarTroca {

	private JFrame frame;
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
					TelaRealizarTroca window = new TelaRealizarTroca();
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
	public TelaRealizarTroca() {
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
		
		JButton btnRemover = new JButton("Emitir cupom");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemover.setBounds(27, 196, 164, 23);
		panel_formulario.add(btnRemover);
		
		JLabel lblNewLabel = new JLabel("Cupom de troca");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 40, 231, 29);
		panel_formulario.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor do Cupom:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 104, 128, 29);
		panel_formulario.add(lblNewLabel_1);
		
		
		
		
		Panel panel_produtos = new Panel();
		panel_produtos.setBounds(0, 0, 10, 10);
		
		
		
		 String[] colunas = new String[] {
		            "Id", "Nome", "Descri��o", "Quantidade", "Valor"
		        };
		 Object[][] produtos = new Object[][] {
			 {1, "tenis", "para corrida", 1,  new Double(40.0)}
			 
			 
		 };
		 
		 final Class[] columnClass = new Class[] {
		            Integer.class, String.class,String.class, Double.class, Integer.class, Integer.class
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
				{new Integer(1), "tenis", "para corrida", new Double(40.0), 0 ,new Integer(1)},
			},
			new String[] {
				"Id", "Nome", "Descri\u00E7\u00E3o", "Valor","Quantidade", "Quantidade troca"
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
	

	}


