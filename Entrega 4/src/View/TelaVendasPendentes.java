package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import Controler.VendaControler;
import Model.ItemVenda;
import Model.Produto;
import Model.Venda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Panel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaVendasPendentes {

	private JFrame frame;
	private JTable table_1;
	private DefaultTableModel dm;
	ArrayList<Venda> vendasPendentes;
	private VendaControler vendaControler;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVendasPendentes window = new TelaVendasPendentes(null);
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

	public TelaVendasPendentes(ArrayList<Venda> vendas) {
		this.vendasPendentes = vendas;
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Vendas Pendentes");
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Panel panel_produtos = new Panel();
		panel_produtos.setBounds(0, 0, 10, 10);

		String[] colunas = new String[] { "Id", "Nome do cliente", "Data", "Valor total"

		};

		Object[][] venda = new Object[vendasPendentes.size()][4];

		int cont = 0;

		for (Venda ven : vendasPendentes) {
			venda[cont][0] = ven.getId();
			venda[cont][1] = ven.getCliente().getNome();
			venda[cont][2] = ven.getDataVenda();
			venda[cont][3] = ven.getVendaTotal();
			cont++;
		}

		final Class[] columnClass = new Class[] { Integer.class, String.class, long.class, String.class, Double.class };

		DefaultTableModel model = new DefaultTableModel(venda, colunas) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnClass[columnIndex];
			}
		};
		frame.getContentPane().add(panel_produtos);
		JTable table = new JTable(model);
		table.setBackground(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int idVenda = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				for(Venda v: vendasPendentes) {
					if(idVenda == v.getId()){
						vendaControler.exibirVendaAFaturar(v);
						
					}
				}
			}
		});
		
		panel_produtos.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Venda v = new Venda();
				TelaFaturarVenda tf = new TelaFaturarVenda(v);

			}
		});
		scrollPane.setBounds(29, 71, 827, 290);
		frame.getContentPane().add(scrollPane);

		JSeparator separator = new JSeparator();
		separator.setBounds(638, 108, 1, 2);
		frame.getContentPane().add(separator);

		JLabel lblNewLabel_1 = new JLabel("Vendas Pendentes");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(299, 11, 302, 34);
		frame.getContentPane().add(lblNewLabel_1);
	}

	// panel.add()
	// frame.getContentPane().add(new JScrollPane(table_1));

	public JFrame getFrame() {
		return frame;
	}

	public void popularTabela(Produto produto) {
		String[] linha = { produto.getNomeProduto(), produto.getDescricao(), String.valueOf(produto.getQuantidade()),
				String.valueOf(produto.getValor()) };
		dm.addRow(linha);
	}

	public void exibir() {
		frame.setVisible(true);

	}

	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
		JTable source = (JTable) evt.getSource();
		int row = source.rowAtPoint(evt.getPoint());
		int column = source.columnAtPoint(evt.getPoint());
		String s = source.getModel().getValueAt(row, column) + "";

		JOptionPane.showMessageDialog(null, s);

	}

	public void setControlerVenda(VendaControler vendaControler) {
		this.vendaControler = vendaControler;
		
	}

}
