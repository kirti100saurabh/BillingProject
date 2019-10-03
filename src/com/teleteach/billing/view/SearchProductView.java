package com.teleteach.billing.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import com.teleteach.billing.service.ProductSearchService;
import com.teleteach.billing.vo.DisplayProductVO;
import com.teleteach.billing.vo.ProductSearchVO;

class SearchProductView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	static JFrame f;
	JButton search, backbtn;
	JTextField tf;
	private JTable j;
	Statement s;
	JComboBox<String> list;
	JScrollPane pane;
	JLabel bak;
	//JPanel bak;
	Vector<?> att, valu;
	String attr[] = { "pid", "pname" };
	private AbstractButton btnPrint;

	SearchProductView() 
	{
		super(new BorderLayout());
		getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"),"action");
		getActionMap().put("action", new AbstractAction() 
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				f.setVisible(false);
			}
		});
		
		bak = new JLabel(new ImageIcon(SearchProductView.class.getResource("/images/bak5.jpg")));
		add(bak);
		bak.setLayout(null);
		setSize(800, 600);
		JLabel l = new JLabel(new ImageIcon(SearchProductView.class.getResource("/images/searchpro.png")));
		l.setForeground(Color.yellow);
		l.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		l.setBounds(300, 20, 400, 100);
		bak.add(l);

		list = new JComboBox<String>(attr);
		list.setBounds(200, 200, 150, 30);
		bak.add(list);
		display();
		tf = new JTextField();
		tf.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		tf.setBounds(370, 200, 200, 30);
		bak.add(tf);

		
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ProductSearchVO> listSearchProduct= null;
				try {
					if (list.getSelectedItem().equals("pname")){
						ProductSearchService productSearchService = new ProductSearchService();
						 listSearchProduct = productSearchService.searchProductByName(tf.getText());
					}
					else if(list.getSelectedItem().equals("pid")){
						ProductSearchService productSearchService = new ProductSearchService();
						int productId = Integer.parseInt(tf.getText());
						listSearchProduct = productSearchService.searchProductById(productId);
					}
				
					/*String st = "SELECT pid,pname,name,avail,prate FROM available1 natural join product1 natural join company1 where "
							+ list.getSelectedItem() + "=" + tf.getText();

					if (list.getSelectedItem().equals("pname")) {
						st = "SELECT pid,pname,name,avail,prate FROM available1 natural join product1 natural join company1 where "
								+ list.getSelectedItem()
								+ " like '"
								+ tf.getText() + "%'";
					}
					if ((tf.getText()).length() <= 0) {
						st = "SELECT pid,pname,name,avail,prate FROM available1 natural join product1 natural join company1";
					}*/
					//s.execute(st);
					//ResultSet rs = s.getResultSet();

					j = new JTable();
					Vector<Vector<String>> vv = new Vector<Vector<String>>();
					Vector<String> v = new Vector<String>();
					Vector<String> sv = new Vector<String>();

					for (ProductSearchVO productSearchVO: listSearchProduct) 
					{
						System.out.println(productSearchVO);
						sv.add(productSearchVO.getProductId());
						sv.add(productSearchVO.getProductName());
						sv.add(productSearchVO.getSupplierName());
						sv.add(productSearchVO.getQuantity());
						sv.add(productSearchVO.getProductRate());
						
						vv.add(new Vector<String>(sv));
						sv.clear();
					}
					v.add("productId");
					v.add("productName");
					v.add("supplierName");
					v.add("quantity");
					v.add("productRate");

					j = new JTable(vv, v);
					pane.setVisible(false);
 					pane = new JScrollPane(j);
					pane.setBounds(200, 300, 550, 250);
					bak.add(pane);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		// bak.add(search);

		backbtn = new JButton("Exit");
		backbtn.setBounds(50, 450, 100, 30);
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				f.setVisible(false);
			}
		});
		bak.add(backbtn);
		
		btnPrint=new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				try
				{
					MessageFormat header=new MessageFormat("Report Print");
					MessageFormat footer=new MessageFormat("Page{0,number,integer}");
					j.print(JTable.PrintMode.NORMAL,header,footer);
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,
							"error " + e1.getMessage(), "error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPrint.setHorizontalAlignment(SwingConstants.CENTER);
		btnPrint.setIcon(new ImageIcon(SearchProductView.class.getResource("/images/print.PNG")));
		btnPrint.setBounds(600,200,100,30);
		bak.add(btnPrint);

	}

	public static void create() {
		f = new JFrame("S");
		f.add(new SearchProductView());

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();

		int w = 800, h = 600;
		f.setLocation(width / 2 - (w / 2), height / 2 - (h / 2));

		f.setSize(w, h);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		create();
	}

	public void display() {
		List<DisplayProductVO> listProduct= null;
		try {
			
			ProductSearchService productSearchService = new ProductSearchService();
			 listProduct = productSearchService.displayProduct();
						
			 j = new JTable();
				Vector<Vector<String>> vv = new Vector<Vector<String>>();
				Vector<String> v = new Vector<String>();
				Vector<String> sv = new Vector<String>();

				for (DisplayProductVO displayProductVO: listProduct) 
				{
					System.out.println(displayProductVO);
					
					sv.add(displayProductVO.getProductId());
					sv.add(displayProductVO.getProductName());
					sv.add(displayProductVO.getSupplierName());
					sv.add(displayProductVO.getAvailable());
					sv.add(displayProductVO.getProductRate());
					
					vv.add(new Vector<String>(sv));
					sv.clear();
				}
				v.add("productId");
				v.add("productName");
				v.add("supplierName");
				v.add("Available");
				v.add("productRate");

				j = new JTable(vv, v);
				pane = new JScrollPane(j);
				pane.setBounds(200, 300, 550, 250);
				bak.add(pane);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
	}
}
