package com.teleteach.billing.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	
	private String driverName;
	private String url;
	private String userName;
	private String password;
	
	
	public DataSource(){
		loadDbProperties();
	}
	
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(driverName);
		Connection con=DriverManager.getConnection(url,userName,password);
		return con;
		
	}
	
	private void loadDbProperties(){
		try{
			InputStream input = new FileInputStream("C:/Users/Sanat Mishra/workspace/BillingProjectOld/src/resource/application-DEV.properties");
			Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and assign to variable 
            this.driverName = prop.getProperty("billing.db.driver.name");
            this.url= prop.getProperty("billing.db.url");
            this.userName= prop.getProperty("billing.db.username");
            this.password= prop.getProperty("billing.db.password");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

}
