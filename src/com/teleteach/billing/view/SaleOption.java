package com.teleteach.billing.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import javacode.StockAndPurchase;





public class SaleOption extends JDialog{


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	protected JRadioButton rdbtnCheckStockAvailable;
	protected JRadioButton rdbtnPurchaseDetails;
	protected JButton cancelButton;
	protected JButton okButton;
	protected ActionListener action;
	static SaleOption dialog;


	public static void main(String[] args) {
		try {
			setNimbus();
			//ConnectToDataBase.main(null);
			create();

		} catch (Exception e) {
			e.printStackTrace();
		}
		//EventQueue.invokeLater(new Runnable() {
		//public void run() {

	}


		
	
	public static void create() {
		dialog= new SaleOption();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);

	}

	/*public SaleOption() {
		rdbtnCheckStockAvailable.setText("Registered Customer");
		rdbtnCheckStockAvailable.setMnemonic('r');

		rdbtnPurchaseDetails.setText("Other Customer");
		rdbtnPurchaseDetails.setMnemonic('o');

		okButton.removeActionListener(action);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnCheckStockAvailable.isSelected()){
					//Sale1.create();
				}
				else{
					SalesNonRegisteredCustomerView.create();

				}
				dialog.setVisible(false);
			}
		});

	}*/


	public static void setNimbus() {

		try 
		{
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
			{
                if ("Nimbus".equals(info.getName())) 
				{
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
		catch (ClassNotFoundException ex) 
		{
            java.util.logging.Logger.getLogger(SaleOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaleOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaleOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaleOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
	}
public SaleOption() {
		
		//addEscapeListener(this);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		int w = gd.getDisplayMode().getWidth();
		int h = gd.getDisplayMode().getHeight();
		setBounds(w/2-588/2, h/2-237/2, 493, 237);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new TitledBorder(null, "Choose Option", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		rdbtnCheckStockAvailable.setText("Registered Customer");
		rdbtnCheckStockAvailable.setMnemonic('r');

		rdbtnPurchaseDetails.setText("Other Customer");
		rdbtnPurchaseDetails.setMnemonic('o');

		okButton.removeActionListener(action);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnCheckStockAvailable.isSelected()){
					//Sale1.create();
				}
				else{
					SalesNonRegisteredCustomerView.create();

				}
				dialog.setVisible(false);
			}
		});

			{
				cancelButton = new JButton("");
			//	addMapToCancel();
				cancelButton.setBackground(Color.white);
				cancelButton.setIcon(new ImageIcon(StockAndPurchase.class.getResource("/images/delete-icon1.png")));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dialog.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
			//	buttonPane.add(cancelButton);
			}
		}
	}






