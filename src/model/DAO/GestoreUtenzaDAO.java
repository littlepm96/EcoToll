package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import model.components.Database;

public class GestoreUtenzaDAO {

	
	
	public String login(String username, String password) {
			
		
			Connection con = new Database().Connect();
			try {
				Statement st=con.createStatement();
				
ResultSet result=st.executeQuery("select * from amministratore where Username='"+username+"'and Password='"+password+"'");
				
				if(result.next()) {
					System.out.println(username);
					System.out.println(password);
					JOptionPane.showMessageDialog(null, "credenziali corrette");
					return "amministratore";
					
			}else {	JOptionPane.showMessageDialog(null, "Login error: credenziali errate");
			System.out.println("ERRLOG "+username);
			System.out.println("ERRLOG "+password);}
				


			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "sql error");
				e.printStackTrace();
			}
			
			
			return "";
		}

}
