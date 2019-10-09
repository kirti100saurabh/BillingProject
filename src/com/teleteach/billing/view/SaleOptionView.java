package com.teleteach.billing.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JRadioButton;

public class SaleOptionView extends StockAndPurchaseView{

	
	JRadioButton rbtnRegularCust,rbtnOthCust; 
	private static final long serialVersionUID = 1L;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard.setNimbus();
				//	ConnectToDataBase.main(null);
					create();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			
		});
	}
	public static void create() {
		dialog= new SaleOptionView();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		
	}
	
	public SaleOptionView() {
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
	
	}


}
