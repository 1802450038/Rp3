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
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import Model.Venda;
import Model.ItemVenda;

public class TelaRelatorio {

	private JFrame frame;
	private JTable table_1;
	private DefaultTableModel dm;
	private double totalDiario =0;

	ArrayList<Venda>vendas;
	HashMap<Integer , ItemVenda>mapItens;
	
	public TelaRelatorio(ArrayList<Venda>vendas) {
		
		this.vendas=vendas;
		mapItens=new HashMap<Integer, ItemVenda> ();
		popularProdutos();
		initialize();
	}
	
	private void popularProdutos() {
		System.out.println("N VENDAS REL "+ vendas.size());
		for(Venda v:vendas) { // percorre todas as vendas 
			for(ItemVenda iv:v.getArrayItensVenda()){ // olha item a item 
				int idProduto = iv.getProduto().getId();
				int quantidadeVendida=0;
				if(mapItens.containsKey(idProduto)) { // verificação se item ja foi adicionado
					ItemVenda atual = mapItens.get(idProduto);
					quantidadeVendida = atual.getQuantidadeVendida()+iv.getQuantidadeVendida();
					atual.setQuantidadeVendida(quantidadeVendida);
				}else {
					mapItens.put(idProduto, iv);
				}
				
			}
		}
		System.out.println("N MAP  "+ mapItens.size());
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio window = new TelaRelatorio(null);
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
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Menu Gerente");
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		Panel panel_produtos = new Panel();
		panel_produtos.setBounds(0, 0, 10, 10);
		
		
		
		 String[] colunas = new String[] {
			"id","Produto Vendido", "Preço Unitário", "Quantidade Vendida", "Valor da Venda"

		        };
		 
		int qtdItens = mapItens.size();
		System.out.println("MAP: "+ qtdItens);
		 Object[][] produtos = new Object[qtdItens][5];
			 
		 int cont=0;
		 for(ItemVenda iv:mapItens.values()) {
			 produtos[cont][0]=iv.getProduto().getId();
			 produtos[cont][1]=iv.getProduto().getNomeProduto();
			 produtos[cont][3]=iv.getQuantidadeVendida();		
			 produtos[cont][2]=iv.getProduto().getValor();
			 double totalItem =iv.getQuantidadeVendida()*iv.getProduto().getValor(); 
			 produtos[cont][4]=totalItem;
			 totalDiario+=totalItem;
			 cont++;
			 
		 }
		 final Class[] columnClass = new Class[] {
		            Integer.class, String.class,Double.class, Integer.class, Double.class
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
		JTable table_1_1 = new JTable(model);
		table_1_1.setBackground(Color.WHITE);
		table_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		panel_produtos.add(table_1_1);
		JScrollPane scrollPane = new JScrollPane(table_1_1);
		scrollPane.setBounds(29, 71, 827, 290);
		frame.getContentPane().add(scrollPane);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(638, 108, 1, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Relat\u00F3rio de vendas do dia");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(299, 11, 302, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		//Concatenar com o valor total
		JLabel faturamento = new JLabel("Faturamento Di\u00E1rio:");
		faturamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		faturamento.setBounds(29, 372, 247, 50);
		faturamento.setText(faturamento.getText()+" R$ "+totalDiario);
		frame.getContentPane().add(faturamento);
		
		
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
	
	public void exibir() {
		frame.setVisible(true);
	}
	 
	
	}

