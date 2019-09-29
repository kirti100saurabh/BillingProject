package com.teleteach.billing.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.teleteach.billing.service.LoginService;

import javacode.Main4;

public class LoginView extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private static JFrame f;
	private JTextField loginId;
	private JPasswordField passwords;


	public static void main(String[] args) throws ParseException {
		/*ConnectToDataBase.main(null);
			Main4.setNimbus();*/
		create();
	}
	
	public static void create() throws ParseException {
		f = new JFrame("Login");
		f.getContentPane().add(new LoginView());
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();

		int w = 610, h = 300;
		f.setLocation(width / 2 - (w / 2), height / 2 - (h / 2));

		f.setSize(w, h);
		f.setVisible(true);
	}

	public LoginView() throws ParseException {
		
		// this is for background
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 271, 225);
		add(panel);
		panel.setLayout(null);
		
		// this is for setting label and field for login
		JLabel lblLogin = new JLabel("Login Id :");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogin.setBounds(26, 26, 104, 27);
		panel.add(lblLogin);
		
		loginId = new JTextField(16);
		loginId.setBounds(157, 30, 78, 20);
		panel.add(loginId);
		
		// this is for setting label and password field for login
		JLabel lblPassword = new JLabel("Password(DOB) :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(26, 82, 152, 27);
		panel.add(lblPassword);
		
		passwords = new JPasswordField(16);
		passwords.setBounds(157, 86, 78, 20);
		panel.add(passwords);	
		
		//button for login
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(157, 140, 78, 23);
		panel.add(btnLogin);
		
		//Event which is performed after login button clicked
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				String ids= loginId.getText();
				if (ids==null || ids.trim().length()==0){
	                JOptionPane.showMessageDialog(null,"Please enter your login Id.");

	                while(true){
	                	loginId.requestFocusInWindow();
	                    if(!(ids==null || ids.trim().length()==0))
	                        break;
	                }
	            }
				Integer id = Integer.parseInt(ids);
				@SuppressWarnings("deprecation")
				String password= passwords.getText();
				
							 
			LoginService loginService = new LoginService();
			int designation=loginService.validateAndGetDesignation(id, password);
			if (designation==1)
			{
				Main4.main(null);
			}
			System.out.println(designation);
			}
		});
			
	}

}
