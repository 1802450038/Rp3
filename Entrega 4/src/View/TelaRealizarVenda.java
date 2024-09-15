package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import Model.Cliente;
import Model.Produto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Panel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;

public class TelaRealizarVenda {

	private JFrame frame;
	private JTextField txtQuantidade;
	private JTable table_1;
	private DefaultTableModel dm;
	private JComboBox comboBoxNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRealizarVenda window = new TelaRealizarVenda();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public TelaRealizarVenda() {
		initialize();
	}
	
	public Cliente capturarDadosCliente() {
		JTextField nome = new JTextField();
		JTextField cpf =new JTextField();
		
		Object [] mensagem = {
				"Nome: " , nome, "CPF: " , cpf
		};
		int option;
		option = JOptionPane.showConfirmDialog(null, mensagem, "Cliente", JOptionPane.OK_CANCEL_OPTION);
		if(option==JOptionPane.OK_CANCEL_OPTION) {
			Cliente c = new Cliente(nome.getText(),Long.parseLong(cpf.getText()));
			return c;
		}
		return null;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Menu Vendas");
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_formulario = new JPanel();
		panel_formulario.setBounds(653, 0, 231, 444);
		frame.getContentPane().add(panel_formulario);
		panel_formulario.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		lblNewLabel_2.setBounds(23, 139, 74, 14);
		panel_formulario.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Pre\u00E7o:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(23, 200, 46, 14);
		panel_formulario.add(lblNewLabel_3);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(23, 159, 98, 20);
		panel_formulario.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JButton btnAdicionar = new JButton("Incluir na compra");
		btnAdicionar.setBounds(10, 238, 211, 23);
		panel_formulario.add(btnAdicionar);
		
		JLabel lblNewLabel = new JLabel("Dados do produto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 23, 231, 29);
		panel_formulario.add(lblNewLabel);
		
		
		
		
		List <String> listagemProd = new ArrayList<>();
		listagemProd.add("tenis");
		listagemProd.add("Bola");
		listagemProd.add("xxxx");
		
		StringSearchable ss = new StringSearchable(listagemProd);
		
		comboBoxNome = new AutocompleteJComboBox(ss);
		comboBoxNome.setBounds(23, 93, 198, 22);
		panel_formulario.add(comboBoxNome);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Produto:");
		lblNewLabel_1.setBounds(23, 78, 126, 14);
		panel_formulario.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Finalizar compra");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capturarDadosCliente();
			}
		});
		btnNewButton.setBounds(56, 399, 134, 23);
		panel_formulario.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Pre\u00E7o Total:");
		lblNewLabel_4.setBounds(95, 363, 126, 14);
		panel_formulario.add(lblNewLabel_4);
		
		
		
		
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
		scrollPane.setBounds(44, 65, 584, 379);
		frame.getContentPane().add(scrollPane);
		
		
		
		
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
		String nomeProduto = comboBoxNome.getSelectedItem().toString();
		int quantidade = Validacao.converterInteiro(txtQuantidade.getText());
		Produto p = new Produto(nomeProduto,"descricao",45, quantidade);
		popularTabela(p);
		//chamar a controler para se comunicar na DAO
		
		comboBoxNome.setSelectedItem(null);
		txtQuantidade.setText("1");
	}
	
	private void removerActionPerformed(java.awt.event.ActionEvent ae) {
		dm.removeRow(table_1.getSelectedRow());
		
	}
	
	public class AutocompleteJComboBox extends JComboBox {
		
		private Searchable<String, String> searchable;

		public AutocompleteJComboBox(Searchable<String,String> s){

			super();

			this.searchable = s;

			setEditable(true);

			Component c = getEditor().getEditorComponent();

			if ( c instanceof JTextComponent ){

				final JTextComponent tc = (JTextComponent)c;

				tc.getDocument().addDocumentListener(new DocumentListener(){



					@Override

					public void changedUpdate(DocumentEvent arg0) {}



					@Override

					public void insertUpdate(DocumentEvent arg0) {

						update();

					}



					@Override

					public void removeUpdate(DocumentEvent arg0) {

						update();

					}

					

					public void update(){

						//perform separately, as listener conflicts between the editing component

						//and JComboBox will result in an IllegalStateException due to editing 

						//the component when it is locked. 

						SwingUtilities.invokeLater(new Runnable(){



							@Override

							public void run() {

								List<String> founds = new ArrayList<String>(searchable.search(tc.getText()));

								Set<String> foundSet = new HashSet<String>();

								for ( String s : founds ){

									foundSet.add(s.toLowerCase());

								}

								Collections.sort(founds);//sort alphabetically

								

								

								setEditable(false);

								removeAllItems();

								//if founds contains the search text, then only add once.

								if ( !foundSet.contains( tc.getText().toLowerCase()) ){

									addItem( tc.getText() );

								}

								

								for (String s : founds) {

									addItem(s);

								}
							
								setEditable(true);

								setPopupVisible(true);
								tc.requestFocus();


							}

							

						});

						

					}

					

				});

				//When the text component changes, focus is gained 

				//and the menu disappears. To account for this, whenever the focus

				//is gained by the JTextComponent and it has searchable values, we show the popup.

				tc.addFocusListener(new FocusListener(){



					@Override

					public void focusGained(FocusEvent arg0) {

						if ( tc.getText().length() > 0 ){

							setPopupVisible(true);

						}

					}



					@Override

					public void focusLost(FocusEvent arg0) {						

					}

					

				});

			}else{

				throw new IllegalStateException("Editing component is not a JTextComponent!");

			}

		}

	}

		
	}
	


